--select
--projection : ���ϴ� ���� �������� : �÷� , �����(�������)
--select 10 * 5
--from ���̺� 
--selection :  ���ϴ� ���� �������� : where
--             �ʿ��� ���� : ������, �񱳿���
-- select
-- from 
-- where
-- �����͸� ������ �ؼ� ������ �� : �Լ�
-- ���ڿ� �Լ� :  �빮��, �ҹ���, �����Լ�, �߶󳻱�, ������ ����
--              ��ü , ������ ����, lpad, rpad 
-- ���� �Լ� : round, trunc, mod
-- ��¥ �Լ� : LAST_DAY, NEXT_DAY
-- 
-- ��ȯ �Լ�: *****

select '10' + '10'
from dual;

--- ���� ��ȯ�Լ� : ��¥�� ���� ��ȯ
select sysdate, -- yy/mm/dd
       to_char(sysdate, 'yy-mm-dd'),  
       to_char(sysdate,'dd-mm-yy'),
       to_char(sysdate,'fmdd-mm-yy'),
       to_CHAR(sysdate, 'yyyy-mm-fmdd'),
       TO_CHAR(SYSDATE, 'YYYY-MM-DD HH:MI:SS.SSSSS'),
       TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS.SSSSS AM'),
       TO_CHAR(SYSDATE, 'YEAR-MONDD HH24:MI:SS.SSSSS AM')
from dual;

-- 21-06-2007�� �Ի��� ������ ���
select * from hr.employees
where to_char(hire_date,'dd-mm-yyyy') = '21-06-2007';
-- yy/mm/dd

-- 21-6-2007�� �Ի��� ������ ���
select * from hr.employees
where to_char(hire_date,'dd-fmmm-yyyy') = '21-6-2007';

-- ���ڸ� ���ڿ���
--1,020,222
--- 1234567 => W1,234,567, $1,234,567, $1,234,567-
SELECT TO_CHAR(1234567.890, '9,999,999'),
        TO_CHAR(1234567.890, '9,999,999.00'),
        TO_CHAR(1234567.890, '$9,999,999.00'),
        TO_CHAR(1234567.890, 'L9,999,999.00'),
        TO_CHAR(-1234567.890, 'L9,999,999.00MI')
FROM DUAL;

--  �̸�, ��, ����, �μ� �׸��� �޿��� ���ڸ��� ,�� ��� 
--- $�� ��µǰ� �Ͻÿ�
select first_name, last_name, job_id, department_id,
       to_char(salary, '$99,999,999mi'),
       to_char(-salary, '$99,999,999mi')
from hr.employees;

-- 03/06/17���Ŀ� �Ի��� �����
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

-- 06/17/03������ �Ի��� ������ ��ȸ�ϼ���..
select * from hr.employees -- X 
where to_char(hire_date, 'mm/dd/yy') < '06/17/03'; 
--  ���� ���� 

select * from hr.employees
where hire_date < to_date('06/17/03','mm/dd/yy');
-- ��¥ ����

----------------------------------------
-- ��, �޿�, ������ ���
-- ������ ��� �� �� �� Ŀ�̼ǵ� ����
select last_name, salary,
   salary * (  1 + nvl(commission_pct,0)) * 12 year_sal
from hr.employees;

select last_name, salary , commission_pct,
      nvl2(commission_pct , 'null�� �ƴ�', 'null ��')
from hr.employees;

-- nvl2�� �̿��ؼ� Ŀ�̼��� ������ ������ ���Ͻÿ�.
-- last_name, salary, ����
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
-- null���� �Լ� -- �Ϲ��Լ�
-- NVL *****
-- NVL2 
-- NULLIF 
-- COALESCE

-- ���Ǻ� ǥ����: switch ~ case
-- CASE
-- DECODE
-- �޿��� ���� ������ ����ϰ� �ʹ�. 
-- �̸� , ��, �޿�, ����, ������ ����Ͻÿ�.
---  �޿��� 2000���� ���� ���� 0�̸� �޿��� 0%
---                         1�̸� �޿��� 9%
---                         2�̸� �޿��� 20%
---                         3�̸� �޿��� 30%
---                         4�̸� �޿��� 40%
---                         5�̸� �޿��� 42%
---                         6�̸� �޿��� 44%
---                         �̿� �޿��� 45% �����̴�
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
-- ��, �̸�, ����, �޿�, �޿��� ���� ��å�� ���� ����ϼ���.
--- �޿��� 3000�����̸� ��� 
--        5000�����̸� ����
--        7000�����̸� �븮
--        9000�����̸� ����
--       11000�����̸� ����
--       13000�����̸� ����
--       �� �̻� �̸� �ӿ�
select last_name, first_name, job_id, salary,
      CASE WHEN salary <= 3000 then '���'
           when salary <= 5000 then '����'
           when salary <= 7000 then '�븮'
           when salary <= 9000 then '����'
           when salary <= 11000 then '����'
           when salary <= 13000 then '����'
           else '�ӿ�' END grade
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

--- decode�� 
SELECT last_name, job_id, salary,
decode ( job_id , 'IT_PROG' , 1.10*salary
                , 'ST_CLERK' , 1.15*salary
                , 'SA_REP' , 1.20*salary
                , salary ) "REVISED_SALARY"
FROM hr.employees;

--- ȸ���� ��ü ��� �޿�, �޿��� �հ�, �ִ� �޿�, �ּ� �޿�, 
--- �޿��޴� ����� ��
select  avg(salary) , sum(salary), max(salary), min(salary),
      count(salary)
from hr.employees;

select salary from hr.employees;

--- ������ REP�� ������ �ִ� ����� �޿��� �հ� , ��ձ޿�, 
--- �޿��� �޴� ����� ���� ���Ͻÿ�

select sum(salary), avg(salary), count(salary),
       sum(salary) / count(salary)  
from hr.employees
where job_id like '%REP%';

-- �Ի����� ���� ���� ���� ���� ���� ���� ����ϼ���.
select min(hire_date), max(hire_date)
from hr.employees;

--- 80�μ��� ���� ���� ���� ����� �Ի��ϰ� 
--  ���� �ʰ� ���� ����� �Ի����� ����ϼ���.
select min(hire_date), max(hire_date)
from hr.employees
where department_id = 80;

-- count�� null�� �ƴ� �� ���� ��ȯ�մϴ�
select count(employee_id), count(first_name),
      count(salary), count(commission_pct),
      count(department_id), count(*)
from hr.employees;
--- count(*)�� ���� ��ü

select avg(salary), 
       sum(salary) / count(*),
       sum(salary) / count(department_id)
from hr.employees;

-- �μ��� �ִ� ����� ��
select count(department_id)
from hr.employees;
--- ���� ���� �ִ� �μ��� ����
select count(distinct department_id)
from hr.employees;


--- �� ����� Ŀ�̼��� ����� ���Ͻÿ�.
select avg(commission_pct),
       sum(commission_pct) / count(*),
       avg(nvl(commission_pct, 0))
from hr.employees;

--- �� ���
select sum(salary), avg(salary), min(salary), max(salary)
from hr.employees;

-- 80�μ��� 
select sum(salary), avg(salary), min(salary), max(salary)
from hr.employees
where department_id = 80;

-- �� �μ���
select sum(salary), avg(salary), min(salary), max(salary),
       department_id
from hr.employees
group by department_id;

-- �� ������ �޿��� ���, �հ�, �ּ�, �ִ븦 ���Ͻÿ�.
select job_id, sum(salary), avg(salary), min(salary), max(salary)
from hr.employees
group by job_id;

-- �Ի����� ���� ��� �޿��� ���, �հ�, �ּ�, �ִ븦 ���Ͻÿ�.
select hire_date, sum(salary), avg(salary), min(salary), max(salary)
from hr.employees
group by hire_date;


-- ������ REP�� ������ �ִ� ����� �޿��� �հ� , ��ձ޿�,�ּ�, �ִ� 
-- �� �μ��� ����� ���Ͻÿ�.
select department_id, sum(salary), avg(salary), 
        min(salary), max(salary)
from hr.employees 
where job_id like '%REP%'
group by department_id;

--  �� �μ��� ��� �޿� �� ���� ���� �޴� �μ��� ��� �޿���
select max(avg(salary))
from hr.employees
group by department_id;


select department_id, hire_date, first_name, salary
from hr.employees
order by department_id, hire_date;


---  �� �μ��� ������ �޿��� ��� , �հ�, �ִ�, �ּ�, ������
--  �μ��� ������������ ����
select department_id,job_id, sum(salary), avg(salary), 
        min(salary), max(salary), count(*)
from hr.employees
group by department_id, job_id
order by department_id;

--���μ����� ������ ���� ����� �� �Ի����� ���� ����� ���� ���Ͻÿ�.
-- count(*) : �׷��� �� ���� ����
select department_id,job_id,hire_date,sum(salary), avg(salary), 
        min(salary), max(salary), count(*)
from hr.employees
group by department_id, job_id, hire_date;

--- ������ 'REP'�� ���� �� �μ��� ����� 8000�̻��� �μ��� 
-- ��� �޿�, �հ� , �ּ� , �ִ븦 ���Ͻÿ�.
select department_id, avg(salary), sum(salary), max(salary),
       min(salary), count(*)--- 5
from hr.employees --- 1
where job_id like '%REP%'       --- 2
group by department_id --- 3
having avg(salary) >= 8000 -- 4
order by department_id; -- 6;
-- group by���� ���� ������ �ֱ� ���� having���� ���


-- ���μ����� ������ ���� ����� �� �Ի����� ���� ����� ���� ���Ͻÿ�.
-- ������� 2���̻� ���
select department_id, avg(salary), sum(salary), max(salary),
       min(salary), count(*)--- 5
from hr.employees 
group by department_id, job_id, hire_date
having count(*) >= 2;

-- �μ��� ���� ���� 10�� �̸��� �μ��� ����Ͻÿ�.
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

-- ���� ��� ��ȣ�� ����ϼ���.(*****)
select max(employee_id) + 1 from hr.employees;

