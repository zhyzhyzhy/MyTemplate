create table user
(
  id         int auto_increment
    primary key,
  name       varchar(16) not null,
  gender     tinyint     not null,
  gmt_create datetime    not null,
  constraint uk_name
  unique (name)
)
  engine = InnoDB;

create index id_create_time
  on user (gmt_create);

