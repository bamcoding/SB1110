package com.ktds.board.web;

import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.board.service.BoardService;
import com.ktds.board.vo.BoardListVO;
import com.ktds.board.vo.BoardSearchVO;
import com.ktds.board.vo.BoardVO;
import com.ktds.common.util.DownloadUtil;
import com.ktds.common.util.pager.ClassicPageExplorer;
import com.ktds.common.util.pager.PageExplorer;
import com.ktds.user.vo.UserVO;

@Controller
public class BoardController {

	private BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/board")
	public ModelAndView viewListPage(BoardSearchVO boardSearchVO) {
		
		BoardListVO boardList = boardService.getAllBoards(boardSearchVO);
		 
		PageExplorer pageExplorer2 = new ClassicPageExplorer(boardList.getPager());
		String page2 = pageExplorer2.getPagingList("pageNumber", "[@]", "이전", "다음", "searchForm");
		
		ModelAndView view = new ModelAndView();
		view.setViewName("board/list");
		view.addObject("boardList", boardList);
		view.addObject("page2", page2);
		view.addObject("boardSearchVO", boardSearchVO);
		return view;
	}
	
	@RequestMapping("/boardDetail/{boardId}")
	public ModelAndView viewDetailPage(@PathVariable String boardId, HttpSession session){
		
		UserVO userVO = (UserVO) session.getAttribute("_USER_");
		
		ModelAndView view = new ModelAndView();
		
		if (userVO.getPoint() < 5){
			
			view.setViewName("redirect:/board?error=error");
			
		}
		else{
			
			BoardVO board = boardService.getBoardBy(boardId, session);
			view.setViewName("board/detail");
			view.addObject("board",board);
		}
		
		return view;
	}
	
	@RequestMapping("/viewFile/{boardId}")
	public void viewFile(@PathVariable String boardId, HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("_USER_");
		
		if( userVO.getPoint() < 3 ){
			
			return;
			
		}
		
		BoardVO board = boardService.getFileNames(boardId, request.getSession());
		DownloadUtil downloadFile = DownloadUtil.getInstance("d:" + File.separator + "uploadfile2");
		try {
			downloadFile.download(request, response, board.getRealFileName(), board.getDisplayFileName());
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	@RequestMapping("/delete/{boardId}")
	public ModelAndView doDeleteBoardAction(@PathVariable String boardId, HttpSession session){
		
		boolean isSucess = boardService.deleteBoard(boardId,session);
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/board");
		
		return view;
		
		
	}
	
	@RequestMapping("/write")
	public String viewWriteBoardPage(){
		/**
		 * <property name="prefix" value="/WEB-INF/view/" />
			<property name="suffix" value=".jsp" />
		 */
		return "board/write";
	}
	
	@RequestMapping("/doWrite")
	public ModelAndView doWriteBoardAction(BoardVO board, HttpSession session){
		
		boolean isSuccess = boardService.addBoard(board, session);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/board");
		return view;
	}
	
	

}









