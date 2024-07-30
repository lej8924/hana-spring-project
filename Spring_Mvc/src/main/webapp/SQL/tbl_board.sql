--tbl_member 테이블 생성
create table tbl_member(
 userid varchar2(25) primary key --회원아이디
 ,userpw varchar2(50) not null --회원비번
 ,username varchar2(20) not null --회원이름
 ,email varchar2(50) --회원이메일
 ,regdate date --가입날짜
);

select * from tbl_member order by userid asc;

--tbl_board 게시판 테이블 생성
create table tbl_board(
 bno number(38) primary key --게시판 번호
 ,writer varchar(50) not null --글쓴이
 ,title varchar(200) not null --글제목
 ,content varchar(4000) not null --글내용
 ,viewcnt int default 0 -- default 0 제약조건을 설정하면 해당 컬럼에 굳이 레코드를 저장하지 않아도 기본값 0이 저장된다. 조회수
 ,regdate date --등록날짜
);

select * from tbl_board order by bno desc; --번호를 기준으로 내림차순 정렬

-- 댓글수를 카운터해서 저장할 replycnt컬럼을 추가
alter table tbl_board add(replycnt number(38) default 0);

--tbl_reply 테이블의 게시판 번호에 대한 댓글수를 카운터해서 tbl_board 테이블에 추가된 replycnt컬럼 레코드값으로 수정되게 만드는 서브쿼리문을
--작성
update tbl_board set replycnt = (select count(rno) from tbl_reply where bno=tbl_board.bno) where bno > 0;
commit; --트랜잭션 커밋 반영

--번호발생기 시퀀스 생성
create sequence bno_seq --bno_seq 시퀀스 생성
start with 1 --1부터 시작
increment by 1 --1씩 증가
nocache --시퀀스 값을 미리 메모리에 캐시하지 않고, 매번 시퀀스 값을 요청할 때마다 디스크에서 가져오게 됨을 의미
nocycle; --시퀀스 최대값 생성시 생성 중지해서 처음부터 반복 안하게 함.

--생성된 시퀀스 번호값 확인 -> 시퀀스명.nextval
select bno_seq.nextval from dual;

--댓글테이블 생성
create table tbl_reply(
  rno int primary key -- 댓글 번호
  , bno number(38) default 0 --tbl_board 게시판 테이블의 번호값만 저장됨. 외래키(foreign key) 추가 설정
  , replyer varchar2(50) not null --댓글 작성자
  , replytext varchar2(4000) not null --댓글 내용
  , regdate date --댓글 등록날짜
  , updatedate date --댓글 수정날짜
  );

select * from tbl_reply order by rno desc;

--bno컬럼 외래키 추가 설정
alter table tbl_reply add constraint tbl_reply_bno_fk foreign key(bno) references tbl_board(bno);

--rno_seq 댓글 시퀀스 생성
create sequence rno_seq
start with 1
increment by 1
nocache
nocycle;

--rno_seq 시퀀스 다음번호값 확인
select rno_seq.nextval as "다음시퀀스번호값" from dual;

--오늘 날짜 시간값을 확인
select sysdate as "오늘날짜시간값" from dual;

--스프링 AOP와 트랜잭션을 적용하기 위한 db설계
--tbl_user 테이블 생성
create table tbl_user(
  uid2 varchar2(50) primary key -- 아이디
  ,upw varchar2(100) not null -- 비번
  ,uname varchar2(50) not null --회원이름
  ,upoint number(38) default 0 -- 메시지가 보내지면 메시지 하나당 포인터 점수 10점 업데이트
);

insert into tbl_user (uid2, upw, uname) values('user00','user00','홍길동');
insert into tbl_user (uid2, upw, uname) values('user01','user01','이순신');

select * from tbl_user;

--메시지가 추가되는 tbl_message 테이블 생성
create table tbl_message(
 mid number(38) primary key
 , targetid varchar2(50) not null -- 외래키(foreign key)를 추가설정해서 tbl_user테이블의 uid2컬럼의 회원아이디만 저장되게 한다.
 , sender varchar2(50) not null --메시지를 보낸사람
 , message varchar2(4000) not null --보낸 메시지
 , senddate date --보낸 날짜
 );

--targetid 컬럼에 외래키 추가설정
alter table tbl_message add constraint tbl_message_targetid_fk
foreign key(targetid) references tbl_user(uid2);

select * from tbl_message order by mid desc;
delete from tbl_message where mid=3;
commit;

--mid_no_seq 시퀀스 생성
create sequence mid_no_seq
start with 1
increment by 1
nocache
nocycle;

--mid_no_seq 시퀀스 다음번호값을 확인
select mid_no_seq.nextval as "시퀀스번호값" from dual;

--문제에 해당하는 tbl_test2 테이블 생성
create table tbl_test2(
  test_no number(38) primary key
  , test_title varchar2(200) not null
  , test_cont varchar2(4000) not null
);

select * from tbl_test2 order by test_no desc;

--test_no_seq2 시퀀스 생성
create sequence test_no_seq2
start with 1
increment by 1
nocache
nocycle;

--test_no_seq2 시퀀스 다음번호값 확인
select test_no_seq2.nextval as "다음시퀀스 번호값" from dual;












