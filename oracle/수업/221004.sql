SELECT * FROM HR.departments;

SELECT department_id, department_name, manager_id,
       location_id
FROM HR.departments;

SELECT department_name, location_id
FROM HR.departments;

SELECT location_id, department_name
FROM HR.departments;
-- ���� ������ ���̺� �ִ� ������ �ƴ� ����� ������� ������ �� �ִ�.

SELECT DEPARTMENT_NAME ,'�̼���'
FROM HR.departments;

SELECT FIRST_NAME, 'ȸ���', salary, SALARY * 0.1
       ,SALARY + SALARY * 0.1
FROM HR.EMPLOYEES;


SELECT EMPLOYEE_ID ,SALARY,  SALARY + 300
FROM HR.employees;

---- �� ����� ����� �󿩱� 100 �� ���ؼ� ���
SELECT * FROM HR.employees;
SELECT FIRST_NAME, EMAIL, HIRE_DATE , SALARY , 100 + SALARY * 12 
FROM HR.EMPLOYEES;

---- �޿��� 100�� ���� ����� ���Ͻÿ�
SELECT FIRST_NAME, EMAIL, HIRE_DATE , SALARY , (100 + SALARY) * 12 
FROM HR.EMPLOYEES;

SELECT FIRST_NAME,SALARY, SALARY * NULL,SALARY + NULL 
        , SALARY - NULL
FROM HR.employees;
--- NULL�� �� �� ���� ���̹Ƿ� ��� ���� �൵ �˼� ���� ���� �ȴ�.

SELECT EMPLOYEE_ID, SALARY, commission_pct * 100 
FROM HR.employees;

-- ����� �޿��� Ŀ�̼��� ���� ����� �����ÿ�? 
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
        , '�̼���'
from hr.employees;

select first_name, salary,  commission_pct 
        , (salary + salary * commission_pct) * 12  "Year Sal"
        , '�̼���'
from hr.employees;


select '��' || '����' --- ���� ������ : ���ڿ� ���� �� ���
from dual;

--- ����� ����� �̸�, ��, �׸��� �޿��� ����ϴµ� 
-- ���� �̸��� �ٿ��� ���
select employee_id, last_name, first_name
       , last_name||' '||first_name name
       , salary
from hr.employees;

select '�̼���', '221004'
from dual;

select first_name, salary , department_id, '���', '221004'
from hr.employees;

--- Ellen�� ������ SA_REP�Դϴ�.
select first_name || '�� ������ ' || job_id ||'�Դϴ�.' 
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