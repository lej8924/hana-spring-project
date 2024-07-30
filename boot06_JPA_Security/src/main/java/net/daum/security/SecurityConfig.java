package net.daum.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.extern.java.Log;

@Log
@EnableWebSecurity //@EnableWebSecurity 를 추가함으로써 스프링에서 웹 시큐리티로 인식하게 한다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//스프링 웹 시큐리티 설정을 담당하는 WebSecurityConfigurerAdapter 클래스를 상속받는다.
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//HttpSecurity는 웹과 관련된 다양한 보안설정을 할 수 있다. 
		
		log.info("security config ...");//간단한 로그 메시지 출력
	}	
}
