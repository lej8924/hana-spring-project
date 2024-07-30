package net.daum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login") //get으로 접근하는 매핑주소 처리, login매핑주소가 실행되었을 때 사용자 로그인페이지가 실행된다.
	public void login() {
	  //반환 타입이 없는 void형이면 매핑주소인 login이 뷰페이지 파일명이 된다. 
		
	}
	
	@GetMapping("/accessDenied") //403접근 금지
	public void accessDenied() {
		
	}
	
	@GetMapping("/logout") //로그아웃 
	public void logout() {
		
	}
}
