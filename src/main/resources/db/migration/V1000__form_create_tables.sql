use `forum`;

create table answers (id integer not null auto_increment, local_date date, text varchar(255), subject_id integer, user_id integer, primary key (id)) engine=InnoDB;
create table subjects (id integer not null auto_increment, events varchar(128), local_date date, user_id integer, primary key (id)) engine=InnoDB;
create table users (id integer not null auto_increment, email varchar(128), password varchar(128), role varchar(128), username varchar(128), primary key (id)) engine=InnoDB;
alter table answers add constraint FKre785r90q2tkb8s7u798lawla foreign key (subject_id) references subjects (id);
alter table answers add constraint FK5bp3d5loftq2vjn683ephn75a foreign key (user_id) references users (id);
alter table subjects add constraint FKm9k2q12kousqip4g5spqrm2am foreign key (user_id) references users (id);