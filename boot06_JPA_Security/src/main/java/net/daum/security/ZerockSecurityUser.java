package net.daum.security;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;
import net.daum.vo.MemberRole;
import net.daum.vo.MemberVO;

@Setter
@Getter
public class ZerockSecurityUser extends User {

	private static final String ROLE_PREFIX = "ROLE_";
	
	private MemberVO member;
	
	public ZerockSecurityUser(MemberVO member, HttpServletRequest request) {
		super(member.getMem_id(), member.getMem_pwd(), makeGrantedAuthority(member.getRoles()));
		//부모클래스 오버로딩 된 생성자를 호출하면서 회원아이디,비번,권한목록을 전달함
		
		System.out.println("권한이름: "+ makeGrantedAuthority(member.getRoles()).toString());
		HttpSession session=request.getSession();
		session.setAttribute("id", member.getMem_id());//세션 id에 아이디를 저장
		session.setAttribute("name", member.getMem_name());//세션 name에 회원이름을 저장
		
		List<GrantedAuthority> list = makeGrantedAuthority(member.getRoles());
		String total_Auth = "";//누적 권한
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
			total_Auth += list.get(i);
		}
		System.out.println("누적권한:"+total_Auth);
		session.setAttribute("auth", total_Auth);
	}
	
	private static List<GrantedAuthority> makeGrantedAuthority(List<MemberRole> roles){
	  //메서드인자값으로 권한 목록이 전달됨
	  List<GrantedAuthority> list = new ArrayList<>();
	  
	  roles.forEach(role->list.add(new SimpleGrantedAuthority(ROLE_PREFIX+role.getRoleName())));//권한 목록만큼
	  //반복해서 접두어 "ROLE_"를 붙인 권한이름을 SimpleGrantedAuthority 생성자 인자값으로 전달해서 해당 제네릭타입 객체로 컬렉션에
	  //추가
	  
	  return list;
	}
}
