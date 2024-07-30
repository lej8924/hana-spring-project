package net.daum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import net.daum.service.MemberService;

@Controller
public class MemberController {//사용자 회원관리 컨트롤러
	
	@Autowired
	private MemberService memberService;
	
}
