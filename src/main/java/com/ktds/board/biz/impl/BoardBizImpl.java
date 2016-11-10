package com.ktds.board.biz.impl;

import com.ktds.admin.operation.history.dao.OperationHistoryDao;
import com.ktds.board.biz.BoardBiz;
import com.ktds.board.dao.BoardDao;
import com.ktds.board.vo.BoardListVO;
import com.ktds.board.vo.BoardSearchVO;
import com.ktds.board.vo.BoardVO;
import com.ktds.common.util.pager.Pager;
import com.ktds.common.util.pager.PagerFactory;

public class BoardBizImpl implements BoardBiz {

	private BoardDao boardDao;
	
	private OperationHistoryDao operationHistoryDao;

	public void setOperationHistoryDao(OperationHistoryDao operationHistoryDao) {
		this.operationHistoryDao = operationHistoryDao;
	}

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public BoardListVO getAllBoards(BoardSearchVO searchVO) {
		int count = boardDao.getBoardCount(searchVO);

		Pager pager = PagerFactory.getPager(Pager.ORACLE);
		pager.setPageNumber(searchVO.getPageNumber());
		pager.setTotalArticleCount(count);
		searchVO.setStartNumber(pager.getStartArticleNumber());
		searchVO.setEndNumber(pager.getEndArticleNumber());
		//페이징 쿼리를 써주기 위해서
		
		BoardListVO boardList = new BoardListVO();
		boardList.setBoardList(boardDao.getAllBoards(searchVO));
		boardList.setPager(pager);
		
		return boardList;
	}

	@Override
	public boolean deleteBoard(String boardId) {
		return boardDao.deleteBoard(boardId) >0;
	}

	@Override
	public boolean addBoard(BoardVO board) {
		return boardDao.addBoard(board) > 0;
	}
	
	
	@Override
	public BoardVO getBoardBy(String boardId, String userId) {
		BoardVO boards = boardDao.getBoardBy(boardId);
		if(operationHistoryDao.getHistoryById(boardId, userId) == 0) {
			if(!userId.equals(boards.getUserId())){
				boardDao.updateHitCount(boardId);		
			}
		}
		operationHistoryDao.addReadHistory(boardId,userId); 
		return boards;
	}

	@Override
	public BoardVO getFileNames(String boardId) {
		return boardDao.getBoardBy(boardId);
	}
	
	@Override
	public BoardVO getBoardForDelete(String boardId) {
		return boardDao.getBoardBy(boardId);
	}

	
	
	@Override
	public BoardVO getBoardForInfo(String boardId) {
		return boardDao.getBoardBy(boardId);
	}
}
