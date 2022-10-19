drop table a cascade CONSTRAINTS;


insert into (select employee_id, last_name, email, job_id
            , hire_date, department_id
            from employees
            where department_id = 50) -- inline view
values(600, '이', 'high', '강사', sysdate, 30);

select * from employees;
insert into (select employee_id, last_name, email, job_id
            , hire_date, department_id
            from employees
            where department_id = 50
            with check option)
values(601, '이', 'high', '강사', sysdate, 50);

select * from employees;

inline view : 테이블 대신 사용하는 서브쿼리;

select *
from (select employee_id , salary , last_name, department_id
       from employees
       where job_id like '%REP%')
where department_id = 80;


각 부서의 평균 급여보다 많이 받는 사원을 출력하시오
사원번호,성, 급여 ,부서, 평균 급여;
select employee_id,  last_name , salary, department_id
from employees;

select department_id , avg(salary)
from employees
group by department_id;

select employee_id,  last_name , salary, e.department_id, avgsal
from employees e, (select department_id , avg(salary) avgsal
                    from employees
                    group by department_id) s
where e.department_id = s.department_id
and salary > avgsal;

select employee_id,  last_name , salary, e.department_id, avgsal
from employees e join (select department_id , avg(salary) avgsal
                    from employees
                    group by department_id) s
on e.department_id = s.department_id
where salary > avgsal;

select employee_id,  last_name , salary, department_id, avgsal
from employees
NATURAL join (select department_id , avg(salary) avgsal
                    from employees
                    group by department_id)
where salary > avgsal;

--- 스칼라 서브쿼리 
(location_id 가 1800인) 20부서인 경우 부서번호를 usa를 출력하시오.
아니면 korea
사원번호, 이름, 급여 , 부서번호
select department_id 
from departments 
where location_id = 1800;

select employee_id, first_name, salary, 
    case  when department_id  = (
                        select department_id 
                        from departments 
                        where location_id = 1800) then 'USA'
          else 'Korea' end locations
from employees;
CREATE TABLE ex7_3 (
    emp_id    NUMBER,
    emp_name  VARCHAR2(100)
);
insert all
    into ex7_3(emp_id, emp_name) 
    values(1, '강감찬')
    into ex7_3(emp_id, emp_name) 
    values(2, '이순신')
select * from dual;

create table emp
as
select * from hr.employees
where employee_id = 132;

select * from emp;
select * from employees;

--- merge
merge into emp e1
using (select * from employees) e2
on (e1.employee_id = e2.employee_id)
WHEN MATCHED THEN
update set
    salary = salary * 1.1,
    hire_date = sysdate
WHEN NOT MATCHED THEN
insert values(e2.employee_id, e2.first_name, e2.last_name,
              e2.email, e2.phone_number, e2.hire_date, e2.job_id,
              e2.salary,e2.commission_pct, e2.manager_id,
              e2.department_id);
select * from emp;

---- merge 
delete from emp where employee_id != 132;
select * from emp;

merge into emp c
using (select * from employees) e
on (c.employee_id = e.employee_id)
when matched then
update set 
    salary = null
delete where e.employee_id = 132
when not matched then
insert values(e.employee_id, e.first_name, e.last_name,
e.email, e.phone_number, e.hire_date, e.job_id,
e.salary, e.commission_pct, e.manager_id,
e.department_id);

select * from emp;


-- 각부서의 급여를 제일 많이 받는 사원을 출력하시오.
select employee_id, salary, e.department_id, maxsal
from employees e join (select department_id, max(salary) maxsal
                       from employees
                       group by department_id) e1
on e.department_id = e1.department_id
and salary =  maxsal;

--- 쌍비교
select employee_id, first_name, salary, department_id
from employees
where (department_id, salary) in
 (select department_id, max(salary)
  from employees
  group by department_id);
--- 비쌍 비교
select employee_id, first_name, salary, department_id
from employees
where department_id in (select distinct department_id
                        from employees)
and salary in (select max(salary) from employees
               group by department_id);

window함수 ;
Select window_function(arguments), column1, ...
		over(partition by 컬럼 order by windowing 절)
From table명;

employees 테이블의 첫 행부터 마지막행까지 직원 번호, 
이름, 급여, 급여의 총합계를 출력하시오;
select sum(salary) from employees;

select employee_id, first_name, salary, 
      sum(salary) over(order by salary 
      rows between unbounded preceding and 
      UNBOUNDED FOLLOWING )total
from employees;

employees 테이블의 첫 행부터 마지막행까지 직원 번호, 
이름, 급여, 급여의 누적 합계를 출력하시오;

select employee_id, first_name, salary, 
      sum(salary) over(order by salary 
      rows between unbounded preceding and 
      CURRENT row )total
from employees;

employees 테이블의 첫 행부터 마지막행까지 직원 번호, 이름, 급여, 
급여의 합계를 현재 행 부터 마지막행까지의 합을 구하시오;

select employee_id, first_name, salary, 
      sum(salary) over(order by salary 
      rows between CURRENT row and 
      UNBOUNDED FOLLOWING )total
from employees;

 RANK();
 
select employee_id, salary, 
       RANK() over(order by salary desc ) all_rank,
       job_id, 
       RANK() over(PARTITION BY job_id order by salary desc) 
       job_rank
from employees
order by job_id;

DENSE_RANK() ;
select employee_id, salary, 
       RANK() over(order by salary desc ) all_rank,
       DENSE_RANK() over(order by salary desc ) DEN_RANK
from employees;

ROW_NUMBER();
select employee_id, salary, 
       RANK() over(order by salary desc ) all_rank,
       ROW_NUMBER() over(order by salary desc ) ROW_NUMBER
from employees;

부서별 급여의 합계를 구하세요;
select department_id, sum(salary)
from employees
group by department_id;


부서별 급여의 합계를 구하는데 사원번호, 이름 , 직무를 출력;
select employee_id, first_name, job_id, department_id,
      sum(salary) over(partition by department_id) dep_sum
from employees;

상사별 급여의 평균을 직원번호 상사번호 이름 급여를 출력하세요;
select employee_id, first_name, salary, manager_id,
      avg(salary) over(partition by manager_id) man_sum
from employees;

--- 부서별 급여를 제일 많이 급여 이름과 사원번호, 이름, 급여, 직무를
select employee_id, first_name, salary, job_id,
      max(salary) over(partition by department_id)
from employees;

select employee_id, first_name, salary, job_id,
      first_value(salary) over(partition by department_id
      order by salary desc ROWS UNBOUNDED PRECEDING) max_sal
from employees;

--- 부서별 급여를 제일 적게 급여 이름과 사원번호, 이름, 급여, 직무를
select employee_id, first_name, salary, job_id,
      min(salary) over(partition by department_id)
from employees;

select employee_id, first_name, salary, job_id,
      first_value(salary) over(partition by department_id
      order by salary asc ROWS UNBOUNDED PRECEDING) max_sal
from employees;

select employee_id, first_name, salary, job_id,
      last_value(first_name) over(partition by department_id
      order by salary desc ROWS between UNBOUNDED PRECEDING
                           and UNBOUNDED FOLLOWING  ) max_sal
from employees;
