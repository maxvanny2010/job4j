CREATE TABLE IF NOT EXISTS accident
(
    id_accident serial primary key,
    number      varchar(2000),
    text        text,
    address     varchar(2000),
    user_id     int4,
    CONSTRAINT user_id_fk FOREIGN KEY (user_id)
        REFERENCES users (id_users) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
insert into accident (number, text, address, user_id)
values ('o000o', 'yes', 'CA 1', 1),
       ('a0000a', 'yes', 'NY 2', 1),
       ('b0000b', 'no', 'FL 3', 2),
       ('c0000c', 'yes', 'CA 4', 2);
