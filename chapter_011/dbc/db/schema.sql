CREATE TABLE IF NOT EXISTS accident
(
    id_accident serial primary key,
    name        varchar(2000)
);
insert into accident (name)
values ('1111'),
       ('2222'),
       ('3333'),
       ('4444');
