# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table photo (
  id                        bigint not null,
  title                     varchar(255),
  url                       varchar(255),
  constraint pk_photo primary key (id))
;

create sequence photo_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists photo;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists photo_seq;

