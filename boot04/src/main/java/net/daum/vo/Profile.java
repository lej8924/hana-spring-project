package net.daum.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude="member") //toString() 메서드에서 member변수를 제외 하여 호출안되게 한다.
@Entity
@SequenceGenerator(//시퀀스 생성기
		 name="fno_seq_gename", //시퀀스 제너레이터 이름
		 sequenceName = "fno_seq", //시퀀스 이름
		 initialValue = 1, //시퀀스 번호 시작값
		 allocationSize = 1 //증가값 1		 
		)
@Table(name="tbl_profile3")
@EqualsAndHashCode(of="fname")
public class Profile {

	@Id
	@GeneratedValue(
			   strategy=GenerationType.SEQUENCE, 
			   generator="fno_seq_gename" //시퀀스 생성기에서 설정한 시퀀스 제너레이터 이름
			)
	private int fno;
	
	private String fname;
	private boolean current2;
	
    @ManyToOne //다대일 연관관계
    private MemberVO member;//외래키로 설정
}













