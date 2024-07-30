package net.daum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.daum.dao.Test2DAO;
import net.daum.vo.Test2VO;

@Service
public class Test2ServiceImpl implements Test2Service {

	@Autowired
	private Test2DAO test2Dao;

	@Override
	public void insert_test(Test2VO tvo) {
		this.test2Dao.insert_test(tvo);		
	}	
}
