package com.ktds.board.service;

import java.util.List;

import com.ktds.board.vo.ReplyVO;

public interface ReplyService {

	public boolean addReply(ReplyVO reply);

	public List<ReplyVO> getAllReply(String boardId);

}
