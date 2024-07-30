package net.daum.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.daum.vo.SampleVO;

@RestController
public class SampleController {

	@GetMapping("/jpa_begin")
	public String jpa_begin() {
		return "스프링 jpa 시작";
	}
	
	@GetMapping("/sample")
	public SampleVO sample() {
		//리턴타입이 SampleVO이면 해당 빈클래스의 변수명이 json데이터의 키이름이 된다.
		SampleVO vo=new SampleVO();
		vo.setVal01("val01 입니다.");
		vo.setVal02("val02 입니다.");
		vo.setVal03("val03 입니다.");
		
		System.out.println(vo.toString());
		return vo;
	}
}






