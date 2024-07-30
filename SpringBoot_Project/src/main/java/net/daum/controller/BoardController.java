package net.daum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import net.daum.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	//사용자 게시판 글쓰기 폼
	@GetMapping("/board_write")
	public ModelAndView board_write() {
		
		ModelAndView wm=new ModelAndView();
		wm.setViewName("board/board_write");//뷰페이지 경로는 /WEB-INF/views/board/board_write.jsp
		return wm;
	}
}
