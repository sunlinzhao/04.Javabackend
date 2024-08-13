create table message
(
    id       int          not null,
    nickname varchar(255) null,
    content  varchar(255) null,
    ip       varchar(255) null,
    mtime    datetime     null,
    constraint id
        primary key (id)
);
alter table message
    modify id int auto_increment;

alter table message
    auto_increment = 1;