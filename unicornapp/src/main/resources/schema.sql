drop table if exists UNICORN;

create table UNICORN
(
   id integer not null,
   name varchar(255) not null,
   color varchar(255) not null,
   zone_id integer not null,
   primary key(id)
);

drop table if exists ZONE;

create table ZONE
(
   id integer not null,
   name varchar(400) not null,
   longtitude varchar(255) not null,
   latitude varchar(255) not null,
   primary key(id)
);