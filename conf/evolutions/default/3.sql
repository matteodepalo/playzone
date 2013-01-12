# Users schema

# --- !Ups

create sequence user_id_seq;
create table "user" (
  id integer not null primary key default nextval('user_id_seq'),
  name varchar(255),
  email varchar(255)
);

# --- !Downs

drop sequence user_id_seq;
drop table "user";