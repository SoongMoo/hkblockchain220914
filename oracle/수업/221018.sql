drop table d;
drop table c;
drop table b;
drop table a;

create table a( ---열레벨
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
            city in ('서울' , '부산' ,'대구', '대전' ))
);
insert into CHECKEXAM
values('인천');
-- 체크 제약조건(SMRIT.CH_CITY_CK)이 위배되었습니다
insert into CHECKEXAM
values('서울');
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
---체크 제약조건(SMRIT.CH_VALUE1_CK)이 위배되었습니다
insert into CHECKEXAM1
values(1, 99, 80, 'a', 'b');
-- 체크 제약조건(SMRIT.CH_VALUE2_CK)이 위배되었습니다
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

--- 50인 부서의 이름 , 직무 , 사원번호, 연봉를 출력하는 뷰를 만드세요.
-- 뷰명은 salvu50
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

-- 각 부서별 급여의 최소값 , 급여의 최대값, 급여의 평균, 합계를 
-- 출력할 수 있는 뷰를 만드시오.
-- 뷰명은 dept_sum_vu
-- 컬럼명의 별칭은 부서명은 name, 최소값 minsal, 최대값은 maxsal,
-- 평균은 avgsal, 합계는 sumsal
create or REPLACE view dept_sum_vu
    (name, minsal, maxsal, avgsal, sumsal)
as 
select department_id , min(salary), max(salary), avg(salary),
       sum(salary)
from employees
group by department_id;

select * from dept_sum_vu;

--- 부서번호, 부서명, 급여 출력
select department_id, deparment_name, salary
from departments d, employees e
where d.department_id = e.department_id;

-- 부서명, 급여 출력
select  deparment_name, salary
from departments d, employees e
where d.department_id = e.department_id;

-- 부서명, 급여의 합계, 평균, 최대값, 최소값을 구하시오.
select department_name, sum(salary), avg(salary), min(salary)
       , max(salary)
from departments d, employees e
where d.department_id = e.department_id
group by department_name;

--- 각 부서명별 급여의 최소값 , 급여의 최대값, 급여의 평균, 합계를 
-- 출력할 수 있는 뷰를 만드시오.
-- 뷰명은 dept_sum_vu
-- 컬럼명의 별칭은 부서명은 name, 최소값 minsal, 최대값은 maxsal,
-- 평균은 avgsal, 합계는 sumsal
create or REPLACE view dept_sum_vu
    (name, sumsal, avgsal, minsal, maxsal)
as 
select department_name, sum(salary), avg(salary), min(salary)
       , max(salary)
from departments d, employees e
where d.department_id = e.department_id
group by department_name;


create or REPLACE view dept_sum_vu
    (name, sumsal, avgsal, minsal, maxsal)
as 
select department_name, sum(salary), avg(salary), min(salary)
       , max(salary)
from departments d  join employees e
on d.department_id = e.department_id
group by department_name;

70부서의 사원번호, 이름, 직무 , 급여, 입사일을 출력하는 뷰를 만드시오.
뷰명은 empvu70;
desc employees;

create or replace view empvu70
as 
select employee_id, last_name, email, job_id, hire_date, salary,
        department_id
from employees
where department_id = 70;

select * from empvu70;
DML작업;
select * from employees;

select * from empvu70;

insert into empvu70(employee_id, last_name, email, job_id,
            hire_date, salary, department_id)
values(300, '이', 'high','강사', sysdate, 10000, 50);
--- "DEPARTMENT_ID": 부적합한 식별자
insert into empvu70(employee_id, last_name, email, job_id,
            hire_date, salary)
values(300, '이', 'high','강사', sysdate, 10000);

select * from empvu70;---뷰를 통해 실제 테이블에 insert를 할 수 있다.
select * from employees;

insert into empvu70(employee_id, last_name,email,job_id,hire_date,
                    salary, department_id)
values(301,'박', 'land', '학생', sysdate, 100, 50 );
select * from empvu70;
select * from employees;
insert into empvu70(employee_id, last_name,email,job_id,hire_date,
                    salary, department_id)
values(302,'상', 'highland', '학생', sysdate, 100, 70 );
select * from empvu70;
select * from employees;

delete from empvu70
where employee_id = 301;
---0개 행 이(가) 삭제되었습니다.

delete from empvu70
where employee_id = 302;
select * from empvu70;
select * from employees;

update empvu70
set salary = 10000;뷰에서 보이는 것만 update가 가능하다.

insert into empvu70(employee_id, last_name,email,job_id,hire_date,
                    salary, department_id)
values(302,'상', 'highland', '학생', sysdate, 100, 30 );
select * from empvu70;
update empvu70
set department_id = 50;
---- 뷰에서 보이는 것만 insert가 되거나 update가 되도록하지
select * from empvu70;
update employees
set department_id = 70
where employee_id = 204;

create or replace view empvu70
as 
select employee_id, last_name, email, job_id, hire_date, salary,
        department_id
from employees
where department_id = 70
WITH CHECK OPTION constraint empvu70_CK;

select * from empvu70;

update empvu70
set department_id = 50;
뷰의 WITH CHECK OPTION의 조건에 위배 됩니다;

insert into empvu70(employee_id, last_name,email,job_id,hire_date,
                    salary, department_id)
values(303,'상', 'highland', '학생', sysdate, 100, 30 );
--- 뷰의 WITH CHECK OPTION의 조건에 위배 됩니다
insert into empvu70(employee_id, last_name,email,job_id,hire_date,
                    salary, department_id)
values(303,'장', 'high11', '학생', sysdate, 100, 70 );
select * from empvu70;

create table viewupd1(
    c1 number,
    c2 int
);
create table viewupd2(
    c1 number,
    c3 number
);
insert into viewupd1 values(1,1);
insert into viewupd2 values(1,1);

create or replace view v_viewupd
as 
select v1.c1 , c2, c3
from viewupd1 v1, viewupd2 v2
where v1.c1 = v2.c1;

select * from v_viewupd;
update v_viewupd
set c2 = 10     --viewiupd1
where c1 = 1;
select * from v_viewupd;
update v_viewupd
set c3 = 10     --viewupd2
where c1 = 1;
select * from v_viewupd;

-- join을 한 경우 테이블별로 update를 하면 수정이 된다.;

update v_viewupd
set c2= 20, c3 =20
where c1 = 1;
-- 조인 뷰에 의하여 하나 이상의 기본 테이블을 수정할 수 없습니다.
select * from empvu70;

insert into empvu70(employee_id, last_name,email,job_id,hire_date,
                    salary, department_id)
values(304,'장', 'high11', '학생', sysdate, 100, 70 );

select * from empvu70;


create or replace view empvu70
as 
select employee_id, last_name, email, job_id, hire_date, salary,
        department_id
from employees
where department_id = 70
WITH READ ONLY; --DML문 작업 거부 , 읽기 전용
-- 읽기 전용 뷰에서는 DML 작업을 수행할 수 없습니다.
insert into empvu70(employee_id, last_name,email,job_id,hire_date,
                    salary, department_id)
values(305,'장', 'high11', '학생', sysdate, 100, 70 );

drop view empvu70;

시퀀스
CREATE SEQUENCE  empseq;
select empseq.nextval from dual;

CREATE SEQUENCE dept_deptid_seq
INCREMENT BY 10
START WITH 400
MAXVALUE 9999
NOCACHE
NOCYCLE;


alter SEQUENCE dept_deptid_seq
INCREMENT BY 20
MAXVALUE 999999
NOCACHE
NOCYCLE;

drop SEQUENCE dept_deptid_seq;

select dept_deptid_seq.NEXTVAL from dual;
select dept_deptid_seq.CURRVAL from dual;

insert into employees(employee_id, last_name, email, 
                    job_id, hire_date, salary)
values( (select max(employee_id) + 10  from employees),
         '이숭무', 'high', '선생님', sysdate, 10000 );
select * from employees;

insert into employees(employee_id, last_name, email, 
                    job_id, hire_date, salary)
values( dept_deptid_seq.NEXTVAL,
         '이숭무', 'high', '선생님', sysdate, 10000 );

select * from employees;

insert into departments(department_id, department_name)
values(dept_deptid_seq.NEXTVAL, '강사부');
select * from departments;
desc departments;

select max(employee_id) + 10 from employees;

create table seqTest(
    num2 number,
    name varchar2(30)
);
insert into seqTest(num2,name)
values(dept_deptid_seq.NEXTVAL, '이숭무');
select * from seqTest;


select * from user_sequences
where sequence_name = 'EMPSEQ';


select * 
from employees   --1
where last_name ='OConnell'; --2

create index emplastidx
on employees (last_name);

select department_id ,avg(salary)
from employees
group by department_id
having avg(salary) > 3000;

select employee_id, first_name
from employees
where substr(first_name, 1, 2) = 'Oc'  ;

create index empsub ---함수기반의 index
on employees(substr(first_name, 1, 2)); 


create index hanjeun ---함수기반의 index
on employees(start_time, end_time)); 

select * from employees
order by departmenrt_id, job_id;

create index empidx
on employees(department_id, job_id);



select * from departments;

insert into departments(department_id, department_name,
manager_id, location_id, min_salary)
values(300,'Administration',200,1700, 10000);                  

alter table departments
add (min_salary number,
     max_salary number);
     
alter table departments
drop (min_salary, max_salary);


SELECT INDEX_NAME, TABLE_NAME 
FROM USER_INDEXES
WHERE TABLE_NAME = 'EMPLOYEES';
