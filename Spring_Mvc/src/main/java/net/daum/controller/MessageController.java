package net.daum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.daum.service.MessageService;
import net.daum.vo.MessageVO;

@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	//메시지 추가
	@PostMapping("/insertMessage")
	public ResponseEntity<String> addMessage(@RequestBody MessageVO vo){
		ResponseEntity<String> entity=null;
		
		try {
			this.messageService.insertM(vo);//메시지 추가
			entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
