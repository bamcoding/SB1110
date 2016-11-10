package com.ktds.user.biz;

import com.ktds.user.vo.UserVO;

public interface UserBiz {

	public boolean txSignUp(UserVO userVO);

	public UserVO doLogin(UserVO userVO);

	public boolean updatePoint(String userId, int point);
}
