drop table DEPARTMENTS;
drop table employees;
create table DEPARTMENTS(
    DEPARTMENT_ID    NUMBER(4) NOT NULL,    
    DEPARTMENT_NAME  VARCHAR2(30) NOT NULL,
    MANAGER_ID       NUMBER(6),    
    LOCATION_ID      NUMBER(4)
);
desc hr.departments;
select * from  user_constraints 
where table_name = 'DEPARTMENTS';

alter table DEPARTMENTS
add(
    constraint dept_deptid_PK primary key(department_id)
);
select * from  user_constraints 
where table_name = 'DEPARTMENTS';

desc hr.employees;
create table employees(
    EMPLOYEE_ID     NUMBER(6) 
        constraint emp_empid_PK primary key,  
    FIRST_NAME              VARCHAR2(20) ,
    LAST_NAME       VARCHAR2(25) NOT NULL,
    EMAIL           VARCHAR2(25) NOT NULL, 
    PHONE_NUMBER    VARCHAR2(20) , 
    HIRE_DATE       DATE NOT NULL,         
    JOB_ID         VARCHAR2(10) NOT NULL ,
    SALARY                  NUMBER(8,2) , 
    COMMISSION_PCT          NUMBER(2,2) , 
    MANAGER_ID              NUMBER(6) ,   
    DEPARTMENT_ID           NUMBER(4) 
            constraint emp_deptid_FK
            REFERENCES departments (department_id)
);
select * from user_constraints
where table_name = 'EMPLOYEES';

insert into employees(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,
    EMAIL, PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,
    COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID )
values(198,'Donald','OConnell','DOCONNEL','650.507.9833',
'07/06/21','SH_CLERK',2600,null,124,50);
--무결성 제약조건(SMRIT.EMP_DEPTID_FK)이 위배되었습니다- 부모 키가 없습니다
select * from departments;
insert into departments(department_id,department_name,
manager_id,  location_id)
values(50,'Shipping',121,1500);
select * from departments;

insert into employees(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,
    EMAIL, PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,
    COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID )
values(198,'Donald','OConnell','DOCONNEL','650.507.9833',
'07/06/21','SH_CLERK',2600,null,124,50);
select * from employees;

drop table employees;

create table employees(
    EMPLOYEE_ID     NUMBER(6) ,  
    FIRST_NAME              VARCHAR2(20) ,
    LAST_NAME       VARCHAR2(25) NOT NULL,
    EMAIL           VARCHAR2(25) NOT NULL, 
    PHONE_NUMBER    VARCHAR2(20) , 
    HIRE_DATE       DATE NOT NULL,         
    JOB_ID         VARCHAR2(10) NOT NULL ,
    SALARY                  NUMBER(8,2) , 
    COMMISSION_PCT          NUMBER(2,2) , 
    MANAGER_ID              NUMBER(6) ,   
    DEPARTMENT_ID           NUMBER(4),
    constraint emp_empid_PK primary key (employee_id),
    constraint emp_deptid_FK FOREIGN key (DEPARTMENT_ID)
    REFERENCES departments (department_id)
);
insert into employees(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,
    EMAIL, PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,
    COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID )
values(198,'Donald','OConnell','DOCONNEL','650.507.9833',
'07/06/21','SH_CLERK',2600,null,124,50);
select * from employees;
drop table employees;

alter table departments
drop constraint DEPT_DEPTID_PK;

select * from user_constraints
where table_name='DEPARTMENTS';

drop table employees;
create table employees(
    EMPLOYEE_ID     NUMBER(6) ,  
    FIRST_NAME              VARCHAR2(20) ,
    LAST_NAME       VARCHAR2(25) NOT NULL,
    EMAIL           VARCHAR2(25) NOT NULL, 
    PHONE_NUMBER    VARCHAR2(20) , 
    HIRE_DATE       DATE NOT NULL,         
    JOB_ID         VARCHAR2(10) NOT NULL ,
    SALARY                  NUMBER(8,2) , 
    COMMISSION_PCT          NUMBER(2,2) , 
    MANAGER_ID              NUMBER(6) ,   
    DEPARTMENT_ID           NUMBER(4)
);
alter table employees
modify (employee_id NUMBER(6)
            constraint emp_empid_PK primary key,
        DEPARTMENT_ID NUMBER(4)
            constraint emp_deptid_FK 
            references departments(department_id)
);
--이 열목록에 대해 일치하는 고유 또는 기본 키가 없습니다
select * from user_constraints
where table_name ='DEPARTMENTS';

alter table departments
modify(department_id  NUMBER(4) 
        constraint dept_deptid_pk primary key);
        
alter table employees
modify (employee_id NUMBER(6)
            constraint emp_empid_PK primary key,
            DEPARTMENT_ID NUMBER(4)
            constraint emp_deptid_FK 
            references departments(department_id)
);
select * from user_constraints
where table_name ='EMPLOYEES';

--- table ---> primary key ---> foreign key\
drop table employees;
drop table departments;
-- 참조 테이블이 있는 경우 자식테이블을 삭제 후 부모테이블 삭제
create table DEPARTMENTS(
    DEPARTMENT_ID    NUMBER(4) NOT NULL,    
    DEPARTMENT_NAME  VARCHAR2(30) NOT NULL,
    MANAGER_ID       NUMBER(6),    
    LOCATION_ID      NUMBER(4)
);
create table employees(
    EMPLOYEE_ID     NUMBER(6) ,  
    FIRST_NAME              VARCHAR2(20) ,
    LAST_NAME       VARCHAR2(25) NOT NULL,
    EMAIL           VARCHAR2(25) NOT NULL, 
    PHONE_NUMBER    VARCHAR2(20) , 
    HIRE_DATE       DATE NOT NULL,         
    JOB_ID         VARCHAR2(10) NOT NULL ,
    SALARY                  NUMBER(8,2) , 
    COMMISSION_PCT          NUMBER(2,2) , 
    MANAGER_ID              NUMBER(6) ,   
    DEPARTMENT_ID           NUMBER(4)
);
---- primary key ---
alter tABLE employees
add( constraint emp_empid_pk primary key(employee_id));

alter table departments
add(constraint dept_deptid_PK primary key(department_id));

--- foreign key ---
alter table employees
add (constraint emp_deptid_fk FOREIGN key (department_id)
    REFERENCES departments (department_id));

select * from user_constraints
where table_name ='DEPARTMENTS';

select * from user_constraints
where table_name ='EMPLOYEES';