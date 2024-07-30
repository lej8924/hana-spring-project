package net.daum.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.daum.vo.BoardVO;

public interface BoardRepository extends JpaRepository<BoardVO, Integer> {

	public List<BoardVO> findBoardVOByTitle(String title);//쿼리메서드가 find+엔티티빈클래스명+By+컬럼명 =>제목으로 검색
	
	public Collection<BoardVO> findByWriter(String writer);//쿼리메서드가 findBy+엔티티빈변수명
	
	public Collection<BoardVO> findByWriterContaining(String writer);//글쓴이에 대한 like % 검색어 % => '%'+검색어+'%'
	//sql문에서 %와일드 카드는 하나이상의 임의의 모르는 문자와 매핑대응, _와일드카드는 하나의 모르는 문자와 매핑대응
	/*
	 * like 쿼리메서드 형태종류
	 * 형태       쿼리메서드
	 * 검색어+'%' StartingWith
	 * '%'+검색어 EndingWith
	 * '%'+검색어+'%' Containing
	 */
	
	public Collection<BoardVO> findByTitleContainingOrContentContaining(String title, String cont);
	//'%'+제목검색어+'%' + Or + '%'+내용검색어+'%'
	
	public Collection<BoardVO> findByTitleContainingAndBnoGreaterThan(String title, int bno);
	//'%'+제목검색어+'%' + And + bno > ?
	
	public Collection<BoardVO> findByBnoGreaterThanOrderByBnoDesc(int bno);
	//bno > ? order by bno desc => 게시물 번호가 특정번호보다 크고 번호를 기준으로 내림차순 정렬
	
	@Query("select b from BoardVO b where b.title like %?1% and b.bno>0 order by b.bno desc")
	//JPQL(JPA에서 사용하는 쿼리언어(Java Persistence Query Language의 약어)), JPQL문을 사용하면 실제 테이블명 대신 엔티티빈 클래스명을
	//사용하고, 실제 컬럼명 대신 엔티티빈 클래스의 변수명을 사용한다. ?1은 첫번째로 전달되어지는 인자값을 의미한다.
	public List<BoardVO> findByTitle(String title);
	
	@Query("select b from BoardVO b where b.content like %:content% and b.bno>0 order by b.bno desc")
	public List<BoardVO> findByContent(@Param("content") String content);//:content는 @Param("content")와 연결된다.
	
	@Query("select b.bno, b.title, b.writer, b.regdate from BoardVO b where b.title like %?1% and b.bno>0 order by "
			+" b.bno desc") //원하는 컬럼만 검색하는 경우는 반환제네릭타입이 Object[] 배열타입이라는 것이다.
	public List<Object[]> findByTitle2(String title);
}













