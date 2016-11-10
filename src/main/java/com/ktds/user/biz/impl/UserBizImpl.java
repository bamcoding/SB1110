package com.ktds.user.biz.impl;

import com.ktds.admin.operation.history.dao.OperationHistoryDao;
import com.ktds.common.util.SHA256Util;
import com.ktds.user.biz.UserBiz;
import com.ktds.user.dao.UserDao;
import com.ktds.user.vo.UserVO;

public class UserBizImpl implements UserBiz {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public boolean txSignUp(UserVO userVO) {
		// SALT 난수 생성
		String salt = SHA256Util.generateSalt();
		
		// 사용자가 입력한 비밀번호 가져옴
		String password = userVO.getUserHashedPassword();
		
		// 사용자가 입력한 비밀번호를 SALT와 SHA-256으로 암호화 함
		password = SHA256Util.getEncrypt(password, salt);
		
		// 암호화된 패스워드를 갱신 입력
		userVO.setUserHashedPassword(password);
		userVO.setUserSalt(salt);
		
		return userDao.txSignUp(userVO) > 0;
	}
	
	@Override
	public UserVO doLogin(UserVO userVO) {
		
		// SALT 난수 가져옴
		String salt = userDao.getSaltByUserId(userVO.getUserId());
		
		// 사용자가 입력한 비밀번호 가져옴
		String password = userVO.getUserHashedPassword();
		
		// 사용자가 입력한 비밀번호를 SALT와 SHA-256으로 암호화 함
		password = SHA256Util.getEncrypt(password, salt);
		
		// 암호화된 패스워드를 갱신 입력
		userVO.setUserHashedPassword(password);
		userVO.setUserSalt(salt);
		
		return userDao.getUser(userVO);
	}

	@Override
	public boolean updatePoint(String userId, int point) {
		return userDao.updatePoint(userId, point)>0;
	}
}
