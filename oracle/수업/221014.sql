create table departments(
    DEPARTMENT_ID NUMBER not null,
    DEPARTMENT_NAME VARCHAR2(30) not null,
    MANAGER_ID NUMBER(6),
    LOCATION_ID NUMBER(4)
);  
select * from departments;

create table employees(
EMPLOYEE_ID     NUMBER(6)  NOT NULL  ,
FIRST_NAME      VARCHAR2(20) ,
LAST_NAME       VARCHAR2(25) NOT NULL,
EMAIL           VARCHAR2(25) NOT NULL,
PHONE_NUMBER    VARCHAR2(20), 
HIRE_DATE       DATE         ,
JOB_ID          VARCHAR2(10) NOT NULL,
SALARY          NUMBER(8,2),  
COMMISSION_PCT  NUMBER(2,2),  
MANAGER_ID      NUMBER(6) ,   
DEPARTMENT_ID           NUMBER(4)
);
delete from employees;
select * from employees;

insert into employees
select * from hr.employees;

select * from employees;

select * from departments;

insert into departments(department_id, department_name, 
       manager_id, location_id)
select department_id, department_name, 
       manager_id, location_id
from hr.departments;

select * from departments;

테이블에 있는 행을 삭제;
delete from departments;
select * from departments;

insert into departments
select * from hr.departments;

select * from departments;
20번 부서와 40번 부서를 출력하세요;
select * from departments
where department_id in (20, 40);

delete from departments
where department_id in (20, 40);

select * from departments
where department_id = 70;

delete from departments
where department_id = 70;

select * from departments;

select * from employees;

delete from employees;
insert into employees
select * from hr.employees;

70인부서의 사원;
select * from employees
where department_id = 70;

delete from employees
where department_id = 70;

Donald가 속해 있는 부서의 직원을 삭제하시오.;
select department_id from employees
where first_name = 'Donald';

delete from employees
where department_id = 50;

delete from employees
where department_id = (select department_id from employees
where first_name = 'Donald');


select * from employees;
직무가 MK_REP이고 급여가 6000을 초과하는 사원을 삭제하시오.;
select * from employees
where job_id = 'MK_REP' and salary >= 6000;

delete from employees
where job_id = 'MK_REP' and salary >= 6000;

select * from employees;

Public을 포함하고 있는 직무를 담당하는 사원을 출력하세요.;
select * from employees
where job_id like '%Public%';
Public을 포함하고 있는 직무를 담당하는 사원을 삭제하세요.;
delete from employees
where job_id like '%Public%';

Susan의 급여와 Susand의 직무가 같은 사원들을 출력하세요?;
select salary from employees
where first_name = 'Susan';
select job_id from employees
where first_name = 'Susan';

select * from employees
where salary = 6500 
and job_id = 'HR_REP';

select * from employees
where salary = (select salary from employees
                where first_name = 'Susan') 
and job_id = (select job_id from employees
               where first_name = 'Susan');
Susan의 급여와 Susand의 직무가 같은 사원들을 삭제하세요?;
delete from employees
where salary = (select salary from employees
                where first_name = 'Susan') 
and job_id = (select job_id from employees
               where first_name = 'Susan');


delete from employees;
select * from employees;
rollback;
select * from employees;

TRUNCATE table employees;
select * from employees;
rollback;
select * from employees;

insert into employees
select * from hr.employees;
commit;
-- DML
-- select , insert , delete, TRUNCATE, update
C : create : insert
R : read   : select
U : update : update
D : delete : delete, TRUNCATE;
-------------------------------------------
--- update
SELECT * FROM EMPLOYEES
WHERE EMPLOYEE_ID = 178;

사원번호 178의 부서번호를 80번으로 변경하세요.;
UPDATE EMPLOYEES
SET DEPARTMENT_ID = 80
where employee_id = 178;
ROLLBACK;
SELECT * FROM EMPLOYEES
where employee_id = 178;

113번의 직무를 AC_MGR로 변경하시고 급여를 12000로 변경하세요;
select job_id , salary from employees
where employee_id = 113;

update employees
set job_id = 'AC_MGR' ,
    salary = 12000
where employee_id = 113;

113번의 직무를 114번의 직무 변경하고 급여는 200번 급여로 변경하세요.;
select job_id from employees
where employee_id = 114; -- PU_MAN
select salary from employees
where employee_id = 200;  --- 4400

update employees
set job_id = 'PU_MAN',
    salary = 4400
where employee_id = 113;

update employees
set job_id = (select job_id from employees
                where employee_id = 114),
    salary = (select salary from employees
                where employee_id = 200)
where employee_id = 113;
select * from employees
where employee_id = 113;

113번의 직무와 급여를 200번 직무와 급여로 변경하시오.;
UPDATE employees
SET (job_id, salary) = (SELECT job_id, salary
                        FROM employees
                        WHERE employee_id = 200)
WHERE employee_id = 113;

UPDATE employees
SET job_id = (SELECT job_id
                FROM employees
                WHERE employee_id = 200),
    salary = (SELECT salary
                FROM employees
                WHERE employee_id = 200)
WHERE employee_id = 113;


200번의 직무를 가진 사원에 대해 부서를 100번 사원의 부서로 변경 하세요;
select job_id from employees
where employee_id = 200;
select department_id from employees
where employee_id = 100;

update employees
set department_id = 90
where job_id = 'AD_ASST';

update employees
set department_id = (select department_id from hr.employees
                        where employee_id = 100)
where job_id = (select job_id from hr.employees
                        where employee_id = 200);

CREATE TABLE dept(   
    deptno NUMBER(2), 
    dname CHAR(14), ---남/여 , F/M 
    loc VARCHAR2(13), 
    create_date DATE DEFAULT SYSDATE
); 
--------java--------------------
public class Dept{
   int deptno;
   String dname;
   String loc;
   Date createDate;
};
----------------------------------
insert into dept(deptno, dname, loc)
values(1, '이숭무', '12234');
select * from dept;
insert into dept(deptno, dname, loc, create_date)
values(2, '이숭무', null, sysdate);
insert into dept(deptno, dname, create_date)
values(2, '이숭무',  default);
insert into dept(deptno, dname, loc, create_date)
values(4, '이숭무', '23232', 
        to_date('03-12-1999','dd-mm-yyyy')); -- RR-MM-DD
select * from dept;
insert into dept(deptno, dname, loc, create_date)
values(5, '이숭무', '23232', '1999-10-30');
DESCRIBE dept;

create table test1(
    dno int not null,
    dname Integer    
);

--insert into test1(dname)values(2);
insert into test1(dno,dname)values(1,2);
select * from test1;
insert into test1(dno)values(1);

constraint : 제약조건;
- NOT NULL
? UNIQUE
? PRIMARY KEY
? FOREIGN KEY
? CHECK

select * from dept;
drop table dept;
select * from dept;

create table dept(
    deptno number(2) primary key,
    dname varchar2(14),
    loc varchar2(13),
    create_date date default sysdate
);
insert into dept(deptno,dname,loc,create_date )
values(1, '이숭무', '1234', default);
select * from dept;
--insert into dept(deptno,dname,loc,create_date )
--values(1, '이장범', '2334', sysdate);
insert into dept(deptno,dname,loc,create_date )
values(2, '이숭무', '1234', sysdate);
select * from dept;
drop table dept;
create table dept(
    deptno number(2) primary key,
    dname varchar2(14) ,
    loc varchar2(13) primary key, 
    --테이블에는 하나의 기본 키만 가질 수 있습니다.
    create_date date default sysdate
);

create table dept(
    deptno number(2) primary key,
    --NULL을 ("SMRIT"."DEPT"."DEPTNO") 안에 삽입할 수 없습니다
    dname varchar2(14) ,
    loc varchar2(13) UNIQUE, 
    email varchar2(50) UNIQUE,
    create_date date default sysdate
);
insert into dept(dname,loc, email, create_date )
values('이숭무', '122' ,'high', sysdate);

insert into dept(deptno, dname,loc, email, create_date )
values(1,'이숭무', '122' ,'high', sysdate);
select * from dept;
insert into dept(deptno, dname,loc, email, create_date )
values(2,'이숭무', '123' ,'land', sysdate);
select * from dept;

insert into dept(deptno, dname,loc, create_date )
values(3,'이숭무', '124' , sysdate);
select * from dept;
drop table dept;
create table dept(
    deptno number(2) primary key,
    --NULL을 ("SMRIT"."DEPT"."DEPTNO") 안에 삽입할 수 없습니다
    dname varchar2(14) ,
    loc varchar2(13) not null UNIQUE, 
    email varchar2(50) UNIQUE,
    create_date date default sysdate
);
insert into dept(deptno, dname, loc, email, create_date)
values(1, '이숭무', '123', 'high', sysdate);
select * from dept;
insert into dept(deptno, dname,  email, create_date)
values(2, '이숭무',  'land', sysdate);
select * from dept;
insert into dept(deptno, dname, loc,  create_date)
values(2, '이숭무', '124', sysdate);
select * from dept;
insert into dept(deptno, dname, loc,  create_date)
values(3, '이숭무', '125', sysdate);
select * from dept;

insert into dept(deptno, dname, loc,  create_date)
values(1, '이숭무', '125', sysdate);

select * from dba_constraints
where table_name = 'DEPT';

drop table dept;
create table dept( -- 열레벨
    deptno number(2) constraint dept_deptno_PK primary key,
    --NULL을 ("SMRIT"."DEPT"."DEPTNO") 안에 삽입할 수 없습니다
    dname varchar2(14) ,
    loc varchar2(13) not null constraint dept_loc_UU UNIQUE, 
    email varchar2(50) constraint dept_email_UU UNIQUE,
    create_date date default sysdate
);

select * from dba_constraints
where table_name = 'DEPT';
insert into dept(deptno, dname, email, create_date)
values(1, '이숭무', 'high', sysdate);
-- NULL을 ("SMRIT"."DEPT"."LOC") 안에 삽입할 수 없습니다

insert into dept(deptno, dname,loc, email, create_date)
values(1, '이숭무','123', 'high', sysdate);
select * from dept;
insert into dept(deptno, dname,loc, email, create_date)
values(1, '이숭무','124', 'land', sysdate);
-- 무결성 제약 조건(SMRIT.DEPT_DEPTNO_PK)에 위배됩니다
insert into dept(deptno, dname,loc, email, create_date)
values(2, '이숭무','123', 'land', sysdate);
-- 무결성 제약 조건(SMRIT.DEPT_LOC_UU)에 위배됩니다
