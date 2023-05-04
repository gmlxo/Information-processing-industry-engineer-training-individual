create table tbl_employee_202205__gmlxo (
	emp_no char(4) primary key,
	emp_name varchar2(14),
	dept_code char(2),
	hire_date varchar2(8),
	job char(1),
	salary number(9)
);
--select * from tbl_work_202205__gmlxo where emp_no='E001'

create table tbl_work_202205__gmlxo (
	emp_no char(4) primary key,
	absence number(3),
	night number(3),
	holiday number(3),
	business_trip number(3)
);

create table tbl_department_202205__gmlxo (
	dept_code char(2)  primary key,
	dept_name varchar2(20),
	location varchar2(20)	
);

select 
		d.dept_code,
		d.dept_name,
		d.location,
		count(e.dept_code) as sum,
		to_char(SUM(e.salary), '999,999,999') as salary,
		to_char(((SUM(w.absence * -1) + SUM(w.night * 2) + SUM(w.holiday * 4) + SUM(w.business_trip * 3))*10000), '999,999,999') as subang,
		to_char(SUM(e.salary)+((SUM(w.absence * -1) + SUM(w.night * 2) + SUM(w.holiday * 4) + SUM(w.business_trip * 3))*10000), '999,999,999') as allSUM
from TBL_DEPARTMENT_202205__GMLXO d, TBL_EMPLOYEE_202205__GMLXO e, tbl_work_202205__gmlxo w
where d.dept_code = e.dept_code and e.emp_no = w.emp_no
group by d.dept_code, d.dept_name, d.location
order by d.dept_code asc;

select d.dept_code,to_char(SUM(e.salary)+((SUM(w.absence * -1) + SUM(w.night * 2) + SUM(w.holiday * 4) + SUM(w.business_trip * 3))*10000), '999,999,999') as allSUM
from TBL_DEPARTMENT_202205__GMLXO d, TBL_EMPLOYEE_202205__GMLXO e, tbl_work_202205__gmlxo w
where d.dept_code = e.dept_code and e.emp_no = w.emp_no
group by d.dept_code, e.dept_code
order by d.dept_code asc;

--select * from TBL_DEPARTMENT_202205__GMLXO where emp_no=?;

select
		e.emp_no,
		e.emp_name,
		to_char(to_date(e.hire_date, 'yyyymmdd'), 'yyyy"-"mm"-"dd') as hire_date,
		d.dept_name,
		e.job,
		w.absence,
		w.night,
		w.holiday,
		w.business_trip,
		to_char(e.salary, '999,999,999') as salary 
from tbl_employee_202205__gmlxo e, tbl_work_202205__gmlxo w, tbl_department_202205__gmlxo d
where e.emp_no = w.emp_no and e.dept_code = d.dept_code
order by e.emp_no asc;

--delete TBL_EMPLOYEE_202205__GMLXO where emp_no = 'E011';
--select * from TBL_DEPARTMENT_202205__GMLXO where emp_no='E001'

insert into TBL_EMPLOYEE_202205__GMLXO values ('E001', '김길동', 10, 20100101, 9, 5000000);
insert into TBL_EMPLOYEE_202205__GMLXO values ('E002', '이길동', 10, 20100102, 7, 4000000);
insert into TBL_EMPLOYEE_202205__GMLXO values ('E003', '박길동', 10, 20100103, 6, 3500000);
insert into TBL_EMPLOYEE_202205__GMLXO values ('E004', '조길동', 20, 20100104, 4, 3000000);
insert into TBL_EMPLOYEE_202205__GMLXO values ('E005', '황길동', 20, 20100105, 4, 3000000);
insert into TBL_EMPLOYEE_202205__GMLXO values ('E006', '최길동', 20, 20100106, 1, 2000000);
insert into TBL_EMPLOYEE_202205__GMLXO values ('E007', '왕길동', 30, 20100107, 1, 2000000);
insert into TBL_EMPLOYEE_202205__GMLXO values ('E008', '고길동', 30, 20100108, 2, 2300000);
insert into TBL_EMPLOYEE_202205__GMLXO values ('E009', '용길동', 30, 20100109, 2, 2300000);
insert into TBL_EMPLOYEE_202205__GMLXO values ('E010', '현길동', 40, 20100110, 3, 2800000);

insert into TBL_WORK_202205__GMLXO values ('E001', 2, 2, 1, 5);
insert into TBL_WORK_202205__GMLXO values ('E002', 3, 3, 2, 2);
insert into TBL_WORK_202205__GMLXO values ('E003', 2, 5, 3, 3);
insert into TBL_WORK_202205__GMLXO values ('E004', 2, 5, 2, 4);
insert into TBL_WORK_202205__GMLXO values ('E005', 0, 5, 2, 4);
insert into TBL_WORK_202205__GMLXO values ('E006', 3, 3, 2, 0);
insert into TBL_WORK_202205__GMLXO values ('E007', 2, 4, 3, 0);
insert into TBL_WORK_202205__GMLXO values ('E008', 0, 5, 4, 0);
insert into TBL_WORK_202205__GMLXO values ('E009', 0, 10, 2, 1);
insert into TBL_WORK_202205__GMLXO values ('E010', 0, 8, 5, 1);

insert into TBL_DEPARTMENT_202205__GMLXO values (10, '인사팀', '서울특별시');
insert into TBL_DEPARTMENT_202205__GMLXO values (20, '회계팀', '서울특별시');
insert into TBL_DEPARTMENT_202205__GMLXO values (30, '개발팀', '경기도');
insert into TBL_DEPARTMENT_202205__GMLXO values (40, '홍보팀', '경기도');