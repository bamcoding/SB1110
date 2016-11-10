package com.ktds.admin.operation.history.biz;

import com.ktds.admin.operation.history.vo.OperationHistoryVO;

public interface OperationHistoryBiz {

	public boolean getHistoryById(String userId, String boardId);

	public boolean addAllHistory(OperationHistoryVO operationHistoryVO);
}
