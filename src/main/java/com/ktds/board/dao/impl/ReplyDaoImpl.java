package com.ktds.board.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.board.dao.ReplyDao;
import com.ktds.board.vo.ReplyVO;

public class ReplyDaoImpl extends SqlSessionDaoSupport implements ReplyDao{

	@Override
	public int addReply(ReplyVO reply) {
		return getSqlSession().insert("replyDao.addReply", reply);
	}

	@Override
	public List<ReplyVO> getAllReply(String boardId) {
		return getSqlSession().selectList("replyDao.getAllReply", boardId);
	}

}
