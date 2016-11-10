package com.ktds.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ktds.user.vo.UserVO;

public interface UserService {

	public boolean txSignUp(UserVO userVO);

	public boolean doLogin(UserVO userVO, HttpServletRequest request);

	
}
