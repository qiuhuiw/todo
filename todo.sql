drop database if exists tododb;
create database tododb;
drop table if exists task;
create table task(
          id int(10) primary key,
          tname varchar(50),
          description varchar(200)
);

insert into task values(1, 'task1','setup a dev environment');
insert into task values(2, 'task2','Learn Java servlet(what is java servlet and servelet lifecycle)');
insert into task values(3, 'task3','Learn jsp');
insert into task values(4, 'task4','Learn jsp tag');
insert into task values(5, 'task5','Learn how to config web.xml');
insert into task values(6, 'task6','implement a web version todo app');
