--- projection : 
-- select : 컬럼명, 연산식(사직연산)
-- from : 테이블
-- selection :  where : 비교연산자와 관계연산자
-- select * from hr.employees
-- where job_id like '%REP%'; 
-- 단일행 : 행의 값을 하나만 이용해서 결과를 가지고 옴  
--         일반함수 : nvl, nvl2 , nullif, 
--         문자열함수 :
--         변환함수 : to_char, to_date

-- 다중행 함수 : 여러행을 이용해서 하나의 결과를 가지고옴
--             sum(), avg(), min(), max(), count()
--             group by, having

-- employees : 직원에 대한 정보
-- departments : 부서들의 정보
-- 20인부서의 직원들을 출력하세요..
select * from hr.employees
where department_id = 20;
-- 20인 부서의 부서명을 출력하세요..
select department_name a
from hr.departments d
where department_id = 20;

--- T-SQL - join
select first_name, last_name, hire_date
     , hr.employees.department_id, department_name
from hr.employees , hr.departments
where hr.employees.department_id 
   = hr.departments.department_id;
   
select first_name, last_name, hire_date
     , e.department_id, department_name
from hr.employees e, hr.departments d
where e.department_id = d.department_id;  

-- 1999 구문 : ansi - join
select first_name, last_name, hire_date
     , e.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where e.department_id = 20;

select first_name, last_name, hire_date
     , e.department_id, department_name
from hr.employees e, hr.departments d
where e.department_id = d.department_id;

select first_name, last_name, hire_date
     , e.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id;

-- 직원들 중 직무가 SH_CLERK인 사원들을 출력하세요.
-- 사원번호, 이름, 급여, 부서명, 직무번호
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID,
       JOB_ID
FROM HR.EMPLOYEES
WHERE JOB_ID ='SH_CLERK'; 
-- 직무 테이블인 JOBS에서 직무가 SH_CLERK인 직무명을 출력하세요.
SELECT JOB_TITLE FROM HR.JOBS
WHERE JOB_ID = 'SH_CLERK';
--- T - SQL -Join
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID,
       HR.jobs.JOB_ID, JOB_TITLE
FROM HR.employees , HR.jobs
WHERE HR.employees.JOB_ID = HR.jobs.JOB_ID;
-- 1999구문 -- Ansi-Join
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID,
       HR.jobs.JOB_ID, JOB_TITLE
FROM HR.employees join HR.jobs
on HR.employees.JOB_ID = HR.jobs.JOB_ID;

SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID,
       e.job_id, j.JOB_ID, JOB_TITLE
FROM HR.employees e join HR.jobs j
on e.JOB_ID = j.JOB_ID;

--- NATURAL JOIN
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID,
       JOB_ID, JOB_TITLE
FROM HR.employees NATURAL join HR.jobs ;
--on e.JOB_ID = j.JOB_ID
--- 두 테이블의 컬럼명이 같아야 한다.
--                                             상사
select * from  hr.employees; --department_id,manager_id
--                                               부서장
select * from hr.departments; --department_id , manager_id
--
select first_name, last_name, hire_date
     , e.department_id, department_name
from hr.employees  join hr.departments d
on e.department_id = d.department_id;


-- 직원들 중 부서장을 상사로 둔 직원들의 부서명을 출력하시오.
-- aNSI - jOIN
select first_name, last_name, hire_date, e.manager_id,
      d.manager_id, d.department_id, department_name
from hr.employees e  join hr.departments d
on e.department_id = d.department_id 
and e.manager_id = d.manager_id ;

select first_name, last_name, hire_date, e.manager_id,
      d.manager_id, d.department_id, department_name
from hr.employees e , hr.departments d
where e.manager_id = d.manager_id
and e.department_id = d.department_id;

select first_name, last_name, hire_date,
      manager_id, department_id, department_name
from hr.employees NATURAL  join  hr.departments;
