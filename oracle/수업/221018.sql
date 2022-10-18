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
values(1, 99, 100, 'a', 'b')






