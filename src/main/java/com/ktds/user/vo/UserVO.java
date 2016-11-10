package com.ktds.user.vo;

public class UserVO {

	private String userId;
	private String userHashedPassword;
	private String userSalt;
	private String userNickName;
	private String createdDate;
	private int point;

	/**
	 * 로그인 페이지에서 "아이디 기억하기" 체크 박스의 값을 저장한다.
	 */
	private boolean rememberUserId;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserHashedPassword() {
		return userHashedPassword;
	}

	public void setUserHashedPassword(String userHashedPassword) {
		this.userHashedPassword = userHashedPassword;
	}

	public String getUserSalt() {
		return userSalt;
	}

	public void setUserSalt(String userSalt) {
		this.userSalt = userSalt;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

//	/**
//	 * EL에서 사용할 Getter
//	 * @return
//	 */
//	public boolean getRememberUserId() {
//		return rememberUserId;
//	}
	
	public boolean isRememberUserId() {
		return rememberUserId;
	}

	public void setRememberUserId(boolean rememberUserId) {
		this.rememberUserId = rememberUserId;
	}
	
	

}
