package com.ktds.user.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktds.admin.operation.history.biz.OperationHistoryBiz;
import com.ktds.admin.operation.history.vo.OperationHistoryVO;
import com.ktds.user.biz.UserBiz;
import com.ktds.user.service.UserService;
import com.ktds.user.vo.UserVO;

public class UserServiceImpl implements UserService {

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private UserBiz userBiz;
	
	private OperationHistoryBiz operationHistoryBiz;

	public void setOperationHistoryBiz(OperationHistoryBiz operationHistoryBiz) {
		this.operationHistoryBiz = operationHistoryBiz;
	}

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	@Override
	public boolean txSignUp(UserVO userVO) {
		return userBiz.txSignUp(userVO);
	}
	
	@Override
	public boolean doLogin(UserVO userVO, HttpServletRequest request) {
		
		UserVO loginUser = userBiz.doLogin(userVO);
		HttpSession session = request.getSession();
				
		if ( loginUser != null ) {
			OperationHistoryVO operationHistoryVO =
					OperationHistoryVO.createLoginSuccessHistory(userVO.getUserId(),request.getRemoteAddr() );
			session.setAttribute("_USER_", loginUser);
			operationHistoryBiz.addAllHistory(operationHistoryVO);
		}
		else{
			OperationHistoryVO operationHistoryVO =
					OperationHistoryVO.createLoginFailHistory(userVO.getUserId(),request.getRemoteAddr() );
			operationHistoryBiz.addAllHistory(operationHistoryVO);
		}
		
		
		
		
		return loginUser != null;
	}
	
}
