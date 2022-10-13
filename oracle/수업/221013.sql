--카티시안 곱
--A   B
--1   4
--2   5
--3 
--{1,4}{1,5}{2,4}{2,5}{3,4}{3,5}
select first_name, last_name, salary,
        e.department_id, department_name
from hr.employees e, hr.departments d; 
 -- 107 * 27 = 2889
select first_name, last_name, salary,
        e.department_id, department_name
from hr.employees e CROSS join hr.departments d;

select count(*) from hr.employees; -- 107
select count(*) from hr.departments; -- 27

select manager_id from hr.employees
where employee_id = 103;

select e1.employee_id, e2.employee_id
from hr.employees e1 , hr.employees e2
where e1.manager_id = e2.employee_id
and e1.employee_id = 103;

select e1.employee_id, e2.employee_id
from hr.employees e1 join hr.employees e2
on e1.manager_id = e2.employee_id
where e1.employee_id = 103;

select manager_id from hr.employees
where employee_id = 103;

select * from hr.employees
where employee_id = 102;

select * from hr.employees
where employee_id = (select manager_id from hr.employees
where employee_id = 103);

--- 90인 부서의 평균 급여
select trunc(avg(salary),-3)
from hr.employees
where department_id = 90;

select * from hr.employees
where salary > (select trunc(avg(salary),-3)
from hr.employees
where department_id = 90);

--  Rogers사원보다 먼저 입사한 사원을 구하시오?
select hire_date from hr.employees
where last_name = 'Rogers';

select * from hr.employees
where hire_date < (select hire_date from hr.employees
                   where last_name = 'Rogers');

-- Rogers의 직무와 같고 Rogers의 급여보다 많이 받는 사원을 구하시오.
select job_id from hr.employees
where last_name = 'Rogers'; --- ST_CLERK

select salary from hr.employees
where last_name = 'Rogers'; --- 2900

select * from hr.employees
where job_id = (select job_id from hr.employees
                where last_name = 'Rogers')
AND SALARY > (select salary from hr.employees
             where last_name = 'Rogers');

--- 급여를 제일 적게 받는 직원을 출력하세요.
SELECT min(salary)
from hr.employees;

select * from hr.employees
where salary = (SELECT min(salary)
from hr.employees);

-- 사원번호, 이름 , 직무 , 급여, Rogers의 입사일도 같이 출력하세요,
select hire_date from hr.employees
where last_name = 'Rogers';
select employee_id, first_name, job_id, salary, 
        (select hire_date from hr.employees
        where last_name = 'Rogers') Rogers_hire_date
from hr.employees;

-- 각 부서의 최소급여가 50인 부서의 최소 급여보다 큰 
-- 부서와 최소금액을 출력하세요.
select min(salary)
from hr.employees
where department_id = 50;

select department_id , min(salary)
from hr.employees
group by department_id
having min(salary) > (select min(salary)
                      from hr.employees
                      where department_id = 50);

-- 다중행 서브쿼리
--- Taylor사원이 가진 직무와 같은 직무를 하고 있는 사원들을 출력
select job_id from hr.employees
where last_name = 'Taylor';
-- 'SA_REP'또는 'SH_CLERK'를 하는 사원들을 구하시오.
select * from hr.employees
where job_id = 'SA_REP' or job_id = 'SH_CLERK';

select * from hr.employees
where job_id in ('SA_REP', 'SH_CLERK');

select * from hr.employees
where job_id  in  (select job_id from hr.employees
                where last_name = 'Taylor');

--- Rogers와 같은 직무를 하는 사원들을 구하게요.
select * from hr.employees
where job_id in (select job_id from hr.employees 
                where last_name = 'Rogers');
                
-- Haas사원이 하는 직무와 같은 직무를 하는 직원들을 구하세요.

-- 각 부서의 최소 급여를 받는 사원들을 구하시오.
select min(salary) from hr.employees
group by department_id;

select * from hr.employees
where salary in (select min(salary) from hr.employees
group by department_id);


---4200, 4800, 6000, 9000의 최소보다 큰 급여를 받는 사원을 구하시오.
select * from hr.employees
where salary > any (4200, 4800, 6000, 9000);
-- 60인 부서 최소 급여보다 더 많이 받는 직원들을 구하시오.
select * from hr.employees
where salary > (select min(salary) from hr.employees
                where department_id = 60); -- 단일행
select * from hr.employees
where salary > any (select salary from hr.employees
                where department_id = 60); -- 다중행

-- 직무가 'IT_PROG'인 사원들 중 급여를 제일 많이 받는 사람보다 작게
-- 받는 사원들을 구하시오.
select Max(salary) from hr.employees
where job_id = 'IT_PROG';

select * from hr.employees
where salary < (select Max(salary) from hr.employees
where job_id = 'IT_PROG');

-- 다중 행 연산자 
select * from hr.employees
where salary < any (select salary from hr.employees        
                    where job_id = 'IT_PROG');
-- in , any, all
-- 직무가 IT_PROG인 사원들의 급여중 제일 많이 받는 급여보다 더 많이 
-- 받는 사원을 구하시오.
select MAX(salary) from hr.employees
where job_id = 'IT_PROG';

select * from hr.employees
where salary > 9000;

select * from hr.employees
where salary > all (select salary from hr.employees
                where job_id = 'IT_PROG') ;

-- 직무가 IT_PROG인 사원들의 급여중 제일 작게 받는 급여보다 더 작게 
-- 받는 사원을 구하시오.
select MIN(salary) from hr.employees
where job_id = 'IT_PROG';

select * from hr.employees
where salary < (select MIN(salary) from hr.employees
                where job_id = 'IT_PROG');

select * from hr.employees
where salary < all (select salary from hr.employees
                where job_id = 'IT_PROG');
                
-- 가장 많은 사원이 하는 직무는 무엇일까?
select max(count(*)) from hr.employees
group by job_id;

select job_id from hr.employees
group by job_id
having count(*) = (select max(count(*)) from hr.employees
                    group by job_id);

select * from hr.employees
where job_id = (select job_id from hr.employees
                group by job_id
                having count(*) = (select max(count(*)) 
                                   from hr.employees
                                   group by job_id));

-- 다중행 연산자 사용
-- 직무가 IT_PROG에서  제일 많이 받는 급여보다 더 많이 받는 사원을 
-- 구하는데 IT_PROG는 제외해서 출력하시오.
SELECT * FROM HR.EMPLOYEES
WHERE SALARY > ALL (SELECT salary
                    FROM HR.employees
                    WHERE job_id = 'IT_PROG')
AND JOB_ID ^= 'IT_PROG';
                      
select * from hr.employees
where job_id  in  (select job_id from hr.employees
                where last_name = 'Taylor');
                
select * from hr.employees
where job_id  = ANY  (select job_id from hr.employees
                where last_name = 'Taylor');

-- 90인 부서의 급여와 같은 급여를 받는 사원들을 구하시오.
SELECT * FROM HR.EMPLOYEES
WHERE SALARY IN (SELECT salary from hr.employees
                 where department_id = 90);
-- 90인 부서의 급여와 같지 않은 사원들을 구하시오.
SELECT * FROM HR.EMPLOYEES
WHERE SALARY not IN (SELECT salary from hr.employees
                 where department_id = 90);

select employee_id 
from hr.employees
where last_name = 'Taylor';


select employee_id, job_id from hr.employees
union 
select employee_id, job_id from hr.job_history
order by 1;

desc hr.employees


---select emp_id from employees where emp_id = 'highland0'
-- union
---select user_id from member where user_id = 'highland0'

-- select user_id, user_pw ,user_email
-- from member 
-- where user_id = 'highland0' 
-- and user_pw = '12345'
-- union
-- select emp_id , emp_pw , emp_email
-- from employees
-- where emp_id = 'highland0'
-- and emp_id = '12345'
-- union
-- select user_id, user_pw ,user_email
-- from administrator 
-- where user_id = 'highland0' 
-- and user_pw = '12345'

select employee_id, job_id from hr.employees
union all
select employee_id, job_id from hr.job_history
order by 1;

-- INTERSECT : 교집합
select employee_id, job_id from hr.employees
INTERSECT
select employee_id, job_id from hr.job_history
order by 1;

--- minus
select employee_id, job_id from hr.employees
minus
select employee_id, job_id from hr.job_history
order by 1;

select employee_id, job_id from hr.job_history
minus
select employee_id, job_id from hr.employees
order by 1;

select employee_id, to_char(null) , salary , hire_date, to_number(null)
from hr.employees
union
select employee_id, job_id, to_number(null), to_date(null), department_id
from hr.job_history;

select * from hr.job_history;

desc hr.departments;
---------------------------------------------
DEPARTMENT_ID   NOT NULL NUMBER(4)    
DEPARTMENT_NAME NOT NULL VARCHAR2(30) 
MANAGER_ID               NUMBER(6)    
LOCATION_ID              NUMBER(4);
---------------------------------------------
drop table departments;
create table departments(
    DEPARTMENT_ID NUMBER not null,
    DEPARTMENT_NAME VARCHAR2(30) not null,
    MANAGER_ID NUMBER(6),
    LOCATION_ID NUMBER(4)
);  

desc departments;
select * from departments;
desc hr.employees;
---------------------------------------------------------------------
EMPLOYEE_ID    NOT NULL NUMBER(6)    
FIRST_NAME              VARCHAR2(20) 
LAST_NAME      NOT NULL VARCHAR2(25) 
EMAIL          NOT NULL VARCHAR2(25) 
PHONE_NUMBER            VARCHAR2(20) 
HIRE_DATE      NOT NULL DATE         default sysdate  
JOB_ID         NOT NULL VARCHAR2(10) 
SALARY                  NUMBER(8,2) 
COMMISSION_PCT          NUMBER(2,2)  
MANAGER_ID              NUMBER(6)    
DEPARTMENT_ID           NUMBER(4)
-------------------------------------------------------------------
drop table employees;

desc employees;
select * from employees;

INSERT INTO departments(department_name, department_id,
 manager_id, location_id)
VALUES ('Public Relations',70,  100, 1700);


insert into employees(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,
PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY,COMMISSION_PCT, 
MANAGER_ID,DEPARTMENT_ID )
values(199,'Douglas','Grant', 'DGRANT','650.507.9844','08/01/13',
'SH_CLERK',2600,null,124,50);
01071461970
select * from hr.employees;

insert into employees(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,
PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY,
MANAGER_ID,DEPARTMENT_ID )
values(198,'Donald','OConnell','DOCONNEL','650.507.9833',
'07/06/21','SH_CLERK',2600,124,50);

insert into employees
values(200,'Jennifer','Whalen','JWHALEN','515.123.4444',
'03/09/17','AD_ASST',4400,null,101,10);

insert into employees(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,
PHONE_NUMBER, JOB_ID, SALARY, MANAGER_ID,DEPARTMENT_ID)
values(201,'Michael','Hartstein','MHARTSTE','515.123.5555',
'MK_MAN','13000',100,20);

insert into employees(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,
PHONE_NUMBER,hire_date, JOB_ID, SALARY,commission_pct,
MANAGER_ID,DEPARTMENT_ID)
values(202,'Pat','Fay','PFAY','603.123.6666',default,'MK_REP',
6000,default,201,20);

insert into employees(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,
PHONE_NUMBER,hire_date, JOB_ID, SALARY,commission_pct,
MANAGER_ID,DEPARTMENT_ID)
values(203,'Susan','Mavris','SMAVRIS','515.123.7777',
sysdate,'HR_REP',6500,null,101,40);

insert into employees(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,
PHONE_NUMBER,hire_date, JOB_ID, SALARY,commission_pct,
MANAGER_ID,DEPARTMENT_ID)
values( (select max(employee_id) +1 from employees) ,'Hermann',
'Baer', 'HBAER', '515.123.8888', sysdate, 'PR_REP',10000,
default, 101, 70);

select * from employees;

--- 마지막 사원 번호의 다음을 값을 가지고 오시오.
select max(employee_id) +1 from employees;
