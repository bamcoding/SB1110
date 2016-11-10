package com.ktds.admin.operation.history.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ktds.admin.operation.history.service.OperationHistoryService;

@Controller
public class OperationHistoryController {
	
	private OperationHistoryService operationHistoryService;

	public void setOperationHistoryService(OperationHistoryService operationHistoryService) {
		this.operationHistoryService = operationHistoryService;
	}
	

	
	
}
