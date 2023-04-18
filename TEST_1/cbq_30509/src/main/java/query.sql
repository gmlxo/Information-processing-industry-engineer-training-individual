create table tbl_teacher_20221(
	teacher_code char(3) primary key,
	class_name varchar2(12),
	teacher_name varchar2(12),
	class_price number(8),
	teach_regist_date char(8)
);

select 
	teacher_code, 
	class_name, 
	teacher_name, 
	class_price, 
	substr(teach_regist_date, 0, 4) yyy, 
	substr(teach_regist_date, 5, 2) , 
	substr(teach_regist_date, 7, 2) 
from TBL_TEACHER_20221
order by teacher_code asc;

insert into TBL_TEACHER_20221 values (100, '초급반', '김초급', 1000000, 20220101);
insert into TBL_TEACHER_20221 values (200, '중급반', '이중급', 2000000, 20220102);
insert into TBL_TEACHER_20221 values (300, '고급반', '박고급', 3000000, 20220103);
insert into TBL_TEACHER_20221 values (400, '심화반', '조심급', 4000000, 20220104);

select * from tbl_member_202201;

CREATE TABLE tbl_member_202201(
	c_no char(5) PRIMARY KEY,
	c_name varchar2(12),
	phone varchar2(11),
	address varchar2(50),
	regist_date char(8),
	c_type varchar2(12)
);

select 
	substr(c.regist_month, 0, 4) yyyy, 
	substr(c.regist_month, 5, 2) mm, 
	m.c_no,
	m.c_name,
	t.class_name,
	t.teacher_name,
	c.class_area,
	c.tuition
from tbl_member_202201 m, tbl_class_202201 c, TBL_TEACHER_20221 t 
where m.c_no = c.c_no and c.teacher_code = t.teacher_code;

select
	t.teacher_code, 
	t.teacher_name, 
	t.class_name,
	sum(c.tuition) tuition
from TBL_TEACHER_20221 t, tbl_class_202201 c 
where c.teacher_code = t.teacher_code
group by t.teacher_code, t.teacher_name, t.class_name
order by t.teacher_code asc;

insert into tbl_member_202201 values (10001, '이혜정', 01011112222, '서울시 강남구', 20220101, '일반');
insert into tbl_member_202201 values (10002, '조아라', 01022223333, '성남시 분당구', 20220102, '일반');
insert into tbl_member_202201 values (10003, '유현주', 01033334444, '부산시 서구', 20220103, '일반');
insert into tbl_member_202201 values (20001, '김미현', 01044445555, '광주시 남구', 20220104, 'VIP');
insert into tbl_member_202201 values (20002, '박세리', 01055556666, '대전시 유성구', 20220105, 'VIP');

CREATE TABLE tbl_class_202201(
	regist_month char(8),
	c_no char(5),
	class_area varchar2(15),
	tuition number(8),
	teacher_code char(3),
	primary key(regist_month, c_no)
);

insert into tbl_class_202201 values(202203, 10001, '서울본원', 100000, 100);
insert into tbl_class_202201 values(202203, 10002, '성남본원', 100000, 100);
insert into tbl_class_202201 values(202203, 10003, '부산본원', 200000, 200);
insert into tbl_class_202201 values(202203, 20001, '광주본원', 150000, 300);
insert into tbl_class_202201 values(202203, 20002, '대전본원', 200000, 400);

select * from tbl_class_202201;

