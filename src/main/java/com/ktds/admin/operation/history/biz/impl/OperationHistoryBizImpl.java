package com.ktds.admin.operation.history.biz.impl;

import com.ktds.admin.operation.history.biz.OperationHistoryBiz;
import com.ktds.admin.operation.history.dao.OperationHistoryDao;
import com.ktds.admin.operation.history.vo.OperationHistoryVO;

public class OperationHistoryBizImpl implements OperationHistoryBiz {

	private OperationHistoryDao operationHistoryDao;

	public void setOperationHistoryDao(OperationHistoryDao operationHistoryDao) {
		this.operationHistoryDao = operationHistoryDao;
	}
	
	@Override
	public boolean getHistoryById(String userId, String boardId) {
		return operationHistoryDao.getHistoryById(boardId, userId) > 0;
	}

	@Override
	public boolean addAllHistory(OperationHistoryVO operationHistoryVO) {
		return operationHistoryDao.addAllHistory(operationHistoryVO) > 0;
	}
	
}
