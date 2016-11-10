package com.ktds.board.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.ktds.admin.operation.history.biz.OperationHistoryBiz;
import com.ktds.board.biz.BoardBiz;
import com.ktds.board.service.BoardService;
import com.ktds.board.vo.BoardListVO;
import com.ktds.board.vo.BoardSearchVO;
import com.ktds.board.vo.BoardVO;
import com.ktds.user.biz.UserBiz;
import com.ktds.user.vo.UserVO;

public class BoardServiceImpl implements BoardService {

	private BoardBiz boardBiz;
	private UserBiz userBiz;
	private OperationHistoryBiz operationHistoryBiz; 

	public void setOperationHistoryBiz(OperationHistoryBiz operationHistoryBiz) {
		this.operationHistoryBiz = operationHistoryBiz;
	}

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	public void setBoardBiz(BoardBiz boardBiz) {
		this.boardBiz = boardBiz;
	}

	@Override
	public BoardListVO getAllBoards(BoardSearchVO boardSearchVO) {
		return boardBiz.getAllBoards(boardSearchVO);
	}

	@Override
	public boolean deleteBoard(String boardId, HttpSession session) {
		UserVO user = (UserVO) session.getAttribute("_USER_");
		BoardVO boards = boardBiz.getBoardForDelete(boardId);
		if(user.getUserId().equals(boards.getUserId())) {
			return boardBiz.deleteBoard(boardId);
		}
		return false;
	}

	@Override
	public boolean addBoard(BoardVO board, HttpSession session) {

		MultipartFile uploadFile = board.getFileUpload();
		if (!uploadFile.isEmpty()) {
			File dir = new File("d:" + File.separator + "uploadfile2");
			if (!dir.exists()) {
				dir.mkdirs();
			}
			String uploadPath = dir.getAbsolutePath();
			String encryptFileName = UUID.randomUUID().toString();
			String realFileName = uploadFile.getOriginalFilename();

			File file = new File(uploadPath + File.separator + encryptFileName);
			try {
				uploadFile.transferTo(file);
			} catch (IllegalStateException e) {
				throw new RuntimeException(e.getMessage(), e);
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
			board.setDisplayFileName(realFileName);
			board.setRealFileName(encryptFileName);
		}
		

		UserVO user = (UserVO) session.getAttribute("_USER_");
		String userId = user.getUserId();
		userBiz.updatePoint(userId, 10);
		board.setUserId(userId);

		return boardBiz.addBoard(board);
	}

	@Override
	public BoardVO getBoardBy(String boardId, HttpSession session) {

		UserVO user = (UserVO) session.getAttribute("_USER_");
		BoardVO boards = boardBiz.getBoardForInfo(boardId);
		String userId = user.getUserId();
		if (!operationHistoryBiz.getHistoryById(userId, boardId)) {
			if(!userId.equals(boards.getUserId())){
				userBiz.updatePoint(userId, -5);
			}
		}
		
		return boardBiz.getBoardBy(boardId, userId);
	}

	@Override
	public BoardVO getFileNames(String boardId, HttpSession session) {
		
		UserVO user = (UserVO) session.getAttribute("_USER_");
		BoardVO boards = boardBiz.getBoardForInfo(boardId);
		String userId = user.getUserId();
		if(!userId.equals(boards.getUserId())) {
			userBiz.updatePoint(userId, -3);
		}
		return boardBiz.getFileNames(boardId);
	}

}
