drop table d;
drop table c;
drop table b;
drop table a;

create table a( ---������
    a1 number constraint a_a1_pk  PRIMARY key,
    a2 varchar2(20)
);
create table b(
    b1 number,
    b2 varchar2(20),
    a1 number constraint b_a1_FK references a(a1)
              on delete cascade,
    constraint b_a1_b1_PK primary key(a1, b1)
);
create table c(
    c1 number,
    c2 varchar2(20),
    a1 number ,
    b1 number,
    constraint c_a1_b1_c1_PK primary key(a1,b1,c1),
    CONSTRAINT c_a1_b1_FK FOREIGN key(a1,b1)
    REFERENCES b(a1,b1) on delete cascade
);
create table d(
    d1 number constraint d_d1_PK primary key,
    d2 varchar2(20),
    a1 number ,
    b1 number ,
    constraint d_a1_b1_FK FOREIGN key (a1, b1)
    REFERENCES b(a1, b1) on DELETE set null
);

create table CHECKEXAM(
  city varchar2(20) 
   constraint ch_city_CK check ( 
            city in ('����' , '�λ�' ,'�뱸', '����' ))
);
insert into CHECKEXAM
values('��õ');
-- üũ ��������(SMRIT.CH_CITY_CK)�� ����Ǿ����ϴ�
insert into CHECKEXAM
values('����');
select * from CHECKEXAM;

drop table CHECKEXAM1;
create table CHECKEXAM1(
    eid number check (eid > 0),
    value1 number not null,
    value2 number not null,
    name1 varchar2(20),
    name2 varchar2(20),
    constraint ch_value1_CK check (value1 between 1 and 100),
    CONSTRAINT ch_name2_ck check (name2 in ('a','b')),
    constraint ch_value2_CK check (value2 > value1) 
);
insert into CHECKEXAM1
values(1, 1000, 2000, 'a', 'b');
---üũ ��������(SMRIT.CH_VALUE1_CK)�� ����Ǿ����ϴ�
insert into CHECKEXAM1
values(1, 99, 80, 'a', 'b');
-- üũ ��������(SMRIT.CH_VALUE2_CK)�� ����Ǿ����ϴ�
insert into CHECKEXAM1
values(1, 99, 100, 'a', 'b');

insert into departments
select * from hr.departments;

insert into employees
select * from hr.employees;

select employee_id, first_name , 
        salary * ( 1+ nvl(commission_pct , 0)) year_sal
from employees;

create view year_sal
as
select employee_id, first_name , 
        salary * ( 1+ nvl(commission_pct , 0)) year_sal
from employees;

select * from year_sal;

create view emp80
as
select * from employees
where department_id = 80;
select * from  emp80;

--- 50�� �μ��� �̸� , ���� , �����ȣ, ������ ����ϴ� �並 ���弼��.
-- ����� salvu50
drop view salvu50;
create OR REPLACE view salvu50
 (ID_NUMBER, NAME, jobid, ANN_SALARY, did)
as
select employee_id, first_name, job_id, salary * 12,
       department_id
from employees
where department_id = 50;

select * from salvu50;

create OR REPLACE view salvu50
as
select employee_id ID_NUMBER, first_name NAME,
        job_id jobid, salary * 12 ANN_SALARY,
       department_id did
from employees
where department_id = 50;

-- �� �μ��� �޿��� �ּҰ� , �޿��� �ִ밪, �޿��� ���, �հ踦 
-- ����� �� �ִ� �並 ����ÿ�.
-- ����� dept_sum_vu
-- �÷����� ��Ī�� �μ����� name, �ּҰ� minsal, �ִ밪�� maxsal,
-- ����� avgsal, �հ�� sumsal
create or REPLACE view dept_sum_vu
    (name, minsal, maxsal, avgsal, sumsal)
as 
select department_id , min(salary), max(salary), avg(salary),
       sum(salary)
from employees
group by department_id;

select * from dept_sum_vu;

--- �μ���ȣ, �μ���, �޿� ���
select department_id, deparment_name, salary
from departments d, employees e
where d.department_id = e.department_id;

-- �μ���, �޿� ���
select  deparment_name, salary
from departments d, employees e
where d.department_id = e.department_id;

-- �μ���, �޿��� �հ�, ���, �ִ밪, �ּҰ��� ���Ͻÿ�.
select department_name, sum(salary), avg(salary), min(salary)
       , max(salary)
from departments d, employees e
where d.department_id = e.department_id
group by department_name;

--- �� �μ��� �޿��� �ּҰ� , �޿��� �ִ밪, �޿��� ���, �հ踦 
-- ����� �� �ִ� �並 ����ÿ�.
-- ����� dept_sum_vu
-- �÷����� ��Ī�� �μ����� name, �ּҰ� minsal, �ִ밪�� maxsal,
-- ����� avgsal, �հ�� sumsal
create or REPLACE view dept_sum_vu
    (name, sumsal, avgsal, minsal, maxsal)
as 
select department_name, sum(salary), avg(salary), min(salary)
       , max(salary)
from departments d, employees e
where d.department_id = e.department_id
group by department_name;