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

-----------------------------------------------------
drop table order_list;
drop table order1;
drop table chk_book;
drop table supply_book;
drop table contract_company;
drop table book;
drop table publisher;
drop table member;
create table member(
    member_no varchar2(15),
    member_name varchar2(21) not null,
    member_id varchar2(12) not null,
    member_phone varchar2(30) not null,
    member_email varchar2(40),
    member_mobile  varchar2(30),
    pay_method varchar2(16)
);

create table publisher(
    pub_co_num varchar2(15) ,
    pub_name varchar2(20) not null,
    pub_addr varchar2(50) not null,
    pub_phone varchar2(30) not null,
    bank_no varchar2(7) not null,
    account_num varchar2(16) not null
);

create table book(
    book_no number ,
    book_name varchar2(20),
    book_ck number(6,3) ,
    book_qty number 
);

create table contract_company(
    cont_number number not null,
    cont_status number not null,
    min_pct number(6,3) not null,
    cont_date date not null,
    pub_co_num varchar2(15)
);

create table supply_book(
    book_no number not null,
    cont_number number not null,
    book_reg date not null
);

create table chk_book(
    chk_no number not null,
    member_no varchar2(15) not null,
    book_no number(6,3) not null,
    reg_date date not null
);

create table order1(
    order_no number(15),
    del_addr varchar2(21) not null,
    del_phone varchar2(12) not null,
    order_date date not null,
    del_code number(6,3)not null,
    payment  number(6,3)not null,
    tot_payment number,
    member_no varchar2(15),
    qty number 
);

create table order_list(
    order_no number not null,
    order_qty number not null,
    book_no number not null
);

select * from user_tables;

alter table member
add ( constraint mem_memno_pk primary key(member_no));

alter table publisher
add (constraint pub_pubconnum_pk primary key(pub_co_num));

alter table book
add (constraint book_bkno_pk primary key(book_no));

alter table contract_company
add (constraint coco_contnum_pk primary key(cont_number));

alter table order1
add(constraint order1_orderno_pk primary key(order_no));
-------------------------------------------------------------
alter table supply_book
add(constraint subook_bookno_pk primary key(book_no),
    constraint subook_contnum_pk primary key(cont_number));
---테이블에는 하나의 기본 키만 가질 수 있습니다.

alter table  supply_book
add (constraint subook_bkno_connum_pk
        primary key(book_no, cont_number));
select * from user_cons_columns
where table_name ='SUPPLY_BOOK';
    
alter table chk_book
add (constraint ckbk_memno_bkno_pk 
        primary key(chk_no, member_no,book_no)); 
select * from user_cons_columns
where table_name ='CHK_BOOK';    

alter table  order_list
add(constraint orlist_orderno_bookno_pk primary key(
        order_no, book_no));
select * from user_cons_columns
where table_name ='ORDER_LIST';
------- FOREIGN KEY----
alter table contract_company
add(CONSTRAINT concom_pubconum_fk foreign key(pub_co_num)
    REFERENCES publisher (pub_co_num));
select * from user_cons_columns
where table_name ='CONTRACT_COMPANY';

alter table supply_book
add(constraint subk_bookno_fk foreign key(book_no)
    references book(book_no),
    constraint subk_contnum_fk foreign key(cont_number)
    references contract_company(cont_number));
select * from user_cons_columns
where table_name ='SUPPLY_BOOK';

alter table chk_book 
add(constraint chbk_memno_fk foreign key (member_no)
    references member(member_no),
    constraint chbk_bookno_fk foreign key (book_no)
    references book(book_no));

alter table  order1
add(constraint order1_memno_fk foreign key (member_no)
    references member(member_no));
    
alter table  order_list
add(constraint order1_orderno_fk foreign key (order_no)
    references order1(order_no),
    constraint order1_bookno_fk foreign key (book_no)
    references book(book_no));
    

drop table d;
drop table c;
drop taBLE b;
drop table a;

create table a(
    a1 number,  -- pk
    a2 varchar2(15)
);
create table b(
    b1 number,   -- pk
    b2 varchar2(15),
    a1 number    -- pk/fk
);
create table c( 
    b1 number, --pk / FK
    a1 number, --pk / FK
    c1 number, --pk 
    c2 varchar2(20)
);
create table d(
    b1 number,  --fk
    a1 number,  --fk
    d1 number,   --- pk
    d2 varchar2(20)
);
alter table a
add (constraint a_a1_pk primary key (a1));

alter table b
add( constraint b_a1_b1_pk primary key (a1,b1));

alter table c
add( constraint c_a1_b1_c1__pk primary key (a1,b1,c1));

alter table d
add( constraint d_d1_pk primary key (d1));
--------------------------------------------------

alter table b
add(constraint b_a1_fk  foreign key(a1)
    references a(a1));

alter table c
add(constraint c_a1_b1_fk foreign key(a1,b1)
    references b(a1, b1));
    
alter table d
add(constraint d_a1_b1_fk foreign key(a1,b1)
    references b(a1, b1));

insert into a(a1, a2)
values(1, 'a');
select * from a;

insert into b(b1,b2, a1)
values(11, 'b11', 1);
select * from b;

insert into c(c1,c2, a1, b1)
values(111,'C111',1,11);

insert into d(d1,d2,a1,b1)
values(1111,'D1111',1,11);

delete from d;
select * from d;

delete from c;
delete from b;
delete from a;