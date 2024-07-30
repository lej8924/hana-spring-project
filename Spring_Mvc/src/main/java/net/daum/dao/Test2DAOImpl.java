package net.daum.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.Test2VO;

@Repository
public class Test2DAOImpl implements Test2DAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert_test(Test2VO tvo) {
		this.sqlSession.insert("test2_in", tvo);		
	}	
}
