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




