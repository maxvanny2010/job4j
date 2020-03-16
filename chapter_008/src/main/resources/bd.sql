CREATE TABLE IF NOT EXISTS users
(
    id          serial primary key NOT NULL,
    login       character varying(2000),
    password    character varying(2000),
    create_date timestamp without time zone
);
