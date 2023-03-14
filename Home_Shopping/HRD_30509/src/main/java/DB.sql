CREATE TABLE member_tbl_02 (
    custno NUMBER(6) PRIMARY KEY,
    custname VARCHAR2(20),
    phone VARCHAR2(13),
    address VARCHAR2(4),
    joindate date,
    grade CHAR(1),
    city CHAR(2)
);

insert into member_tbl_02 VALUES (100001, '김행복', '010-1111-2222', 'SK', '2015-12-02', 'A', 01);
insert into member_tbl_02 VALUES (100002, '이축복', '010-1111-3333', 'SK', '2015-12-06', 'B', 01);
insert into member_tbl_02 VALUES (100003, '장믿음', '010-1111-4444', 'LG', '2015-10-01', 'B', 30);
insert into member_tbl_02 VALUES (100004, '최사랑', '010-1111-5555', 'KT', '2015-11-13', 'A', 30);
insert into member_tbl_02 VALUES (100005, '진평화', '010-1111-6666', 'SK', '2015-12-25', 'B', 60);
insert into member_tbl_02 VALUES (100006, '차공단', '010-1111-7777', 'LG', '2015-12-11', 'C', 60);

CREATE TABLE money_tbl_02 (
	custno number(6),
	salenol number(8),
	pcost number(8),
	amount number(4),
	price number(8),
	pcode varchar2(4),	
	sdate date,
	primary key (custno, salenol)
);


insert into money_tbl_02 values(100001, 20160001, 500, 5, 2500, 'A001', '20160101');
insert into money_tbl_02 values(100001, 20160002, 1000, 4, 4000, 'A002', '20160101');
insert into money_tbl_02 values(100001, 20160003, 500,3, 1500, 'A008', '20160101');
insert into money_tbl_02 values(100002, 20160004, 500, 1, 500, 'A004', '20160102');
insert into money_tbl_02 values(100002, 20160005, 2000, 1, 2000, 'A001', '20160103');
insert into money_tbl_02 values(100003, 20160006, 500, 2, 1000, 'A003', '20160103');
insert into money_tbl_02 values(100004, 20160007, 1500, 2, 3000, 'A001', '20160104');
insert into money_tbl_02 values(100004, 20160008, 300, 1, 300, 'A005', '20160104');
insert into money_tbl_02 values(100004, 20160009, 600, 1, 600, 'A006', '20160104');
insert into money_tbl_02 values(100004, 20160010, 3000, 1, 3000, 'A007', '20160106');

select * from money_tbl_02;