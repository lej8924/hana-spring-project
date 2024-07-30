package net.daum.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter //setter()메서드 자동생성
@Getter //getter()메서드 자동생성
@ToString
@Entity
@SequenceGenerator(//시퀀스 생성기
		 name="member7_no_seq_gename", //시퀀스 제너레이터 이름
		 sequenceName = "member7_no_seq",//시퀀스 이름
		 initialValue = 1,//시퀀스 시작번호값
		 allocationSize = 1//1씩 증가
		)
@Table(name="tbl_member_roles7") 
@EqualsAndHashCode(of="fno")
public class MemberRole {//회원이 가지는 권한 엔티티빈

	@Id
    @GeneratedValue(
    		 strategy=GenerationType.SEQUENCE,
    		 generator="member7_no_seq_gename" //시퀀스 생성기에서 설정해 놓은 시퀀스 제너레이터 이름을 설정
    		)	
	private int fno;
	
	private String roleName;//권한 이름
}




