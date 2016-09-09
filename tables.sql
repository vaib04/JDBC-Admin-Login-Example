create database VB1308_AJP_Lab3;
use VB1308_AJP_Lab3;
create table account (user varchar(20) primary key,password varchar(20) not null,balance double not null default 12000,temp varchar(1) not null default "d");
create table transact (user1 varchar(20),user2 varchar(20),amount double not null default 0);


insert into account values ("admin","root",0,"x");
insert into account values ("aaa","111",10000,"e");
insert into account values ("bbb","222",5000,"d");
insert into account values ("ccc","333",1300.54,"f");

insert into account values ("eee","555",1234,"e");