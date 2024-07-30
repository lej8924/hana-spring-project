package net.daum.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;//mybatis로 쿼리문 수행할 sqlSession 자동의존성 주입(DI)
	
	@Autowired
	private BoardRepository boardRepo;//JPA로 쿼리문 수행할 boardRepo 자동의존성 주입
	
}
