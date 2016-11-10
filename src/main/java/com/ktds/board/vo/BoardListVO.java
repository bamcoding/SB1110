package com.ktds.board.vo;

import java.util.List;

import com.ktds.common.util.pager.Pager;

public class BoardListVO {

	private List<BoardVO> boardList;
	
	private Pager pager;
	
	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public List<BoardVO> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<BoardVO> boardList) {
		this.boardList = boardList;
	}

}
