package com.ktds.board.biz.impl;

import java.util.List;

import com.ktds.board.biz.ReplyBiz;
import com.ktds.board.dao.ReplyDao;
import com.ktds.board.vo.ReplyVO;

public class ReplyBizImpl implements ReplyBiz{

	private ReplyDao replyDao;
	
	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	@Override
	public boolean addReply(ReplyVO reply) {
		return replyDao.addReply(reply) > 0;
	}

	@Override
	public List<ReplyVO> getAllReply(String boardId) {
		return replyDao.getAllReply(boardId);
	}
}
