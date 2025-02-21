package net.daum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.daum.service.ReplyService;
import net.daum.vo.ReplyVO;

@RestController
@RequestMapping("/replies") //컨트롤러 자체 매핑주소 replies 등록
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	
	//댓글등록
	@PostMapping("/addReply") //addReply 매핑주소 등록
	public ResponseEntity<String> addReply(@RequestBody ReplyVO vo){
		/* @ RequestBody 애노테이션은 전송된 키,값 쌍의 json 데이터를 ReplyVO 객체 타입으로 변환해 준다. 
		 */
		ResponseEntity<String> entity=null;
		
		try {
			this.replyService.insertReply(vo);//댓글 등록
			entity=new ResponseEntity<>("SUCCESS",HttpStatus.OK);//댓글 저장 성공시 SUCCESS문자와 200 정상상태 코드 반환
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			//예외 에러가 발생하면 에어 메시지와 나쁜상태 코드가 반환
		}
		
		return entity;
	}//addReply()
	
	//게시판 번호에 해당하는 댓글 목록
	@GetMapping("/all/{bno}") 
	public ResponseEntity<List<ReplyVO>> getReplyList(@PathVariable("bno") int bno){
		/*@PathVariable("bno")은 매핑주소로 부터 bno 게시판 번호값을 추출하는 용도로 활용된다. 
		 */
		ResponseEntity<List<ReplyVO>> entity=null;
		
		try {
			entity=new ResponseEntity<>(this.replyService.listReply(bno),HttpStatus.OK);//게시판 번호에 해당하는 댓글 목록
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}//getReplyList()
	
    //댓글번호를 기준으로 댓글내용수정
	@PutMapping("/editReply/{rno}")
	public ResponseEntity<String> editReply(@PathVariable("rno") int rno,@RequestBody ReplyVO vo){
		ResponseEntity<String> entity=null;
		
		try {
		   	vo.setRno(rno);//댓글번호 저장
		   	this.replyService.updateReply(vo);//댓글 수정
		   	entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);//HttpStatus.OK는 댓글수정 성공시 200 정상상태코드를 반환
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}		
		return entity;
	}//editReply()
	
	//댓글번호를 기준으로 삭제
	@DeleteMapping("/delReply/{rno}")
	public ResponseEntity<String> del(@PathVariable("rno") int rno){
        ResponseEntity<String> entity=null;
        
        try {
        	this.replyService.deleteReply(rno);//댓글번호를 기준으로 삭제
        	entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
        }catch(Exception e) {
        	e.printStackTrace();
        	entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
	}//del()
}




























