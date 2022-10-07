--select
--projection : 원하는 열을 가져오기 : 컬럼 , 연산식(산술연산)
--select 10 * 5
--from 테이블 
--selection :  원하는 행을 가져오기 : where
--             필요한 연산 : 논리연산, 비교연산
-- select
-- from 
-- where
-- 데이터를 가공을 해서 가지고 옴 : 함수
-- 문자열 함수 :  대문자, 소문자, 연결함수, 잘라내기, 글자의 갯수
--              대체 , 공문자 제거, lpad, rpad 
-- 숫자 함수 : round, trunc, mod
-- 날짜 함수 : LAST_DAY, NEXT_DAY
-- 
-- 변환 함수: *****

select '10' + '10'
from dual;

--- 문자 변환함수 : 날짜를 문자 변환
select sysdate, -- yy/mm/dd
       to_char(sysdate, 'yy-mm-dd'),  
       to_char(sysdate,'dd-mm-yy'),
       to_char(sysdate,'fmdd-mm-yy'),
       to_CHAR(sysdate, 'yyyy-mm-fmdd'),
       TO_CHAR(SYSDATE, 'YYYY-MM-DD HH:MI:SS.SSSSS'),
       TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS.SSSSS AM'),
       TO_CHAR(SYSDATE, 'YEAR-MONDD HH24:MI:SS.SSSSS AM')
from dual;

-- 21-06-2007에 입사한 직원을 출력
select * from hr.employees
where to_char(hire_date,'dd-mm-yyyy') = '21-06-2007';
-- yy/mm/dd

-- 21-6-2007에 입사한 직원을 출력
select * from hr.employees
where to_char(hire_date,'dd-fmmm-yyyy') = '21-6-2007';

-- 숫자를 문자열로
--1,020,222
--- 1234567 => W1,234,567, $1,234,567, $1,234,567-
SELECT TO_CHAR(1234567.890, '9,999,999'),
        TO_CHAR(1234567.890, '9,999,999.00'),
        TO_CHAR(1234567.890, '$9,999,999.00'),
        TO_CHAR(1234567.890, 'L9,999,999.00'),
        TO_CHAR(-1234567.890, 'L9,999,999.00MI')
FROM DUAL;

--  이름, 성, 직무, 부서 그리고 급여를 세자리씩 ,를 찍고 
--- $가 출력되게 하시오
select first_name, last_name, job_id, department_id,
       to_char(salary, '$99,999,999mi'),
       to_char(-salary, '$99,999,999mi')
from hr.employees;

-- 03/06/17이후에 입사한 사람은
select * from hr.employees
where hire_date > '03/06/17';

-- 17/06/03 ==> 03/06/17 
--- dd-mm-yy ===> yy/mm/dd
select * from hr.employees
where hire_date > to_date('17/06/03','dd/mm/yy'); 

-- 06/17/03 -- mm/dd/yy
select * from hr.employees
where hire_date > to_date('06/17/03', 'mm/dd/yy');
--    yy/mm/dd

-- 06/17/03이전에 입사한 직원을 조회하세요..
select * from hr.employees -- X 
where to_char(hire_date, 'mm/dd/yy') < '06/17/03'; 
--  사전 순서 

select * from hr.employees
where hire_date < to_date('06/17/03','mm/dd/yy');
-- 날짜 순서

----------------------------------------
-- 성, 급여, 연봉을 출력
-- 연봉을 계산 할 때 월 커미션도 포함
select last_name, salary,
   salary * (  1 + nvl(commission_pct,0)) * 12 year_sal
from hr.employees;

select last_name, salary , commission_pct,
      nvl2(commission_pct , 'null이 아님', 'null 임')
from hr.employees;

-- nvl2를 이용해서 커미션을 포함한 연봉을 구하시오.
-- last_name, salary, 연봉
select last_name, salary,
       salary * ( 1 + 
       nvl2(commission_pct, commission_pct, 0))
from hr.employees;

--- nullif
SELECT first_name, LENGTH(first_name) expr1, 
       last_name, LENGTH(last_name) expr2, 
       NULLIF(LENGTH(first_name), LENGTH(last_name)) result 
FROM hr.employees; 

--- COALESCE
SELECT last_name, employee_id, manager_id,commission_pct,
COALESCE(TO_CHAR(commission_pct),
         TO_CHAR(manager_id), 
        'No commission and no manager') aa
FROM hr.employees; 
-- null관련 함수 -- 일반함수
-- NVL *****
-- NVL2 
-- NULLIF 
-- COALESCE

-- 조건부 표현식: switch ~ case
-- CASE
-- DECODE
-- 급여에 따른 세금을 출력하고 싶다. 
-- 이름 , 성, 급여, 직무, 세금을 출력하시오.
---  급여를 2000으로 나눈 몫이 0이면 급여의 0%
---                         1이면 급여의 9%
---                         2이면 급여의 20%
---                         3이면 급여의 30%
---                         4이면 급여의 40%
---                         5이면 급여의 42%
---                         6이면 급여의 44%
---                         이외 급여의 45% 세금이다
-- trunc(salary / 2000)
select first_name, last_name, salary, 
   case trunc(salary / 2000) when  0 then salary * 0.00
                             when  1 then salary * 0.09 
                             when  2 then salary * 0.10
                             when  3 then salary * 0.20
                             when  4 then salary * 0.40
                             when  5 then salary * 0.42
                             when  6 then salary * 0.44
                             else salary * 0.45 end tex
from hr.employees;
select first_name, last_name, salary, 
   case  when trunc(salary / 2000) = 0 then salary * 0.00
         when trunc(salary / 2000) = 1 then salary * 0.09 
         when trunc(salary / 2000) = 2 then salary * 0.10
         when trunc(salary / 2000) = 3 then salary * 0.20
         when trunc(salary / 2000) = 4 then salary * 0.40
         when trunc(salary / 2000) = 5 then salary * 0.42
         when trunc(salary / 2000) = 6 then salary * 0.44
         else salary * 0.45 end tex
from hr.employees;


select first_name, last_name, salary,
       case when salary < 2000 then salary * 0.00
            when salary < 4000 then salary * 0.09
            when salary < 6000 then salary * 0.20
            when salary < 8000 then salary * 0.30
            when salary < 10000 then salary * 0.40
            when salary < 12000 then salary * 0.42
            when salary < 14000 then salary * 0.44
            else salary * 0.45 end tex
from hr.employees;
-- 성, 이름, 직무, 급여, 급여에 따른 직책도 같이 출력하세요.
--- 급여가 3000이하이면 사원 
--        5000이하이면 주임
--        7000이하이면 대리
--        9000이하이면 과장
--       11000이하이면 차장
--       13000이하이면 부장
--       그 이상 이면 임원
select last_name, first_name, job_id, salary,
      CASE WHEN salary <= 3000 then '사원'
           when salary <= 5000 then '주임'
           when salary <= 7000 then '대리'
           when salary <= 9000 then '과장'
           when salary <= 11000 then '차장'
           when salary <= 13000 then '부장'
           else '임원' END grade
from hr.employees
order by salary;


select first_name, last_name, salary, 
   decode (trunc(salary / 2000) ,  0 , salary * 0.00
                                ,  1 , salary * 0.09 
                                ,  2 , salary * 0.10
                                ,  3 , salary * 0.20
                                ,  4 , salary * 0.40
                                ,  5 , salary * 0.42
                                ,  6 , salary * 0.44
                                , salary * 0.45 ) tex
from hr.employees;

SELECT last_name, job_id, salary,
CASE job_id WHEN 'IT_PROG' THEN 1.10*salary
            WHEN 'ST_CLERK' THEN 1.15*salary
            WHEN 'SA_REP' THEN 1.20*salary
            ELSE salary END "REVISED_SALARY"
FROM hr.employees;

--- decode로 
SELECT last_name, job_id, salary,
decode ( job_id , 'IT_PROG' , 1.10*salary
                , 'ST_CLERK' , 1.15*salary
                , 'SA_REP' , 1.20*salary
                , salary ) "REVISED_SALARY"
FROM hr.employees;

--- 회사의 전체 평균 급여, 급여의 합계, 최대 급여, 최소 급여, 
--- 급여받는 사원의 수
select  avg(salary) , sum(salary), max(salary), min(salary),
      count(salary)
from hr.employees;

select salary from hr.employees;

--- 직무에 REP를 가지고 있는 사원의 급여의 합계 , 평균급여, 
--- 급여를 받는 사원의 수를 구하시오

select sum(salary), avg(salary), count(salary),
       sum(salary) / count(salary)  
from hr.employees
where job_id like '%REP%';

-- 입사일이 제일 빠른 날과 제일 늦은 날을 출력하세요.
select min(hire_date), max(hire_date)
from hr.employees;

--- 80부서에 제일 먼저 들어온 사원의 입사일과 
--  제일 늦게 들어온 사원의 입사일을 출력하세요.
select min(hire_date), max(hire_date)
from hr.employees
where department_id = 80;

-- count는 null이 아닌 행 수를 반환합니다
select count(employee_id), count(first_name),
      count(salary), count(commission_pct),
      count(department_id), count(*)
from hr.employees;
--- count(*)는 행의 전체

select avg(salary), 
       sum(salary) / count(*),
       sum(salary) / count(department_id)
from hr.employees;

-- 부서가 있는 사원의 수
select count(department_id)
from hr.employees;
--- 직원 속해 있는 부서의 수는
select count(distinct department_id)
from hr.employees;


--- 전 사원의 커미션의 평균을 구하시오.
select avg(commission_pct),
       sum(commission_pct) / count(*),
       avg(nvl(commission_pct, 0))
from hr.employees;

--- 전 사원
select sum(salary), avg(salary), min(salary), max(salary)
from hr.employees;

-- 80부서의 
select sum(salary), avg(salary), min(salary), max(salary)
from hr.employees
where department_id = 80;

-- 각 부서별
select sum(salary), avg(salary), min(salary), max(salary),
       department_id
from hr.employees
group by department_id;

-- 각 직무별 급여의 평균, 합계, 최소, 최대를 구하시오.
select job_id, sum(salary), avg(salary), min(salary), max(salary)
from hr.employees
group by job_id;

-- 입사일이 같은 사원 급여의 평균, 합계, 최소, 최대를 구하시오.
select hire_date, sum(salary), avg(salary), min(salary), max(salary)
from hr.employees
group by hire_date;


-- 직무에 REP를 가지고 있는 사원의 급여의 합계 , 평균급여,최소, 최대 
-- 각 부서별 평균을 구하시오.
select department_id, sum(salary), avg(salary), 
        min(salary), max(salary)
from hr.employees 
where job_id like '%REP%'
group by department_id;

--  각 부서의 평균 급여 중 가장 많이 받는 부서의 평균 급여는
select max(avg(salary))
from hr.employees
group by department_id;


select department_id, hire_date, first_name, salary
from hr.employees
order by department_id, hire_date;


---  각 부서별 직무의 급여의 평균 , 합계, 최대, 최소, 직원수
--  부서를 오름차순으로 정렬
select department_id,job_id, sum(salary), avg(salary), 
        min(salary), max(salary), count(*)
from hr.employees
group by department_id, job_id
order by department_id;

--각부서에서 직무가 같은 사원들 중 입사일이 같은 사원의 수를 구하시오.
-- count(*) : 그룹이 된 행의 갯수
select department_id,job_id,hire_date,sum(salary), avg(salary), 
        min(salary), max(salary), count(*)
from hr.employees
group by department_id, job_id, hire_date;

--- 직무가 'REP'를 가진 각 부서의 평균이 8000이상인 부서의 
-- 평균 급여, 합계 , 최소 , 최대를 구하시오.
select department_id, avg(salary), sum(salary), max(salary),
       min(salary), count(*)--- 5
from hr.employees --- 1
where job_id like '%REP%'       --- 2
group by department_id --- 3
having avg(salary) >= 8000 -- 4
order by department_id; -- 6;
-- group by절에 대한 조건을 주기 위해 having절을 사용


-- 각부서에서 직무가 같은 사원들 중 입사일이 같은 사원의 수를 구하시오.
-- 사원수가 2명이상만 출력
select department_id, avg(salary), sum(salary), max(salary),
       min(salary), count(*)--- 5
from hr.employees 
group by department_id, job_id, hire_date
having count(*) >= 2;

-- 부서의 직원 수가 10명 미만이 부서를 출력하시오.
select department_id , count(*)
from hr.employees
group by department_id
having count(*) < 10;

SELECT job_id, SUM(salary) PAYROLL
FROM employees
WHERE job_id NOT LIKE '%REP%'
GROUP BY job_id
HAVING SUM(salary) > 13000
ORDER BY PAYROLL;

select * from hr.employees
order by employee_id;

-- 다음 사원 번호를 출력하세요.(*****)
select max(employee_id) + 1 from hr.employees;

