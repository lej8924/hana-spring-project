package net.daum.vo;

import lombok.Getter;
import lombok.Setter;

@Setter //setter() 메서드 자동생성
@Getter //getter() 메서드 자동생성
public class BoardVO { //tbl_board 게시판 테이블 컬럼명과 일치하는 변수명을 정의

	private int bno;//게시판 번호
	private String writer;//글쓴이
	private String title;//글제목
	private String content;//글내용
	private int viewcnt;//조회수
	private String regdate;//등록날짜
	private int replycnt;//댓글 수
	
	//페이징 쪽나누기 관련변수
	private int startrow;//시작행 번호
	private int endrow;//끝행 번호
}
