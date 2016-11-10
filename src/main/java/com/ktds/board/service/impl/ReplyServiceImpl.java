package com.ktds.board.service.impl;

import java.util.List;

import com.ktds.board.biz.ReplyBiz;
import com.ktds.board.service.ReplyService;
import com.ktds.board.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService{

	private ReplyBiz replyBiz;

	public void setReplyBiz(ReplyBiz replyBiz) {
		this.replyBiz = replyBiz;
	}

	@Override
	public boolean addReply(ReplyVO reply) {
		return replyBiz.addReply(reply);
	}

	@Override
	public List<ReplyVO> getAllReply(String boardId) {
		return replyBiz.getAllReply(boardId);
	}
	
	
}
