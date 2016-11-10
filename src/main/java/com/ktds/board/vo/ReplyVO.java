package com.ktds.board.vo;

import com.ktds.user.vo.UserVO;

public class ReplyVO {

	private String replyId;
	private String boardId;
	private String userId;
	private String parentReplyId;
	private String reply;
	private String createdDate;

	private UserVO user;
	private BoardVO board;
	private ReplyVO parent;
	
	private int level;
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public String getBoardId() {
		return boardId;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getParentReplyId() {
		return parentReplyId;
	}

	public void setParentReplyId(String parentReplyId) {
		this.parentReplyId = parentReplyId;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	public BoardVO getBoard() {
		return board;
	}

	public void setBoard(BoardVO board) {
		this.board = board;
	}

	public ReplyVO getParent() {
		return parent;
	}

	public void setParent(ReplyVO parent) {
		this.parent = parent;
	}

}
