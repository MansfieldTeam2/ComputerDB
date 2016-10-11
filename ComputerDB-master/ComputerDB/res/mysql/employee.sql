use ComputerDB;
drop table if exists computer;
create table computer (
  number int unsigned not null auto_increment,
  modelNumber varchar(24) not null,
  model varchar(18) not null,
  modelType varchar(14) not null,
  cost double not null,
  primary key(number)
);
