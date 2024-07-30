alter sequence fno_seq nocache; --nocache로 수정

alter sequence fno_seq nocycle; --최대값 시퀀스 번호
--생성시 생성중지해서 다시 처음부터 반복 안하게 함.

select * from tbl_boards3 order by bno desc;

select * from tbl_members6;
select * from tbl_profile3;