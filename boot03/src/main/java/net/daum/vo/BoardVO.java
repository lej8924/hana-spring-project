package net.daum.vo;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter //setter()메서드 자동생성
@Getter //getter()메서드 자동생성
@ToString //toString()메서드 자동생성
@Entity //JPA를 다루는 엔티티빈 클래스
@SequenceGenerator(//시퀀스 생성기
		 name = "bno_seq8_gename", //시퀀스 제너레이터 이름
		 sequenceName = "bno_seq8", //시퀀스 이름
		 initialValue = 1, //시작번호값
		 allocationSize = 1 //기본값 50, 1씩증가
		)
@Table(name="tbl_boards3") //tbl_boards3 테이블을 생성
public class BoardVO {

	@Id //기본키 설정
	@GeneratedValue(
			 strategy = GenerationType.SEQUENCE, //사용할 전략을 시퀀스로 선택
			 generator = "bno_seq8_gename" //시퀀스 생성기에서 설정한 시퀀스 제너레이터 이름으로 설정
			)
	private int bno;//번호
	private String writer;//작성자
	private String title;//제목
	
	@Column(length=4000) //컬럼크기 지정
	private String content;//글내용
	
	@CreationTimestamp
	private Timestamp regdate;//등록날짜
	
	@UpdateTimestamp //@CreationTimestamp 와 @UpdateTimestamp 하이버네이트의 특별한 기능으로 등록,수정시점 날짜값을 기록
    private Timestamp updatedate;//수정날짜	
}





