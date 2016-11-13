create database registrar;

create user developer identified by 'developer123';

grant all on registrar.* to 'developer' with grant option;