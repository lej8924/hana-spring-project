package net.daum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	//비동기식 아작스 댓글
	@RequestMapping("/test")
	public void test() {
		//리턴타입이 없는 void형이면 매핑주소인 test가 뷰페이지 파일명이 된다. 뷰페이지 경로는 /WEB-INF/views/test.jsp
	}
}
