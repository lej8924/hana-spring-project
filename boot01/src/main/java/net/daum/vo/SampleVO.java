package net.daum.vo;

import lombok.Data;
import lombok.ToString;

@Data //기본생성자,canEqual(),equals(),hashCode(),toString(),setter(),getter()메서드까지 자동생성
@ToString(exclude= {"val03"}) //exclude 속성을 사용해서 val03변수를 배제시킨다.
public class SampleVO {

	private String val01;
	private String val02;
	private String val03;
	
}
