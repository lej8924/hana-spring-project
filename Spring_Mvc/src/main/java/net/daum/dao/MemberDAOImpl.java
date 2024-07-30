package net.daum.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.MemberVO;

@Repository //@Repository 애노테이션을 설정해서 스프링에서 모델DAO로 인식한다.
public class MemberDAOImpl implements MemberDAO {

	@Autowired //자동 의존성(DI) 주입
	private SqlSession sqlSession;//mybatis 쿼리문 수행할 sqlSession생성

	@Override
	public void insertMember(MemberVO m) {
		this.sqlSession.insert("m_in", m);//mybatis에서 insert()메서드는 레코드를 저장한다. m_in은 member.xml매퍼태그에서 설정할
		//유일 아이디명
	}//회원 저장	
}
