package com.ktds.board.dao;

import java.util.List;

import com.ktds.board.vo.ReplyVO;

public interface ReplyDao {

	public int addReply(ReplyVO reply);

	public List<ReplyVO> getAllReply(String boardId);

}
