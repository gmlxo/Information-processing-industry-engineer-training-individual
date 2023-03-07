CREATE TABLE mem_tbl_book (
    custno number(6) CONSTRAINT mem_no_pk PRIMARY KEY,
    custname VARCHAR2(20),
    joindate DATE,
    grade CHAR(1),
    address VARCHAR2(60)
);

select custno, custname, joindate, DECODE('a', ' VIP', 'b', '일반', 'c', '직원') from mem_tbl_book;
--UPDATE tbl SET tbl.n = tbl.n+1

INSERT INTO mem_tbl_book VALUES(100001, '박정희', '2019-02-15', 'A', '경기 분당구 서현동');
INSERT INTO mem_tbl_book VALUES(100002, '최선한', '2019-03-15', 'B', '경기 군포시 산본동');
INSERT INTO mem_tbl_book VALUES(100003, '김순애', '2019-04-17', 'A', '경기 군포시 산본동');
INSERT INTO mem_tbl_book VALUES(100004, '최정현', '2019-12-19', 'B', '경기 분당구 정자동');
INSERT INTO mem_tbl_book VALUES(100005, '김영림', '2019-02-15', 'A', '경기 분당구 정자동');
INSERT INTO mem_tbl_book VALUES(100006, '박세영', '2019-02-15', 'C', '경기 용인시 용인동');

select * from mem_tbl_book;

CREATE TABLE rent_tbl_book (
    custno NUMBER(6),
    bookno NUMBER(4),
    rentdate date,
    returndate date,
    CONSTRAINT rent_PK PRIMARY KEY(custno, bookno)
);

INSERT INTO rent_tbl_book VALUES(10001, 1234, '2019-02-15', '2019-02-15');
INSERT INTO rent_tbl_book VALUES(10001, 1122, '2019-02-15', '2019-02-16');
INSERT INTO rent_tbl_book VALUES(10002, 1234, '2019-03-15', '2019-02-15');
INSERT INTO rent_tbl_book VALUES(10003, 1234, '2019-04-17', '2019-02-15');
INSERT INTO rent_tbl_book VALUES(10004, 1122, '2019-12-19', '2019-02-15');
INSERT INTO rent_tbl_book VALUES(10005, 1122, '2020-02-15', '2019-02-15');
INSERT INTO rent_tbl_book VALUES(10005, 1113, '2019-02-15', '2019-02-15');
INSERT INTO rent_tbl_book VALUES(10005, 1114, '2019-02-15', '2019-02-15');
INSERT INTO rent_tbl_book VALUES(10006, 1113, '2020-02-15', '2019-02-15');

SELECT COUNT(*) FROM rent_tbl_book WHERE custno = 10001;
select * from rent_tbl_book;

commit;