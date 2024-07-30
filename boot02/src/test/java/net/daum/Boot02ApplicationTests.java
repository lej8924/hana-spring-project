package net.daum;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.daum.dao.BoardRepository;
import net.daum.vo.BoardVO;

@SpringBootTest
class Boot02ApplicationTests {

	@Autowired
	private BoardRepository boardRepo;

	@Test
	public void testInsert() {
		BoardVO b=new BoardVO();
		
		b.setWriter("홍길동");
		b.setTitle("게시판 제목입니다.");
		b.setContent("게시판 내용입니다.");
		
		//this.boardRepo.save(b);//저장
	}//레코드 저장

    @Test
    public void testRead() {
    	//Optional<BoardVO> b=this.boardRepo.findById(2);//2번 레코드 검색
    	//System.out.println(b);
    }//검색 읽기
    
    @Test
    public void testUpdate() {
      /* Optional<BoardVO> b = this.boardRepo.findById(2);//2번 레코드 검색
    	
    	b.ifPresent(b2 -> {
    	   System.out.println("2번 레코드 검색된 글쓴이 :" +b2.getWriter());
    	   b2.setTitle("게시판 제목을 수정합니다.");
    	   b2.setContent("게시판 내용을 수정합니다.");
    	   
    	   System.out.println("\n tbl_boards3 테이블 레코드 수정 =============>\n");
    	   this.boardRepo.save(b2);
    	});
    	*/
    }//수정
    
    @Test
    public void testDelete() {
       System.out.println("엔티티빈 JPA 삭제");
       this.boardRepo.deleteById(1);//1번 레코드 삭제
    }//레코드 삭제
}



































