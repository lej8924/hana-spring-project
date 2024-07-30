alter sequence member7_no_seq nocache; --nocache로 설정

alter sequence member7_no_seq nocycle; --nocycle 로 설정

select * from tbl_members7 order by mem_id asc;

select * from tbl_member_roles7 order by fno asc;

--스프링 시큐리티 자동로그인 정보를 유지하는 테이블
create table persistent_logins(
  username varchar2(64) not null --회원아이디
  ,series varchar2(64) primary key --비번
  ,token varchar2(64) not null --토큰정보
  ,last_used timestamp not null --로그인 한 날짜 시간
);

select * from persistent_logins;