package com.ktds.user.dao;

import com.ktds.user.vo.UserVO;

public interface UserDao {

	public int txSignUp(UserVO userVO);

	public String getSaltByUserId(String userId);

	public UserVO getUser(UserVO userVO);

	public int updatePoint(String userId, int point);

}
