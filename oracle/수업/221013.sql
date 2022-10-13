--īƼ�þ� ��
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

--- 90�� �μ��� ��� �޿�
select trunc(avg(salary),-3)
from hr.employees
where department_id = 90;

select * from hr.employees
where salary > (select trunc(avg(salary),-3)
from hr.employees
where department_id = 90);

--  Rogers������� ���� �Ի��� ����� ���Ͻÿ�?
select hire_date from hr.employees
where last_name = 'Rogers';

select * from hr.employees
where hire_date < (select hire_date from hr.employees
                   where last_name = 'Rogers');

-- Rogers�� ������ ���� Rogers�� �޿����� ���� �޴� ����� ���Ͻÿ�.
select job_id from hr.employees
where last_name = 'Rogers'; --- ST_CLERK

select salary from hr.employees
where last_name = 'Rogers'; --- 2900

select * from hr.employees
where job_id = (select job_id from hr.employees
                where last_name = 'Rogers')
AND SALARY > (select salary from hr.employees
             where last_name = 'Rogers');

--- �޿��� ���� ���� �޴� ������ ����ϼ���.
SELECT min(salary)
from hr.employees;

select * from hr.employees
where salary = (SELECT min(salary)
from hr.employees);

-- �����ȣ, �̸� , ���� , �޿�, Rogers�� �Ի��ϵ� ���� ����ϼ���,
select hire_date from hr.employees
where last_name = 'Rogers';
select employee_id, first_name, job_id, salary, 
        (select hire_date from hr.employees
        where last_name = 'Rogers') Rogers_hire_date
from hr.employees;

-- �� �μ��� �ּұ޿��� 50�� �μ��� �ּ� �޿����� ū 
-- �μ��� �ּұݾ��� ����ϼ���.
select min(salary)
from hr.employees
where department_id = 50;

select department_id , min(salary)
from hr.employees
group by department_id
having min(salary) > (select min(salary)
                      from hr.employees
                      where department_id = 50);

-- ������ ��������
--- Taylor����� ���� ������ ���� ������ �ϰ� �ִ� ������� ���
select job_id from hr.employees
where last_name = 'Taylor';
-- 'SA_REP'�Ǵ� 'SH_CLERK'�� �ϴ� ������� ���Ͻÿ�.
select * from hr.employees
where job_id = 'SA_REP' or job_id = 'SH_CLERK';

select * from hr.employees
where job_id in ('SA_REP', 'SH_CLERK');

select * from hr.employees
where job_id  in  (select job_id from hr.employees
                where last_name = 'Taylor');

--- Rogers�� ���� ������ �ϴ� ������� ���ϰԿ�.
select * from hr.employees
where job_id in (select job_id from hr.employees 
                where last_name = 'Rogers');
                
-- Haas����� �ϴ� ������ ���� ������ �ϴ� �������� ���ϼ���.

-- �� �μ��� �ּ� �޿��� �޴� ������� ���Ͻÿ�.
select min(salary) from hr.employees
group by department_id;

select * from hr.employees
where salary in (select min(salary) from hr.employees
group by department_id);


---4200, 4800, 6000, 9000�� �ּҺ��� ū �޿��� �޴� ����� ���Ͻÿ�.
select * from hr.employees
where salary > any (4200, 4800, 6000, 9000);
-- 60�� �μ� �ּ� �޿����� �� ���� �޴� �������� ���Ͻÿ�.
select * from hr.employees
where salary > (select min(salary) from hr.employees
                where department_id = 60); -- ������
select * from hr.employees
where salary > any (select salary from hr.employees
                where department_id = 60); -- ������

-- ������ 'IT_PROG'�� ����� �� �޿��� ���� ���� �޴� ������� �۰�
-- �޴� ������� ���Ͻÿ�.
select Max(salary) from hr.employees
where job_id = 'IT_PROG';

select * from hr.employees
where salary < (select Max(salary) from hr.employees
where job_id = 'IT_PROG');

-- ���� �� ������ 
select * from hr.employees
where salary < any (select salary from hr.employees        
                    where job_id = 'IT_PROG');
-- in , any, all
-- ������ IT_PROG�� ������� �޿��� ���� ���� �޴� �޿����� �� ���� 
-- �޴� ����� ���Ͻÿ�.
select MAX(salary) from hr.employees
where job_id = 'IT_PROG';

select * from hr.employees
where salary > 9000;

select * from hr.employees
where salary > all (select salary from hr.employees
                where job_id = 'IT_PROG') ;

-- ������ IT_PROG�� ������� �޿��� ���� �۰� �޴� �޿����� �� �۰� 
-- �޴� ����� ���Ͻÿ�.
select MIN(salary) from hr.employees
where job_id = 'IT_PROG';

select * from hr.employees
where salary < (select MIN(salary) from hr.employees
                where job_id = 'IT_PROG');

select * from hr.employees
where salary < all (select salary from hr.employees
                where job_id = 'IT_PROG');
                
-- ���� ���� ����� �ϴ� ������ �����ϱ�?
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

-- ������ ������ ���
-- ������ IT_PROG����  ���� ���� �޴� �޿����� �� ���� �޴� ����� 
-- ���ϴµ� IT_PROG�� �����ؼ� ����Ͻÿ�.
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

-- 90�� �μ��� �޿��� ���� �޿��� �޴� ������� ���Ͻÿ�.
SELECT * FROM HR.EMPLOYEES
WHERE SALARY IN (SELECT salary from hr.employees
                 where department_id = 90);
-- 90�� �μ��� �޿��� ���� ���� ������� ���Ͻÿ�.
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

-- INTERSECT : ������
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

DEPARTMENT_ID   NOT NULL NUMBER(4)    
DEPARTMENT_NAME NOT NULL VARCHAR2(30) 
MANAGER_ID               NUMBER(6)    
LOCATION_ID              NUMBER(4);
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

--- ������ ��� ��ȣ�� ������ ���� ������ ���ÿ�.
select max(employee_id) +1 from employees;
