CREATE TABLE tbl_teacher_202201(
	teacher_code char(3) PRIMARY KEY, 
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
	substr(teach_regist_date, 0, 4)yyyy,
	substr(teach_regist_date, 5, 2)mm,
	substr(teach_regist_date, 7, 2)dd
from TBL_TEACHER_202201 order by teacher_code asc;

select * from TBL_TEACHER_202201 order by teacher_code desc;


insert into TBL_TEACHER_202201 values(100, '초급반', '김초급', '100000', '20220101');
insert into TBL_TEACHER_202201 values(200, '중급반', '이중급', '200000', '20220102');
insert into TBL_TEACHER_202201 values(300, '고급반', '박고급', '300000', '20220103');
insert into TBL_TEACHER_202201 values(400, '심화반', '조심화', '400000', '20220104');

create table tbl_member_202201(
	c_no char(5) primary key,
	c_name varchar2(12),
	phone varchar2(11),
	address varchar2(50),
	regist_date char(8),
	c_type varchar2(12)
);

select c_no, c_name from tbl_member_202201 order by c_no asc;

insert into tbl_member_202201 values(10001, '이혜정', '01011112222', '서울시 강남구', '20220101', '일반');
insert into tbl_member_202201 values(10002, '조아라', '01022223333', '성남시 분당구', '20220102', '일반');
insert into tbl_member_202201 values(10003, '유현주', '01033334444', '부산시 서구', '20220103', '일반');
insert into tbl_member_202201 values(20001, '김미현', '01044445555', '광주시 남구', '20220104', 'VIP');
insert into tbl_member_202201 values(20002, '박세리', '01055556666', '대전시 유성구', '20220105', 'VIP');

create table tbl_class_202201(
	regist_month char(8),
	c_no char(5),
	class_area varchar2(15),
	tuition number(8),
	teacher_code char(3),
	primary key(regist_month, c_no)
);

insert into tbl_class_202201 values('202203', '10001', '서울본부', '100000', '100');
insert into tbl_class_202201 values('202203', '10002', '성남본부', '100000', '100');
insert into tbl_class_202201 values('202203', '10003', '부산본부', '200000', '200');
insert into tbl_class_202201 values('202203', '20001', '광주본부', '150000', '300');
insert into tbl_class_202201 values('202203', '20002', '대전본부', '400000', '400');