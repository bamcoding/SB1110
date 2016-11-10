package com.ktds.admin.operation.history.service.impl;

import com.ktds.admin.operation.history.biz.OperationHistoryBiz;
import com.ktds.admin.operation.history.service.OperationHistoryService;

public class OperationHistoryServiceImpl implements OperationHistoryService {

	private OperationHistoryBiz operationHistoryBiz;

	public void setOperationHistoryBiz(OperationHistoryBiz operationHistoryBiz) {
		this.operationHistoryBiz = operationHistoryBiz;
	}
	
	
}
