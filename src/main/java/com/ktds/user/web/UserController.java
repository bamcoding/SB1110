package com.ktds.user.web;

import static com.ktds.common.util.CookieUtil.addCookie;
import static com.ktds.common.util.CookieUtil.getCookie;
import static com.ktds.common.util.CookieUtil.removeCookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.user.service.UserService;
import com.ktds.user.vo.UserVO;

@Controller
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/login")
	public ModelAndView viewLoginPage(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();

		view.addObject("_USER_ID_", getCookie(request, "_USER_ID_"));
		view.addObject("_REMEMBER_YN_", getCookie(request, "_REMEMBER_YN_"));

		view.setViewName("user/login");
		return view;
	}

	@RequestMapping("/doLogin")
	public ModelAndView doLoginAction(UserVO userVO, HttpServletResponse response, HttpServletRequest request) {
		ModelAndView view = new ModelAndView();

		boolean isSuccess = userService.doLogin(userVO, request);
		logger.info(isSuccess+"");
		/*
		 * 쿠키를 만들어 브라우저에게 보낼 때 필요한 클래스 3가지 1. HttpServletRequest 2.
		 * HttpServletResponse 3. Cookie
		 */
		if ( isSuccess ) {
			// 1. 사용자가 "아이디 기억하기"를 체크했는지 확인한다.
			if (userVO.isRememberUserId()) {
				// 2. "아이디 기억하기"를 체크했다면, 쿠키를 굽는다.
				addCookie(response, "_USER_ID_", userVO.getUserId());
				addCookie(response, "_REMEMBER_YN_", "Y");
			} else {
				// 2. "아이디 기억하기"를 체크해제 했다면, 쿠키를 지운다.
				removeCookie(response, "_USER_ID_");
				removeCookie(response, "_REMEMBER_YN_");
			}
			view.setViewName("redirect:/board");
		}
		else {
			view.setViewName("redirect:/login");
		}

		return view;
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String viewSignUpPage() {
		return "user/signUp";
	}

	@RequestMapping(value = "/doSignUp", method = RequestMethod.POST)
	public ModelAndView doSignUp(UserVO userVO) {

		boolean isSuccess = userService.txSignUp(userVO);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/login");
		return view;
	}

}
