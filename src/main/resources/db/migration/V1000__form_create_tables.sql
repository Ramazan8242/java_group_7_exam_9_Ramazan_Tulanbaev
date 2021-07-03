use `forum`;

create table subjects (id integer not null auto_increment, events varchar(128), local_date date, user_id integer, primary key (id)) engine=InnoDB;
create table users (id integer not null auto_increment, email varchar(128), password varchar(128), role varchar(128), username varchar(128), primary key (id)) engine=InnoDB;
alter table subjects add constraint FKm9k2q12kousqip4g5spqrm2am foreign key (user_id) references users (id);