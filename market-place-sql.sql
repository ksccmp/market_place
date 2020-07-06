create database marketPlace;

use marketPlace;

create table product (
	id int auto_increment primary key,
    image varchar(100),
    userid varchar(50),
    name varchar(50),
    description varchar(200),
    price int,
    count int,
    regdate datetime
);

create table user (
	id int auto_increment primary key,
    userid varchar(50),
    password varchar(50),
    name varchar(50),
    phone varchar(50)
);

create table purchase (
	id int auto_increment primary key,
    userid varchar(50),
    pid int,
    count int,
    regdate datetime
);

set charset utf8;
alter database marketplace default character set utf8;
alter table product convert to character set utf8;
alter table user convert to character set utf8;
alter table purchase convert to character set utf8;
set sql_safe_updates=0;

select * from user;
select * from product;
select * from purchase;

select * from purchase pu join product p using pu.pid = p.id;

delete from user;
delete from product;

drop table product;
drop table user;