CREATE TABLE IF NOT EXISTS hbm
(
    id_hbm  serial primary key,
    name    varchar(2000),
    text    text,
    address varchar(2000)
);
insert into hbm (name, text, address)
values ('sun', ' yes', 'CA'),
       ('google', 'yes', 'NY'),
       ('micro', 'no', 'FL'),
       ('tesla', 'yes', 'CA');
