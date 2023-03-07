CREATE TABLE mem_tbl_book (
    custno number(6) CONSTRAINT mem_no_pk PRIMARY KEY,
    custname VARCHAR2(20),
    joindate DATE,
    grade CHAR(1),
    address VARCHAR2(60)
);

INSERT INTO mem_tbl_book VALUES(100001, '������', '2019-02-15', 'A', '��� �д籸 ������');
INSERT INTO mem_tbl_book VALUES(100002, '�ּ���', '2019-03-15', 'B', '��� ������ �꺻��');
INSERT INTO mem_tbl_book VALUES(100003, '�����', '2019-04-17', 'A', '��� ������ �꺻��');
INSERT INTO mem_tbl_book VALUES(100004, '������', '2019-12-19', 'B', '��� �д籸 ���ڵ�');
INSERT INTO mem_tbl_book VALUES(100005, '�迵��', '2019-02-15', 'A', '��� �д籸 ���ڵ�');
INSERT INTO mem_tbl_book VALUES(100006, '�ڼ���', '2019-02-15', 'C', '��� ���ν� ���ε�');

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

SELECT * FROM rent_tbl_book;


commit;