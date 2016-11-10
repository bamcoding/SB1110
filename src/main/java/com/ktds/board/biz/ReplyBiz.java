package com.ktds.board.biz;

import java.util.List;

import com.ktds.board.vo.ReplyVO;

public interface ReplyBiz {

	public boolean addReply(ReplyVO reply);

	public List<ReplyVO> getAllReply(String boardId);

}
