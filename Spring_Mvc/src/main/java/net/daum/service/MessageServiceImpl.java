package net.daum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.daum.dao.MessageDAO;
import net.daum.dao.PointDAO;
import net.daum.vo.MessageVO;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDAO messageDao;
	
	@Autowired
	private PointDAO pointDao;

	//스프링 aop와 트랜잭션 적용한다.
	@Transactional //트랜잭션 적용
	@Override
	public void insertM(MessageVO vo) {
		this.messageDao.insertM(vo);//메시지 추가	
		this.pointDao.updatePoint(vo.getSender(), 10);//메시지를 보낸 사람에게 포인트 점수 10점 업
	} 
	
}
