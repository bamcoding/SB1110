package com.ktds.board.dao;

import java.util.List;

import com.ktds.board.vo.BoardSearchVO;
import com.ktds.board.vo.BoardVO;

public interface BoardDao {

	public List<BoardVO> getAllBoards(BoardSearchVO searchVO);

	public int deleteBoard(String boardId);

	public int addBoard(BoardVO board);

	public BoardVO getBoardBy(String boardId);

	public int updateHitCount(String boardId);

	public int getBoardCount(BoardSearchVO searchVO);
}
