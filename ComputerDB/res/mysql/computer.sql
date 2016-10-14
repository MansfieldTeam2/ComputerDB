use computer;
drop table if exists computerDb;
create table computerDb (
  id int unsigned not null auto_increment,
  modelNumber varchar(24) not null,
  model varchar(18) not null,
  modelType varchar(14) not null,
  cost double not null,
  primary key(id)
);
