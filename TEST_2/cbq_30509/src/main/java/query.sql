CREATE TABLE tbl_emplotee_202205(
	emp_no char(4) PRIMARY KEY,
	emp_name varchar2(14),
	dept_code char(2),
	hire_date varchar2(8),
	job char(1),
	salary number(9)
);

CREATE TABLE tbl_work_202205(
	emp_no char(4) PRIMARY KEY,
	absence number(3),
	night number(3),
	holiday number(3),
	business_trip number(3)
);

create table tbl_department_202205 (
	dept_code char(2) primary key,
	dept_name varchar2(20),
	location varchar2(20)
);

select * from tbl_department_202205;

select e.emp_no,
	   e.emp_name,
	   substr(e.hire_date, 0, 4) YYYY,
	   substr(e.hire_date, 5, 2) MM,
	   substr(e.hire_date, 7, 2) DD,
	   d.dept_name,
	   e.job,
	   w.absence,
	   w.night,
	   w.holiday,
	   w.business_trip,
	   to_char(e.salary, '999,999,999') salary
from tbl_emplotee_202205 e, 
	tbl_work_202205 w, 
	tbl_department_202205 d 
where e.emp_no = w.emp_no and e.dept_code = d.dept_code
order by e.emp_no asc;

insert into TBL_EMPLOTEE_202205 values ('E001', '김길동', '10', '20010101', '9', 5000000);
insert into TBL_EMPLOTEE_202205 values ('E002', '이길동', '10', '20010102', '7', 4000000);
insert into TBL_EMPLOTEE_202205 values ('E003', '박길동', '10', '20010103', '6', 3500000);
insert into TBL_EMPLOTEE_202205 values ('E004', '조길동', '20', '20010104', '4', 3000000);
insert into TBL_EMPLOTEE_202205 values ('E005', '황길동', '20', '20010105', '4', 3000000);
insert into TBL_EMPLOTEE_202205 values ('E006', '최길동', '20', '20010106', '1', 2000000);
insert into TBL_EMPLOTEE_202205 values ('E007', '왕길동', '30', '20010107', '1', 2000000);
insert into TBL_EMPLOTEE_202205 values ('E008', '고길동', '30', '20010108', '2', 2300000);
insert into TBL_EMPLOTEE_202205 values ('E009', '용길동', '30', '20010109', '2', 2300000);
insert into TBL_EMPLOTEE_202205 values ('E010', '현길동', '40', '20010110', '3', 2800000);

insert into tbl_work_202205 values ('E001', 2, 2, 1, 5);
insert into tbl_work_202205 values ('E002', 3, 3, 2, 2);
insert into tbl_work_202205 values ('E003', 2, 5, 3, 3);
insert into tbl_work_202205 values ('E004', 2, 5, 2, 4);
insert into tbl_work_202205 values ('E005', 0, 5, 2, 4);
insert into tbl_work_202205 values ('E006', 3, 3, 2, 0);
insert into tbl_work_202205 values ('E007', 2, 4, 3, 0);
insert into tbl_work_202205 values ('E008', 0, 5, 4, 0);
insert into tbl_work_202205 values ('E009', 0, 10, 2, 1);
insert into tbl_work_202205 values ('E010', 0, 8, 5, 1);

insert into tbl_department_202205 values (10, '인사팀', '서울특별시');
insert into tbl_department_202205 values (20, '회계팀', '서울특별시');
insert into tbl_department_202205 values (30, '개발팀', '경기도');
insert into tbl_department_202205 values (40, '홍보팀', '경기도');
