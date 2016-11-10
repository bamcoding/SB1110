package com.ktds.common.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ktds.user.dao.UserDao;
import com.ktds.user.vo.UserVO;

public class PointIntercepter extends HandlerInterceptorAdapter {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("_USER_");
		
		userVO = userDao.getUser(userVO);
		session.setAttribute("_USER_", userVO);

		return true;
	}

}
