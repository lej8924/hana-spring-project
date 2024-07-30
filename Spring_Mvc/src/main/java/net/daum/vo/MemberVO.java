package net.daum.vo;

public class MemberVO {//TBL_member테이블 컬러명과 일치하는 변수명을 가진 데이터 저장빈 클래스 정의

	private String userid;//회원아이디
	private String userpw;//회원비번
	private String username;//회원이름
	private String email;//이메일
	private String regdate;//가입날짜
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
}
