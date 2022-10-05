select * from hr.employees;

select employee_id, first_name, job_id
from hr.employees;

select employee_id, first_name, job_id, salary * 0.1
from hr.employees;

select *, department_id, location_id, manager_id
from hr.departments;

select first_name name, salary, commission_pct * salary sal
        ,department_id
from hr.employees;

select first_name || q'['s ]' || job_id
from hr.employees;

select first_name || '''s' || job_id
from hr.employees;

--------------------------------------------
select employee_id,first_name, job_id
from hr.employees;

-----직무만 출력
select job_id
from hr.employees;

--- 사원들이 하고 있는 직무는 어떤 것이 있는 출력하시오.
select distinct job_id
from hr.employees;

-- select firat_name, distinct job_id
-- from hr.employees;

--- 직무와 급여가 같은 것은 한번만 출력
select distinct salary , job_id , department_id
from hr.employees;

select * from hr.employees;

desc hr.employees;

select last_name ,first_name, salary, job_id
from hr.employees;

select last_name || ' ' || first_name, salary, job_id ,'사원'
        , '1999-10-14', 10, 10.5
from hr.employees;
--- 리터널 : 자연어 , 자연수 , 부울, 날짜
