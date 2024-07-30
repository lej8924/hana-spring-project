package net.daum.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReplyVO {//TBL_reply 테이블의 컬럼명과 일치하는 변수명을 가진 데이터 저장빈 클래스를 정의

	private int rno;//댓글 번호
	private int bno;//게시판 번호
	private String replyer;//댓글 작성자
	private String replytext;//댓글내용
	private String regdate;//댓글등록날짜
	private String updatedate;//댓글 수정날짜
}
