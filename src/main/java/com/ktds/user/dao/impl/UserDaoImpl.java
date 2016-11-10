package com.ktds.user.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.user.dao.UserDao;
import com.ktds.user.vo.UserVO;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public int txSignUp(UserVO userVO) {
		return getSqlSession().insert("userDao.txSignUp", userVO);
	}
	
	@Override
	public String getSaltByUserId(String userId) {
		return getSqlSession().selectOne("userDao.getSaltByUserId", userId);
	}
	
	@Override
	public UserVO getUser(UserVO userVO) {
		return getSqlSession().selectOne("userDao.getUser", userVO);
	}
	@Override
	public int updatePoint(String userId, int point) {
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("userId", userId);
		parameter.put("point", point);
		return getSqlSession().update("userDao.updatePoint",parameter);
	}
}
