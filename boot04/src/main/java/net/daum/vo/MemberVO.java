package net.daum.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString //toString()메서드 자동생성
@Entity //엔티티빈 
@Table(name="tbl_members6") //tbl_members6이라는 테이블 명 생성
@EqualsAndHashCode(of="uid2")
public class MemberVO {

	@Id //식별키인 기본키
	private String uid2;//회원아이디
	private String upw;//비번
	private String uname;//회원이름
}
