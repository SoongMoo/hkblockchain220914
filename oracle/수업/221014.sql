
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



