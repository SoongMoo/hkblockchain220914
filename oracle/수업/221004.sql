SELECT * FROM HR.departments;

SELECT department_id, department_name, manager_id,
       location_id
FROM HR.departments;

SELECT department_name, location_id
FROM HR.departments;

SELECT location_id, department_name
FROM HR.departments;
-- 열의 순서는 데이블에 있는 순서가 아닌 사용자 마음대로 나열할 수 있다.

SELECT DEPARTMENT_NAME ,'이숭무'
FROM HR.departments;

SELECT FIRST_NAME, '회사명', salary, SALARY * 0.1
       ,SALARY + SALARY * 0.1
FROM HR.EMPLOYEES;


SELECT EMPLOYEE_ID ,SALARY,  SALARY + 300
FROM HR.employees;

---- 각 사원의 년봉에 상여금 100 을 더해서 출력
SELECT * FROM HR.employees;
SELECT FIRST_NAME, EMAIL, HIRE_DATE , SALARY , 100 + SALARY * 12 
FROM HR.EMPLOYEES;

---- 급여에 100을 더한 년봉을 구하시오
SELECT FIRST_NAME, EMAIL, HIRE_DATE , SALARY , (100 + SALARY) * 12 
FROM HR.EMPLOYEES;

SELECT FIRST_NAME,SALARY, SALARY * NULL,SALARY + NULL 
        , SALARY - NULL
FROM HR.employees;
--- NULL은 알 수 없는 값이므로 어떠한 값을 줘도 알수 없는 값이 된다.

SELECT EMPLOYEE_ID, SALARY, commission_pct * 100 
FROM HR.employees;

-- 사원의 급여에 커미션을 더한 년봉을 구히시오? 
select first_name, salary, commission_pct 
        , (salary + salary * commission_pct) * 12
from hr.employees;

select first_name, salary, commission_pct 
        , (salary + salary * commission_pct) * 12 as year_sal
from hr.employees;

------
select first_name, salary,  commission_pct 
        , (salary + salary * commission_pct) * 12  year_Sal
from hr.employees;
-----

select first_name, salary,  commission_pct 
        , (salary + salary * commission_pct) * 12  "year sal"
        , '이숭무'
from hr.employees;

select first_name, salary,  commission_pct 
        , (salary + salary * commission_pct) * 12  "Year Sal"
        , '이숭무'
from hr.employees;


select '이' || '숭무' --- 연결 연산자 : 문자열 붙일 때 사용
from dual;

--- 사원의 사번과 이름, 성, 그리고 급여를 출력하는데 
-- 성과 이름은 붙여서 출력
select employee_id, last_name, first_name
       , last_name||' '||first_name name
       , salary
from hr.employees;

select '이숭무', '221004'
from dual;

select first_name, salary , department_id, '사원', '221004'
from hr.employees;

--- Ellen의 직업은 SA_REP입니다.
select first_name || '의 직업은 ' || job_id ||'입니다.' 
from hr.employees;

-- Administration deapartment's manager_id: 200
select department_name || ' deapartment''s' || ' manager_id : ' ||
        manager_id  as emp
from hr.departments;


select department_name || ' deapartment' || 
        q'['s  manager_id : ]' ||
        manager_id  as emp
from hr.departments;


desc hr.employees;