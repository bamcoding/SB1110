package com.ktds.board.service;

import javax.servlet.http.HttpSession;

import com.ktds.board.vo.BoardListVO;
import com.ktds.board.vo.BoardSearchVO;
import com.ktds.board.vo.BoardVO;

public interface BoardService {

	public BoardListVO getAllBoards(BoardSearchVO boardSearchVO);

	public boolean deleteBoard(String boardId, HttpSession session);

	public boolean addBoard(BoardVO board, HttpSession session);

	public BoardVO getBoardBy(String boardId, HttpSession session);

	public BoardVO getFileNames(String boardId, HttpSession session);


}
