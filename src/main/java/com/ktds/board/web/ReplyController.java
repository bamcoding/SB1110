package com.ktds.board.web;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.board.service.ReplyService;
import com.ktds.board.vo.ReplyVO;

@Controller
public class ReplyController {

	private ReplyService replyService;

	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	
	@RequestMapping("/addReply/{boardId}")
	@ResponseBody
	public List<ReplyVO> doAddReplyAction(@PathVariable String boardId, ReplyVO reply){
		
		reply.setBoardId(boardId);
		boolean isSuccess = replyService.addReply(reply);
		return getAllReplyAction(boardId);
	}
	
	@RequestMapping("/reply/{boardId}")
	@ResponseBody
	public List<ReplyVO> getAllReplyAction(@PathVariable String boardId){
		List<ReplyVO> replyList = replyService.getAllReply(boardId);
		return replyList;
	}
	
	
	
	
}
