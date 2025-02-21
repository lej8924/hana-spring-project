package net.daum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import lombok.extern.java.Log;
import net.daum.dao.MemberRepository;
import net.daum.dao.ProfileRepository;
import net.daum.vo.MemberVO;
import net.daum.vo.Profile;

@SpringBootTest
@Log
@Commit //테스트 결과를 데이터베이스에 commit(커밋반영) 용도로 사용
class Boot04ApplicationTests {

	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private ProfileRepository profileRepo;
	
	//20명 회원 샘플 더미데이터 추가
	@Test
    public void testInsertMember() {
		
		IntStream.range(1, 21).forEach(i -> { //1부터 20까지 숫자가 생성
			MemberVO vo=new MemberVO();
			
			vo.setUid2("user"+i);//회원아이디 저장
			vo.setUpw("pw"+i);//비번 저장
			vo.setUname("사용자"+i);//회원이름 저장
			
            //this.memberRepo.save(vo);//20명 회원 저장			
		});
	}//testInsertMember()
	
	//특정 회원에 프로필 파일추가
	@Test
	public void testInsertProfile() {
		
		MemberVO member=new MemberVO();
		member.setUid2("user1");
		
		for(int i=1;i<5;i++) {
			Profile profile01 = new Profile();
			profile01.setFname("face"+i+".jpg");//프로필 사진 4개 추가
			
			if(i==1) {//현재 사용중인 프로필 사진
				profile01.setCurrent2(true);
			}
			
			profile01.setMember(member);
			
			//this.profileRepo.save(profile01);
		}
	}//testInsertProfile()
	
	//user1 회원아이디 정보와 프로필 사진개수 =>Fetch Join
	@Test
	public void testFetchJoin01() {
		
		List<Object[]> result = this.memberRepo.getMemberVOWithProfileCount("user1");
		
		//result.forEach(arr -> System.out.println(Arrays.toString(arr)));
	}//testFetchJoin()
	
	//단방향 페치조인
    @Test
    public void testFetchJoin02() {
    	
    	List<Object[]> result = this.memberRepo.getMemberVOWithProfile("user1");//user1아이디 회원정보와 현재 사용중인 프로필
    	//파일정보
    	result.forEach(arr -> System.out.println(Arrays.toString(arr)));
    }
}


























