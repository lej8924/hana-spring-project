package net.daum;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.daum.dao.MemberDAO;
import net.daum.vo.MemberVO;

@SpringBootTest
public class MemberDAOTest {
	
	@Autowired //자동 의존성 주입
	private MemberDAO memberDao;

	@Test
	public void testInsertMember() throws Exception{
		MemberVO m=new MemberVO();
		
		m.setUserid("kkkkk");
		m.setUserpw("77777");
		m.setUsername("홍길동");
		m.setEmail("kkkkk@gmail.com");
		
		this.memberDao.insertMember(m);//회원 저장
	}
}
