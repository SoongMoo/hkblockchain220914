--- projection : 
-- select : �÷���, �����(��������)
-- from : ���̺�
-- selection :  where : �񱳿����ڿ� ���迬����
-- select * from hr.employees
-- where job_id like '%REP%'; 
-- ������ : ���� ���� �ϳ��� �̿��ؼ� ����� ������ ��  
--         �Ϲ��Լ� : nvl, nvl2 , nullif, 
--         ���ڿ��Լ� :
--         ��ȯ�Լ� : to_char, to_date

-- ������ �Լ� : �������� �̿��ؼ� �ϳ��� ����� �������
--             sum(), avg(), min(), max(), count()
--             group by, having

-- employees : ������ ���� ����
-- departments : �μ����� ����
-- 20�κμ��� �������� ����ϼ���..
select * from hr.employees
where department_id = 20;
-- 20�� �μ��� �μ����� ����ϼ���..
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

-- 1999 ���� : ansi - join
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

-- ������ �� ������ SH_CLERK�� ������� ����ϼ���.
-- �����ȣ, �̸�, �޿�, �μ���, ������ȣ
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID,
       JOB_ID
FROM HR.EMPLOYEES
WHERE JOB_ID ='SH_CLERK'; 
-- ���� ���̺��� JOBS���� ������ SH_CLERK�� �������� ����ϼ���.
SELECT JOB_TITLE FROM HR.JOBS
WHERE JOB_ID = 'SH_CLERK';
--- T - SQL -Join
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID,
       HR.jobs.JOB_ID, JOB_TITLE
FROM HR.employees , HR.jobs
WHERE HR.employees.JOB_ID = HR.jobs.JOB_ID;
-- 1999���� -- Ansi-Join
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
--- �� ���̺��� �÷����� ���ƾ� �Ѵ�.
--                                             ���
select * from  hr.employees; --department_id,manager_id
--                                               �μ���
select * from hr.departments; --department_id , manager_id
--
select first_name, last_name, hire_date
     , e.department_id, department_name
from hr.employees  join hr.departments d
on e.department_id = d.department_id;


-- ������ �� �μ����� ���� �� �������� �μ����� ����Ͻÿ�.
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
