package net.daum.vo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter //setter()메서드 자동제공
@Getter //getter()메서드 자동제공
@ToString //toString()메서드 자동제공
@Entity //엔티티빈
@Table(name="board") //board 테이블명 생성
@EqualsAndHashCode(of="board_no") //equals(), hashCode(), canEqual() 메서드 자동제공
public class BoardVO {
  /* 네임피라미터 이름과 빈클래스 변수명은 일치시킨다.*/
	
	@Id //구분키(식별키,유일키)로 사용될 기본키 컬럼 즉, primary key
	private int board_no;//게시판 번호
	
	private String board_name;//글쓴이
	private String board_title;//글제목
	private String board_pwd;//비번
	
	@Column(length=4000) //컬럼 크기를 4000으로 설정
	private String board_cont;//글내용
	private int board_hit;//조회수
	
	//계단형 계층형 게시판과 연관되는 관리자 답글과 관련된 변수
	private int board_ref;//글 그룹번호 역할=>원본글과 답변글을 묶어주는 역할
	private int board_step;//원본글이면 0, 첫번째 답변글이면 1, 두번째 답변글이면 2..중략 =>원본글과 답변글을 구분하는 번호값이면서 몇번째 답변
	//글인가를 알려준다.
	private int board_level;//답변글 정렬순서
	
	@CreationTimestamp //하이버네이트의 특별한 기능으로 등록시점의 날짜값을 기록한다. mybatis로 실행할 때는 구동 안됨.
	private Timestamp board_date;
}




