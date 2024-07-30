package net.daum.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor //모든 속성(클래스 소속 멤버변수)에 대한 생성자를 만든다.
public class MemberVO {

	private int mno;
	private String mid;
	private String mpw;
	private String mname;
	private Timestamp regdate;
	
}
