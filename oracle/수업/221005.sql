alter session set "_ORACLE_SCRIPT"=true;

drop user hr cascade;

create user hr identified by hr; 
grant resource,create session, connect  to hr;
alter user hr default tablespace users 
              quota unlimited on users;
              
              
DESCRIBE hr.departments;
--- projection

--- selection
