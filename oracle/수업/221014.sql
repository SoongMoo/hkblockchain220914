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

���̺� �ִ� ���� ����;
delete from departments;
select * from departments;

insert into departments
select * from hr.departments;

select * from departments;
20�� �μ��� 40�� �μ��� ����ϼ���;
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

70�κμ��� ���;
select * from employees
where department_id = 70;

delete from employees
where department_id = 70;

Donald�� ���� �ִ� �μ��� ������ �����Ͻÿ�.;
select department_id from employees
where first_name = 'Donald';

delete from employees
where department_id = 50;

delete from employees
where department_id = (select department_id from employees
where first_name = 'Donald');


select * from employees;
������ MK_REP�̰� �޿��� 6000�� �ʰ��ϴ� ����� �����Ͻÿ�.;
select * from employees
where job_id = 'MK_REP' and salary >= 6000;

delete from employees
where job_id = 'MK_REP' and salary >= 6000;

select * from employees;

Public�� �����ϰ� �ִ� ������ ����ϴ� ����� ����ϼ���.;
select * from employees
where job_id like '%Public%';
Public�� �����ϰ� �ִ� ������ ����ϴ� ����� �����ϼ���.;
delete from employees
where job_id like '%Public%';

Susan�� �޿��� Susand�� ������ ���� ������� ����ϼ���?;
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
Susan�� �޿��� Susand�� ������ ���� ������� �����ϼ���?;
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

�����ȣ 178�� �μ���ȣ�� 80������ �����ϼ���.;
UPDATE EMPLOYEES
SET DEPARTMENT_ID = 80
where employee_id = 178;
ROLLBACK;
SELECT * FROM EMPLOYEES
where employee_id = 178;

113���� ������ AC_MGR�� �����Ͻð� �޿��� 12000�� �����ϼ���;
select job_id , salary from employees
where employee_id = 113;

update employees
set job_id = 'AC_MGR' ,
    salary = 12000
where employee_id = 113;

113���� ������ 114���� ���� �����ϰ� �޿��� 200�� �޿��� �����ϼ���.;
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

113���� ������ �޿��� 200�� ������ �޿��� �����Ͻÿ�.;
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


200���� ������ ���� ����� ���� �μ��� 100�� ����� �μ��� ���� �ϼ���;
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
    dname CHAR(14), ---��/�� , F/M 
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
values(1, '�̼���', '12234');
select * from dept;
insert into dept(deptno, dname, loc, create_date)
values(2, '�̼���', null, sysdate);
insert into dept(deptno, dname, create_date)
values(2, '�̼���',  default);
insert into dept(deptno, dname, loc, create_date)
values(4, '�̼���', '23232', 
        to_date('03-12-1999','dd-mm-yyyy')); -- RR-MM-DD
select * from dept;
insert into dept(deptno, dname, loc, create_date)
values(5, '�̼���', '23232', '1999-10-30');
DESCRIBE dept;

create table test1(
    dno int not null,
    dname Integer    
);

--insert into test1(dname)values(2);
insert into test1(dno,dname)values(1,2);
select * from test1;
insert into test1(dno)values(1);

constraint : ��������;
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
values(1, '�̼���', '1234', default);
select * from dept;
--insert into dept(deptno,dname,loc,create_date )
--values(1, '�����', '2334', sysdate);
insert into dept(deptno,dname,loc,create_date )
values(2, '�̼���', '1234', sysdate);
select * from dept;
drop table dept;
create table dept(
    deptno number(2) primary key,
    dname varchar2(14) ,
    loc varchar2(13) primary key, 
    --���̺��� �ϳ��� �⺻ Ű�� ���� �� �ֽ��ϴ�.
    create_date date default sysdate
);

create table dept(
    deptno number(2) primary key,
    --NULL�� ("SMRIT"."DEPT"."DEPTNO") �ȿ� ������ �� �����ϴ�
    dname varchar2(14) ,
    loc varchar2(13) UNIQUE, 
    email varchar2(50) UNIQUE,
    create_date date default sysdate
);
insert into dept(dname,loc, email, create_date )
values('�̼���', '122' ,'high', sysdate);

insert into dept(deptno, dname,loc, email, create_date )
values(1,'�̼���', '122' ,'high', sysdate);
select * from dept;
insert into dept(deptno, dname,loc, email, create_date )
values(2,'�̼���', '123' ,'land', sysdate);
select * from dept;

insert into dept(deptno, dname,loc, create_date )
values(3,'�̼���', '124' , sysdate);
select * from dept;
drop table dept;
create table dept(
    deptno number(2) primary key,
    --NULL�� ("SMRIT"."DEPT"."DEPTNO") �ȿ� ������ �� �����ϴ�
    dname varchar2(14) ,
    loc varchar2(13) not null UNIQUE, 
    email varchar2(50) UNIQUE,
    create_date date default sysdate
);
insert into dept(deptno, dname, loc, email, create_date)
values(1, '�̼���', '123', 'high', sysdate);
select * from dept;
insert into dept(deptno, dname,  email, create_date)
values(2, '�̼���',  'land', sysdate);
select * from dept;
insert into dept(deptno, dname, loc,  create_date)
values(2, '�̼���', '124', sysdate);
select * from dept;
insert into dept(deptno, dname, loc,  create_date)
values(3, '�̼���', '125', sysdate);
select * from dept;

insert into dept(deptno, dname, loc,  create_date)
values(1, '�̼���', '125', sysdate);

select * from dba_constraints
where table_name = 'DEPT';

drop table dept;
create table dept( -- ������
    deptno number(2) constraint dept_deptno_PK primary key,
    --NULL�� ("SMRIT"."DEPT"."DEPTNO") �ȿ� ������ �� �����ϴ�
    dname varchar2(14) ,
    loc varchar2(13) not null constraint dept_loc_UU UNIQUE, 
    email varchar2(50) constraint dept_email_UU UNIQUE,
    create_date date default sysdate
);

select * from dba_constraints
where table_name = 'DEPT';
insert into dept(deptno, dname, email, create_date)
values(1, '�̼���', 'high', sysdate);
-- NULL�� ("SMRIT"."DEPT"."LOC") �ȿ� ������ �� �����ϴ�

insert into dept(deptno, dname,loc, email, create_date)
values(1, '�̼���','123', 'high', sysdate);
select * from dept;
insert into dept(deptno, dname,loc, email, create_date)
values(1, '�̼���','124', 'land', sysdate);
-- ���Ἲ ���� ����(SMRIT.DEPT_DEPTNO_PK)�� ����˴ϴ�
insert into dept(deptno, dname,loc, email, create_date)
values(2, '�̼���','123', 'land', sysdate);
-- ���Ἲ ���� ����(SMRIT.DEPT_LOC_UU)�� ����˴ϴ�
