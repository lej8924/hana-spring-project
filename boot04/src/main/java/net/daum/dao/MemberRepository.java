package net.daum.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.daum.vo.MemberVO;

public interface MemberRepository extends JpaRepository<MemberVO, String> {

	@Query(value="select m.uid2, count(fname) from tbl_members6 m left outer join tbl_profile3 p "
			+" on m.uid2 = p.member_uid2 where m.uid2 = ?1 group by m.uid2" , nativeQuery = true)
	/* nativeQuery문은 말 그대로 데이터베이스 sql문을 그대로 사용하겠다는 뜻이다. 복잡한 쿼리문 작성에 유리하다. 이런 경우는 jpa를 사용하는 목적에
	 * 서 약간 벗어난다. 단방향 Fetch Join문이다. 
	 */
	public List<Object[]> getMemberVOWithProfileCount(String id);//회원아이디와 프로필 사진 개수
	
	@Query(value="select m.uid2, m.upw, m.uname, p.current2, p.fname from tbl_members6 m left outer join"
			+"tbl_profile3 p on m.uid2=p.member_uid2 where m.uid2=?1 and p.current2=1", nativeQuery = true)
	public List<Object[]> getMemberVOWithProfile(String uid);//아이디에 대한 회원정보와 현재 사용중인 프로필 사진 정보 =>Fetch 조인문
}
