# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table featured_module (
  id                        bigint not null,
  module_id                 bigint not null,
  name                      varchar(255),
  constraint pk_featured_module primary key (id))
;

create table module (
  id                        bigint not null,
  hykdkddysa                varchar(255),
  name                      varchar(255),
  is_featured               boolean,
  constraint pk_module primary key (id))
;

create table module_version (
  id                        bigint not null,
  module_id                 bigint,
  version                   varchar(255),
  constraint pk_module_version primary key (id))
;

create sequence featured_module_seq;

create sequence module_seq;

create sequence module_version_seq;

alter table featured_module add constraint fk_featured_module_module_1 foreign key (module_id) references module (id) on delete restrict on update restrict;
create index ix_featured_module_module_1 on featured_module (module_id);
alter table module_version add constraint fk_module_version_module_2 foreign key (module_id) references module (id) on delete restrict on update restrict;
create index ix_module_version_module_2 on module_version (module_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists featured_module;

drop table if exists module;

drop table if exists module_version;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists featured_module_seq;

drop sequence if exists module_seq;

drop sequence if exists module_version_seq;

