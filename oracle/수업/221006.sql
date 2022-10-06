-- projection : 원하는 열을 출력, 데이터 가공한 출력
-- selection : 원하는 행을 출력, where
select job_id from hr.employees;

--- 사원들 정보 중 사원번호, 이름 , 급여, 직무를 출력하는 데
--- 직무가 'FI_ACCOUNT'인 사원들만 출력하세요.
select employee_id, first_name, salary, job_id
from hr.employees
where job_id = 'FI_ACCOUNT';

-- 직무에 '_A'가 있는 사원들을 출력하시오.
select * from hr.employees
where job_id like '%\_A%'  ESCAPE '\';

-- projection : 원하는 열을 선택 : select
-- selection : 원하는 행을 선택  : where : if
--                              비교, 논리 연산자
--                            Like     not
-- AC_ACCOUNT, AD_PRES, PR_REP이 직무가 아닌 
-- 사원들을 출력하세요.
select * from hr.employees
where job_id NOT in ('AC_ACCOUNT', 'AD_PRES', 'PR_REP');

-- 부서가 없는 직원을 출력
select * from hr.employees
where department_id is null;

-- 부서가 있는 직원을 출력
select * from hr.employees
where department_id is not null;

--- 이름이 Douglas과 Susan 사이에 있는 직원을 출력하는데 
-- 직무가 'K_'를 포함하는 직원만 출력하세요.
select * from hr.employees
where first_name between 'Douglas' and 'Susan'  
  and job_id like '%K\_%' ESCAPE '\';

select * from hr.employees
where first_name >= 'Douglas' and first_name <= 'Susan'  
  and job_id like '%K\_%' ESCAPE '\';


select * from hr.employees;

select lower('SQL Course')
from dual;
select upper('SQL Course')
from dual;
select INITCAP('sQL course')
from dual;

select last_name , lower(last_name)
       ,first_name , upper(first_name)
       ,job_id , initcap(job_id)
from hr.employees;

--- 성이 higgins직원의 정보를 출력하세요.
select * 
from hr.employees
where last_name = initcap('higgins');

select * 
from hr.employees
where lower(last_name) = 'higgins';

-- 성이 KING인 직원을 출력하세요
select * from hr.employees
where upper(last_name) = 'KING';

select * from hr.employees
where  last_name = initcap('KING');

select CONCAT('Hello', 'World')
from dual;

---모든 사원을 성과 이름은 붙여서 출력하고
-- 입사일과 직무를 출력하세요.
-- OConnellDonald, 07/06/21, SH_CLERK
select last_name || first_name , hire_date, job_id
from hr.employees;

select concat(last_name, first_name) , hire_date, job_id
from hr.employees;

-- OConnell Donald, 07/06/21, SH_CLERK
-- concat(인수1, 인수2)
select concat(last_name,  concat(' ' , first_name)) 
      , hire_date, job_id
from hr.employees;

select last_name || ' ' || first_name
     , hire_date, job_id
from hr.employees;

--- substr
select SUBSTR('HelloWorld',1,5) from dual;
select SUBSTR('HelloWorld',-3,1) from dual;
select SUBSTR('HelloWorld',-3,2) from dual;
select SUBSTR('HelloWorld',-3,3) from dual;
select SUBSTR('HelloWorld',-5,3) from dual;
-- 부서정보에서 부서번호 , 부서명, 부서장을 출력하는데
-- 부서명을 2번째 부터 5글짜만 출력하시오.
select department_id, substr(department_name,2, 5)
     , manager_id
from hr.departments;

--INSTR : indexOf('abcdefg', 'c')
select INSTR('HelloWorld', 'W')
from dual;

select INSTR('HelloWorld', 'a') -- 0 
from dual;

select INSTR('HelloWorld', 'o') -- 5 
from dual;

select INSTR('HelloWorld', 'o', 6) -- 7 
from dual;

select INSTR('HelloWorld', 'o', -1) -- 7 
from dual;

---사원정보 중에 사원번호 , 이름, 이메일, 이메일에서 'S'가 있는 
-- 위치도 출력
select employee_id, first_name, email, instr(email,'S')
from hr.employees;

-- substr과 instr을 같이 사용
-- 사원번호, 이름, 급여, 이메일, 이메일에서 'S'있는 위치 부터 
-- 5글자를 출력하시오.
-- 단, 'S'가 없는 경우 첫글자 부터 5글자
select employee_id, first_name, salary, email
     , substr(email, instr(email,'S') , 5)
from hr.employees;

--- LENGTH
select LENGTH('HelloWorld')
from dual;

select last_name, LENGTH(last_name) 
       ,first_name , LENGTH(first_name)
       ,email, length(email)
from hr.employees;

--- 이름의 길이가 6개 이상인 직원만 출력하시오.
select * from hr.employees
where length(first_name) >= 6;

-- lpad,  rpad
select LPAD('Hello',10,'*')
from dual;
select RPAD('Hello',10,'*')
from dual;


select rpad(first_name, 15, '*')
      ,lpad(salary, 10, '*')
from hr.employees;

--- rpad, substr, instr, length
--  010-7146-1970 , 010-****-1970, 
--  02-314-1970 02-***-1970
select rpad(
    substr('02-123-1970', 1 , instr('02-123-1970','-'))-- 02-
    ,
    length(
    substr('02-123-1970', 1 , instr('02-123-1970','-',-1)-1)
    ), -- 02-123의 길이 6
    '*')
    || substr('02-123-1970', -5, 5)
from dual;

-- 이메일에서 앞에서 2글자를 출력하고 
-- 나머지는 오른쪽에 *로 채워서 출력하세요.
select employee_id, first_name, email
      , rpad(substr(email,1,2), length(email), '*' )
from hr.employees;

-- REPLACE
select REPLACE('JACK and JUE','J','BL')
from dual;

-- 직무가 _AS가 있다면 abc로 변경하시오,
-- 사원번호 , 이름, 직무, 변경된 직무
select employee_id, first_name, job_id
    , replace(job_id, '_AS','abc')
from hr.employees
where job_id like '%\_AS%' ESCAPE '\';

select '  hello world ', trim('  hello world ')
      ,rtrim('  hello world '),ltrim('  hello world ')
from dual;
select '\hello world\', trim('\hello world\')
      ,rtrim('  hello world '),ltrim('  hello world ')
from dual;

--- 이름이 '   Donald   '의 사원 정보를 출력하시오.
select * from hr.employees
where first_name = trim('   Donald   ');


--- round() : 반올림 
select round(15.19345, 3), round(15.19355, 3)
      , round(145.5554,2), round(145.5554,1)
      , round(145.5554,0), round(145.5554,-1)
      , round(145.5554,-2)
from dual;
--- trunc() : 절삭
select trunc(15.19345, 3), trunc(15.19355, 3)
      , trunc(145.5554,2), trunc(145.5554,1)
      , trunc(145.5554,0), trunc(145.5554,-1)
      , trunc(145.5554,-2)
from dual;

--- mod() : 나머지
select mod(10, 3)
from dual;

--- 사원정보를 출력할 때 이름 , 급여, 급여를 5000으로 나눈 나머지를 출력
--- 직무가 SA_REP인 사원
select first_name, salary, mod(salary, 5000)
from hr.employees;

--- sysdate
select sysdate --- 현재 날짜 출력
from dual;

--- 사원번호 , 이름, 급여, 입사일, 입사이로부터 몇일 지났는지 출력
select employee_id, first_name, salary, hire_date
     ,  trunc(sysdate - hire_date,0)
     , trunc((sysdate - hire_date) / 365, 0)
     , trunc(mod((sysdate - hire_date) , 365), 0)
from hr.employees;

--- 이름 급여, 입사일, 입사한 날로부터 몇주가 되었는 지 출력
select first_name, salary , hire_date
      ,trunc((sysdate - hire_date) / 7) week
from hr.employees;

-- 급여를 500으로 나눈 나머지가 400 이상인 사원들을 출력하시오.
--  employee_id, first_name, hire_date, job_id, salary
select  employee_id, first_name, hire_date, job_id, salary
from hr.employees
where mod(salary , 500) >= 400;

---  오늘 날짜부터 다음 금요일은 몇일입니까?
select next_day(sysdate,'금'), next_day(sysdate,'금요일')
from dual;
-- 입사한 다음 월요일은 몇일 일까요?
-- 이름 , 성, 직무, 입사일
select first_name, last_name, job_id, hire_date
      , next_day(hire_date,'월')
from hr.employees;

---현재 날짜로부터 5개월 후
select add_months(sysdate, 5)
from dual;

-- Neena가 입사하고 3개월 후가 정직원이 되는 날이다.
-- 이름 , 성 , 입사일, 직무, 사원번호도 같이 출력
select first_name, last_name, job_id, employee_id
      , hire_date, add_months(hire_date, 3)
from hr.employees
where first_name = 'Neena' or last_name='Neena';

-- 입사한 이후 다음 목요일이 '01/01/18'인사원을 구하시오.
select * from hr.employees
where next_day(hire_date,'목') = '01/01/18';

-- 마지막 날짜
select last_day(sysdate)
from dual;

--- 마지막 날이 29일인 사원들을 출력하세요.
-- 성, 입사일, 마지막날 출력
select last_name, hire_date , last_day(hire_date)
from hr.employees
where last_day(hire_date) like '%/02/29';

-- 입사일로부터 몇년이 되었는지, 몇일이 되었는지, 몇주가 되었는지
-- employee_id, job_id, hire_date
select employee_id, job_id, hire_date
    , trunc((sysdate - hire_date) / 365) year
    , trunc(sysdate - hire_date) day
    , trunc((sysdate - hire_date) / 7) weeks
    , trunc(months_between(sysdate , hire_date)) months
from hr.employees;

-- 입사한지 230개월이 지난 사원들을 출력하시오
select * from hr.employees
where months_between(sysdate, hire_date) >= 230;
