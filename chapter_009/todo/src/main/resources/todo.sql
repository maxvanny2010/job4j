CREATE TABLE IF NOT EXISTS todo
(
    id          serial primary key      NOT NULL,
    create_date character varying(2000) NOT NULL,
    description character varying(2000) NOT NULL,
    done        character varying(2000) NOT NULL
);
