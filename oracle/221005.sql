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

-----������ ���
select job_id
from hr.employees;

--- ������� �ϰ� �ִ� ������ � ���� �ִ� ����Ͻÿ�.
select distinct job_id
from hr.employees;

-- select firat_name, distinct job_id
-- from hr.employees;

--- ������ �޿��� ���� ���� �ѹ��� ���
select distinct salary , job_id , department_id
from hr.employees;

select * from hr.employees;

desc hr.employees;

select last_name ,first_name, salary, job_id
from hr.employees;

select last_name || ' ' || first_name, salary, job_id ,'���'
        , '1999-10-14', 10, 10.5
from hr.employees;
--- ���ͳ� : �ڿ��� , �ڿ��� , �ο�, ��¥
