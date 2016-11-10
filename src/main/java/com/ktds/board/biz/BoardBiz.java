package com.ktds.board.biz;

import com.ktds.board.vo.BoardListVO;
import com.ktds.board.vo.BoardSearchVO;
import com.ktds.board.vo.BoardVO;

public interface BoardBiz {

	public BoardListVO getAllBoards(BoardSearchVO boardSearchVO);

	public boolean deleteBoard(String boardId);

	public boolean addBoard(BoardVO board);

	public BoardVO getBoardBy(String boardId, String userId);

	public BoardVO getFileNames(String boardId);

	public BoardVO getBoardForDelete(String boardId);


	public BoardVO getBoardForInfo(String boardId);
	
	
}
