CREATE TABLE IF NOT EXISTS users
(
    id_user  serial primary key            NOT NULL,
    name     character varying(255)        NOT NULL,
    login    character varying(255) unique NOT NULL,
    password character varying(255)        NOT NULL,
    email    character varying(255)        NOT NULL,
    phone    character varying(255)        NOT NULL
);

CREATE TABLE IF NOT EXISTS brands
(
    id_brand serial primary key     NOT NULL,
    values   character varying(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS models
(
    id_model serial primary key     NOT NULL,
    values   character varying(255) NOT NULL,
    brand_id int4,
    CONSTRAINT brands_id_fk FOREIGN KEY (brand_id)
        REFERENCES brands (id_brand) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS colors
(
    id_color serial primary key     NOT NULL,
    values   character varying(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS engines
(
    id_engine serial primary key     NOT NULL,
    values    character varying(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS years
(
    id_year serial primary key     NOT NULL,
    values  character varying(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS auto
(
    id_auto   serial primary key NOT NULL,
    brand_id  int4,
    model_id  int4,
    color_id  int4,
    engine_id int4,
    year_id   int4,
    CONSTRAINT brand_id_fk FOREIGN KEY (brand_id)
        REFERENCES brands (id_brand) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT model_id_fk FOREIGN KEY (model_id)
        REFERENCES models (id_model) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT color_id_fk FOREIGN KEY (color_id)
        REFERENCES colors (id_color) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT engine_id_fk FOREIGN KEY (engine_id)
        REFERENCES engines (id_engine) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT year_id_fk FOREIGN KEY (year_id)
        REFERENCES years (id_year) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
CREATE TABLE IF NOT EXISTS ads
(
    id_ads  serial primary key    NOT NULL,
    times   date                  NOT NULL,
    status  character varying(10) NOT NULL,
    user_id int4,
    auto_id int4,
    CONSTRAINT user_id_fk FOREIGN KEY (user_id)
        REFERENCES users (id_user) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT auto_id_fk FOREIGN KEY (auto_id)
        REFERENCES auto (id_auto) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS foto
(
    id_foto serial primary key NOT NULL,
    values  text,
    ads_id  int4 unique,
    CONSTRAINT ads_id_fk FOREIGN KEY (ads_id)
        REFERENCES ads (id_ads) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
insert into users (name, login, password, email, phone)
values ('user1', '111', '1', 'user@u.com', '4143812211');
insert into users (name, login, password, email, phone)
values ('user2', '222', '1', 'user@u.com', '4143812211');
insert into users (name, login, password, email, phone)
values ('user3', '333', '1', 'user@u.com', '4143812211');
insert into users (name, login, password, email, phone)
values ('user4', '444', '1', 'user@u.com', '4143812211');
insert into users (name, login, password, email, phone)
values ('user5', '555', '1', 'user@u.com', '4143812211');

insert into brands (values)
values ('bmw'),
       ('mercedes'),
       ('toyota'),
       ('lexus');

insert into models (values, brand_id)
values ('3', 1),
       ('5', 1),
       ('7', 1),
       ('C', 2),
       ('S', 2),
       ('G', 2),
       ('Prado', 3),
       ('Corolla', 3),
       ('Camry', 3),
       ('RX', 4),
       ('LX', 4),
       ('ES', 4);
insert into colors(values)
values ('чёрный'),
       ('синий'),
       ('белый'),
       ('зелёный'),
       ('серый');
insert into engines(values)
values ('бензин'),
       ('дизель'),
       ('электро'),
       ('газ');
insert into years(values)
values ('2020'),
       ('2019'),
       ('2018'),
       ('2017');


insert into auto(brand_id, model_id, color_id, engine_id, year_id)
values (1, 2, 1, 1, 1);
insert into auto(brand_id, model_id, color_id, engine_id, year_id)
values (1, 2, 1, 1, 1);
insert into auto(brand_id, model_id, color_id, engine_id, year_id)
values (1, 3, 2, 1, 2);
insert into auto(brand_id, model_id, color_id, engine_id, year_id)
values (2, 5, 5, 1, 2);
insert into auto(brand_id, model_id, color_id, engine_id, year_id)
values (2, 6, 4, 4, 3);
insert into auto(brand_id, model_id, color_id, engine_id, year_id)
values (2, 4, 5, 4, 3);

insert into ads(times, status, user_id, auto_id)
values ('2020-05-01', 'no', 1, 1);
insert into ads(times, status, user_id, auto_id)
values ('2020-05-10', 'no', 2, 2);
insert into ads(times, status, user_id, auto_id)
values ('2020-05-20', 'no', 3, 3);
insert into ads(times, status, user_id, auto_id)
values ('2020-05-20', 'yes', 4, 4);
insert into ads(times, status, user_id, auto_id)
values ('2020-05-30', 'yes', 5, 5);
insert into ads(times, status, user_id, auto_id)
values ('2020-05-30', 'no', 5, 6);

insert into foto(values, ads_id)
VALUES ('img/bmw530.png', 1);
insert into foto(values, ads_id)
VALUES ('img/bmw540.png', 2);
insert into foto(values, ads_id)
VALUES ('img/bmw750.png', 3);
insert into foto(values, ads_id)
VALUES ('img/s600.png', 4);
insert into foto(values, ads_id)
VALUES ('img/mG63.png', 5);
insert into foto(values, ads_id)
VALUES ('img/default.png', 6);
