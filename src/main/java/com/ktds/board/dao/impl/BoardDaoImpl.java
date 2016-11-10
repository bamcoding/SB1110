package com.ktds.board.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.board.dao.BoardDao;
import com.ktds.board.vo.BoardSearchVO;
import com.ktds.board.vo.BoardVO;

public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao {

	@Override
	public List<BoardVO> getAllBoards(BoardSearchVO searchVO) {
		return getSqlSession().selectList("boardDao.getAllBoards", searchVO);
	}

	@Override
	public int deleteBoard(String boardId) {
		return getSqlSession().delete("boardDao.deleteBoard",boardId);
	}

	@Override
	public int addBoard(BoardVO board) {
		return getSqlSession().insert("boardDao.addBoard", board);
	}
	
	@Override
	public BoardVO getBoardBy(String boardId) {
		return getSqlSession().selectOne("boardDao.getBoardBy", boardId);
	}

	@Override
	public int updateHitCount(String boardId) {
		return getSqlSession().update("boardDao.updateHitCount", boardId);
	}
	
	
	


	@Override
	public int getBoardCount(BoardSearchVO searchVO) {
		return getSqlSession().selectOne("boardDao.getBoardCount", searchVO);
	}
	
	
	
	
	
}
