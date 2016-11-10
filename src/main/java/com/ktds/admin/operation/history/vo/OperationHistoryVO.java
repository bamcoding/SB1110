package com.ktds.admin.operation.history.vo;

import com.ktds.admin.operation.history.Message;

public class OperationHistoryVO {

	private String operationHistoryId;
	private String userId;
	private String operation;
	private String ip;
	private String createdDate;
	private String operationType;

	public String getOperationHistoryId() {
		return operationHistoryId;
	}

	public void setOperationHistoryId(String operationHistoryId) {
		this.operationHistoryId = operationHistoryId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public static OperationHistoryVO createLoginSuccessHistory(
			String userId, String ip) {
		OperationHistoryVO operationHistoryVO = new OperationHistoryVO();
		operationHistoryVO.setUserId(userId);
		operationHistoryVO.setIp(ip);
		operationHistoryVO.setOperationType("USER");
		
		String message = String.format(Message.LOGIN_SUCCESS, userId);
		operationHistoryVO.setOperation(message);
		
		return operationHistoryVO;
	}
	
	public static OperationHistoryVO createLoginFailHistory(String userId,String ip){
		OperationHistoryVO operationHistoryVO = new OperationHistoryVO();
		operationHistoryVO.setUserId(userId);
		operationHistoryVO.setIp(ip);
		operationHistoryVO.setOperationType("USER");
		
		String message = String.format(Message.LOGIN_FAIL, userId);
		operationHistoryVO.setOperation(message);
		
		return operationHistoryVO;
		
	}
	
}











