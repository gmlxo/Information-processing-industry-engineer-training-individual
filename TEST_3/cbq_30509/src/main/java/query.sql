create table tbl_jumin_202101 (
	telno char(13) primary key,
	name varchar2(20),
	jumin char(13),
	city varchar2(10)
);

create table tbl_visit_202101 (
	telno char(13),
	visitdate char(08),
	vissittime char(04),
	shopno char(04),
	primary key(telno, visitdate, vissittime)
);

create table tbl_test_202101 (
	testno char(08) primary key,
	telno char(13),
	testdate char(08),
	testresult char(01) check(testresult in ('P', 'N'))
);

create table tbl_bshop_202101 (
	shopno char(04) primary key,
	shopname varchar2(20),
	shoptelno varchar2(13),
	site varchar2(20)
);

select 
		b.shopno,
		b.shopname,
		count(v.telno) as num
from TBL_BSHOP_202101 b, TBL_VISIT_202101 v
where b.shopno = v.shopno
group by b.shopno, b.shopname
order by b.shopno

select 
		t.testno,
		j.name,
		substr(j.jumin, 0, 6) || '-' || substr(j.jumin, 6, 7) as jumin,
		substr(j.jumin, 7, 1) as man,
		j.city,
		j.telno,
		t.testresult
from TBL_TEST_202101 t, tbl_jumin_202101 j
where t.telno = j.telno
order by t.testno;

select jumin from tbl_jumin_202101;

select 
		v.telno,
		to_char(to_date(v.visitdate, 'yyyymmdd'), 'yyyy"년"mm"월"dd"일"') as visitdate,
		substr(v.vissittime, 0, 2) || ':' || substr(v.vissittime, 3, 2) as vissittime,
		b.site,
		b.shopname,
		b.shoptelno
from TBL_BSHOP_202101 b, TBL_VISIT_202101 v
where b.shopno = v.shopno
order by v.vissittime asc;

update TBL_VISIT_202101 set vissittime='0900' where telno = '010-0000-0001' and shopno = 'V001' 

select * from TBL_VISIT_202101;

insert into TBL_JUMIN_202101 values ('010-0000-0001', '김주민', 440101-1000001, '서울');
insert into TBL_JUMIN_202101 values ('010-0000-0002', '이주민', 4401012000002, '대구');
insert into TBL_JUMIN_202101 values ('010-0000-0003', '박주민', 4401011000003, '부산');
insert into TBL_JUMIN_202101 values ('010-0000-0004', '황주민', 4401012000004, '광주');
insert into TBL_JUMIN_202101 values ('010-0000-0005', '조주민', 4401011000005, '경기');
insert into TBL_JUMIN_202101 values ('010-0000-0006', '나주민', 4401012000006, '서울');

insert into TBL_VISIT_202101 values ('010-0000-0001', 20210301, 0900, 'V001');
insert into TBL_VISIT_202101 values ('010-0000-0001', 20210301, 1000, 'V002');
insert into TBL_VISIT_202101 values ('010-0000-0001', 20210301, 1100, 'V003');
insert into TBL_VISIT_202101 values ('010-0000-0004', 20210301, 1200, 'V004');
insert into TBL_VISIT_202101 values ('010-0000-0002', 20210301, 1300, 'V001');
insert into TBL_VISIT_202101 values ('010-0000-0002', 20210301, 1400, 'V003');
insert into TBL_VISIT_202101 values ('010-0000-0002', 20210301, 1500, 'V005');
insert into TBL_VISIT_202101 values ('010-0000-0003', 20210301, 1600, 'V001');
insert into TBL_VISIT_202101 values ('010-0000-0003', 20210301, 1700, 'V005');
insert into TBL_VISIT_202101 values ('010-0000-0003', 20210301, 1800, 'V007');
insert into TBL_VISIT_202101 values ('010-0000-0004', 20210301, 1900, 'V003');
insert into TBL_VISIT_202101 values ('010-0000-0004', 20210301, 2000, 'V005');
insert into TBL_VISIT_202101 values ('010-0000-0005', 20210301, 2100, 'V001');
insert into TBL_VISIT_202101 values ('010-0000-0006', 20210301, 2200, 'V001');

insert into TBL_TEST_202101 values (20100001, '010-0000-0001', 20210301, 'P');
insert into TBL_TEST_202101 values (20100002, '010-0000-0002', 20210301, 'P');
insert into TBL_TEST_202101 values (20100003, '010-0000-0003', 20210301, 'P');
insert into TBL_TEST_202101 values (20100004, '010-0000-0004', 20210301, 'N');
insert into TBL_TEST_202101 values (20100005, '010-0000-0005', 20210301, 'N');
insert into TBL_TEST_202101 values (20100006, '010-0000-0006', 20210301, 'N');

--select * from TBL_TEST_202101TBL_TEST_202101'

--delete TBL_TEST_202101 where 1=1

insert into TBL_BSHOP_202101 values ('V001', 'A빌딩', '1588-0001', '희망1동');
insert into TBL_BSHOP_202101 values ('V002', 'B빌딩', '1588-0002', '희망2동');
insert into TBL_BSHOP_202101 values ('V003', 'C빌딩', '1588-0003', '희망3동');
insert into TBL_BSHOP_202101 values ('V004', 'D빌딩', '1588-0004', '희망4동');
insert into TBL_BSHOP_202101 values ('V005', 'E빌딩', '1588-0005', '희망5동');
insert into TBL_BSHOP_202101 values ('V006', 'F빌딩', '1588-0006', '희망6동');
insert into TBL_BSHOP_202101 values ('V007', 'G빌딩', '1588-0007', '희망7동');
insert into TBL_BSHOP_202101 values ('V008', 'H빌딩', '1588-0008', '희망8동');