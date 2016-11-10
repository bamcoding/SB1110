package com.ktds.admin.operation.history.biz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.ktds.admin.operation.history.biz.impl.OperationHistoryBizImpl;
import com.ktds.admin.operation.history.vo.OperationHistoryVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/rootContext.xml",
									"file:src/main/webapp/WEB-INF/spring/operationHistoryContext.xml"})
public class OperationHistoryBizImplTest {
	
	@Autowired
	private OperationHistoryBiz operationHistoryBiz;

	@Test
	public void addAllHistoryTest() {
		OperationHistoryVO operationHistoryVO = 
				OperationHistoryVO.createLoginFailHistory("Min", "10.225.152.163");
		
		boolean isSuccess = operationHistoryBiz.addAllHistory(operationHistoryVO);
		Assert.isTrue(isSuccess);
	}
	
	@Test
	public void addAllHistoryTestTwo() {
		OperationHistoryVO operationHistoryVO = 
				OperationHistoryVO.createLoginSuccessHistory("admin", "10.225.152.181");
		
		boolean isSuccess = operationHistoryBiz.addAllHistory(operationHistoryVO);
		Assert.isTrue(isSuccess);
	}
	
}
