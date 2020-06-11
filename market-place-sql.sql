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

set charset utf8;
alter database marketplace default character set utf8;
alter table product convert to character set utf8;
alter table user convert to character set utf8;

drop table product;
drop table user;