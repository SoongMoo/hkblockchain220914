-- projection : ���ϴ� ���� ���, ������ ������ ���
-- selection : ���ϴ� ���� ���, where
select job_id from hr.employees;

--- ����� ���� �� �����ȣ, �̸� , �޿�, ������ ����ϴ� ��
--- ������ 'FI_ACCOUNT'�� ����鸸 ����ϼ���.
select employee_id, first_name, salary, job_id
from hr.employees
where job_id = 'FI_ACCOUNT';

-- ������ '_A'�� �ִ� ������� ����Ͻÿ�.
select * from hr.employees
where job_id like '%\_A%'  ESCAPE '\';

-- projection : ���ϴ� ���� ���� : select
-- selection : ���ϴ� ���� ����  : where : if
--                              ��, �� ������
--                            Like     not
-- AC_ACCOUNT, AD_PRES, PR_REP�� ������ �ƴ� 
-- ������� ����ϼ���.
select * from hr.employees
where job_id NOT in ('AC_ACCOUNT', 'AD_PRES', 'PR_REP');

-- �μ��� ���� ������ ���
select * from hr.employees
where department_id is null;

-- �μ��� �ִ� ������ ���
select * from hr.employees
where department_id is not null;

--- �̸��� Douglas�� Susan ���̿� �ִ� ������ ����ϴµ� 
-- ������ 'K_'�� �����ϴ� ������ ����ϼ���.
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

--- ���� higgins������ ������ ����ϼ���.
select * 
from hr.employees
where last_name = initcap('higgins');

select * 
from hr.employees
where lower(last_name) = 'higgins';

-- ���� KING�� ������ ����ϼ���
select * from hr.employees
where upper(last_name) = 'KING';

select * from hr.employees
where  last_name = initcap('KING');

select CONCAT('Hello', 'World')
from dual;

---��� ����� ���� �̸��� �ٿ��� ����ϰ�
-- �Ի��ϰ� ������ ����ϼ���.
-- OConnellDonald, 07/06/21, SH_CLERK
select last_name || first_name , hire_date, job_id
from hr.employees;

select concat(last_name, first_name) , hire_date, job_id
from hr.employees;

-- OConnell Donald, 07/06/21, SH_CLERK
-- concat(�μ�1, �μ�2)
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
-- �μ��������� �μ���ȣ , �μ���, �μ����� ����ϴµ�
-- �μ����� 2��° ���� 5��¥�� ����Ͻÿ�.
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

---������� �߿� �����ȣ , �̸�, �̸���, �̸��Ͽ��� 'S'�� �ִ� 
-- ��ġ�� ���
select employee_id, first_name, email, instr(email,'S')
from hr.employees;

-- substr�� instr�� ���� ���
-- �����ȣ, �̸�, �޿�, �̸���, �̸��Ͽ��� 'S'�ִ� ��ġ ���� 
-- 5���ڸ� ����Ͻÿ�.
-- ��, 'S'�� ���� ��� ù���� ���� 5����
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

--- �̸��� ���̰� 6�� �̻��� ������ ����Ͻÿ�.
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
    ), -- 02-123�� ���� 6
    '*')
    || substr('02-123-1970', -5, 5)
from dual;

-- �̸��Ͽ��� �տ��� 2���ڸ� ����ϰ� 
-- �������� �����ʿ� *�� ä���� ����ϼ���.
select employee_id, first_name, email
      , rpad(substr(email,1,2), length(email), '*' )
from hr.employees;

-- REPLACE
select REPLACE('JACK and JUE','J','BL')
from dual;

-- ������ _AS�� �ִٸ� abc�� �����Ͻÿ�,
-- �����ȣ , �̸�, ����, ����� ����
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

--- �̸��� '   Donald   '�� ��� ������ ����Ͻÿ�.
select * from hr.employees
where first_name = trim('   Donald   ');


--- round() : �ݿø� 
select round(15.19345, 3), round(15.19355, 3)
      , round(145.5554,2), round(145.5554,1)
      , round(145.5554,0), round(145.5554,-1)
      , round(145.5554,-2)
from dual;
--- trunc() : ����
select trunc(15.19345, 3), trunc(15.19355, 3)
      , trunc(145.5554,2), trunc(145.5554,1)
      , trunc(145.5554,0), trunc(145.5554,-1)
      , trunc(145.5554,-2)
from dual;

--- mod() : ������
select mod(10, 3)
from dual;

--- ��������� ����� �� �̸� , �޿�, �޿��� 5000���� ���� �������� ���
--- ������ SA_REP�� ���
select first_name, salary, mod(salary, 5000)
from hr.employees;

--- sysdate
select sysdate --- ���� ��¥ ���
from dual;

--- �����ȣ , �̸�, �޿�, �Ի���, �Ի��̷κ��� ���� �������� ���
select employee_id, first_name, salary, hire_date
     ,  trunc(sysdate - hire_date,0)
     , trunc((sysdate - hire_date) / 365, 0)
     , trunc(mod((sysdate - hire_date) , 365), 0)
from hr.employees;

--- �̸� �޿�, �Ի���, �Ի��� ���κ��� ���ְ� �Ǿ��� �� ���
select first_name, salary , hire_date
      ,trunc((sysdate - hire_date) / 7) week
from hr.employees;

-- �޿��� 500���� ���� �������� 400 �̻��� ������� ����Ͻÿ�.
--  employee_id, first_name, hire_date, job_id, salary
select  employee_id, first_name, hire_date, job_id, salary
from hr.employees
where mod(salary , 500) >= 400;

---  ���� ��¥���� ���� �ݿ����� �����Դϱ�?
select next_day(sysdate,'��'), next_day(sysdate,'�ݿ���')
from dual;
-- �Ի��� ���� �������� ���� �ϱ��?
-- �̸� , ��, ����, �Ի���
select first_name, last_name, job_id, hire_date
      , next_day(hire_date,'��')
from hr.employees;

---���� ��¥�κ��� 5���� ��
select add_months(sysdate, 5)
from dual;

-- Neena�� �Ի��ϰ� 3���� �İ� �������� �Ǵ� ���̴�.
-- �̸� , �� , �Ի���, ����, �����ȣ�� ���� ���
select first_name, last_name, job_id, employee_id
      , hire_date, add_months(hire_date, 3)
from hr.employees
where first_name = 'Neena' or last_name='Neena';

-- �Ի��� ���� ���� ������� '01/01/18'�λ���� ���Ͻÿ�.
select * from hr.employees
where next_day(hire_date,'��') = '01/01/18';

-- ������ ��¥
select last_day(sysdate)
from dual;

--- ������ ���� 29���� ������� ����ϼ���.
-- ��, �Ի���, �������� ���
select last_name, hire_date , last_day(hire_date)
from hr.employees
where last_day(hire_date) like '%/02/29';

-- �Ի��Ϸκ��� ����� �Ǿ�����, ������ �Ǿ�����, ���ְ� �Ǿ�����
-- employee_id, job_id, hire_date
select employee_id, job_id, hire_date
    , trunc((sysdate - hire_date) / 365) year
    , trunc(sysdate - hire_date) day
    , trunc((sysdate - hire_date) / 7) weeks
    , trunc(months_between(sysdate , hire_date)) months
from hr.employees;

-- �Ի����� 230������ ���� ������� ����Ͻÿ�
select * from hr.employees
where months_between(sysdate, hire_date) >= 230;
