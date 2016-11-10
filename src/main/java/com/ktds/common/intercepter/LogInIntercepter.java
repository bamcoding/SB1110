package com.ktds.common.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ktds.user.vo.UserVO;

public class LogInIntercepter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("_USER_");
		if(user == null){
			response.sendRedirect("/SimpleBoard/login");
		}
		
		return true;
	}
	
}
