package net.daum.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertBoard(BoardVO b) {
		this.sqlSession.insert("board_in", b);//mybatis에서 insert()메서드는 레코드를 저장하고, board_in은 board.xml에서 설정할
		//유일 아이디명이다.
	}//게시판 저장

	@Override
	public int getTotalCount() {
		return this.sqlSession.selectOne("b_count");//mybatis에서 selectOne()메서드는 단 한개의 레코드를 반환하고, b_count는
		//board.xml에서 설정할 유일 아이디명이다.
	}//총 레코드 개수	

	@Override
	public List<BoardVO> getBoardList(BoardVO b) {
		return this.sqlSession.selectList("b_list",b);//mybatis에서 selectList()메서드는 하나이상의 레코드를 반환한다. b_list는
		//board.xml에서 설정할 유일 아이디명이다.
	}//게시물 목록

	@Override
	public void updateHit(int bno) {
		this.sqlSession.update("b_hit", bno);//mybatis에서 update()메서드는 레코드를 수정한다. b_hit는 board.xml에서 설정할 유일
		//아이디명이다.
	}//조회수 증가

	@Override
	public BoardVO getBoardCont(int bno) {
		return this.sqlSession.selectOne("b_cont", bno);
	}//번호에 해당하는 내용보기	

	@Override
	public void editBoard(BoardVO eb) {
		this.sqlSession.update("b_edit", eb);		
	}//게시판 수정

	@Override
	public void delBoard(int bno) {
		this.sqlSession.delete("b_del", bno);//mybatis에서 delete()메서드는 레코드를 삭제한다. b_del은 board.xml에서 설정할 유일한
		//아이디명이다.
	}//게시판 삭제

	@Override
	public void updateReplyCnt(int bno, int count) {
		Map<String,Object> pm = new HashMap<>();
		
		pm.put("bno", bno);//게시판 번호 저장
		pm.put("count", count);//댓글 수 1, -1
		this.sqlSession.update("upReplyCnt", pm);
	}//댓글수 1증가,감소
}








