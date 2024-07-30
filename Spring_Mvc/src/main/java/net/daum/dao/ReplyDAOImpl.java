package net.daum.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertReply(ReplyVO vo) {
		this.sqlSession.insert("reply_in", vo);	//mybatis에서 insert()메서드는 레코드를 저장하고, reply_in은 mybatis 매퍼 xml
		//태그에서 유일아이디명이다.
	}//댓글등록	

	@Override
	public List<ReplyVO> listReply(int bno) {
		return this.sqlSession.selectList("reply_list", bno); //mybatis 에서 selectList()메서드는 하나이상의 레코드를 검색해서
		//복수개의 레코드를 반환한다. reply_list는 mybatis 매퍼태그에서 설정할 유일 아이디명이다.
	}//게시판 번호에 해당하는 댓글 목록

	@Override
	public void updateReply(ReplyVO vo) {
		this.sqlSession.update("reply_edit",vo);//mybatis에서 update()메서드를 레코드를 수정한다. reply_edit는 reply.xml에서 설정
		//할 유일 아이디명이다.
	}//댓글수정

	@Override
	public void deleteReply(int rno) {
		this.sqlSession.delete("reply_del", rno);//mybatis에서 delete()메서드는 레코드를 삭제한다. reply_del은 reply.xml에서
		//설정할 유일 아이디명이다.
	}//댓글삭제

	@Override
	public int getBno(int rno) {
		return this.sqlSession.selectOne("reply_bno", rno);
	}//댓글번호를 기준으로 게시판 번호를 구함
}











