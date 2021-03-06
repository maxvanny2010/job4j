CREATE TABLE IF NOT EXISTS item
(
    id        serial primary key,
    id_item   character varying(2000) NOT NULL,
    name_item character varying(2000) NOT NULL,
    desc_item text
);
CREATE TABLE IF NOT EXISTS vacancy
(
    id           serial primary key,
    date_vacancy character varying(20)   NOT NULL,
    name_vacancy character varying(2000) NOT NULL,
    desc_vacancy text,
    link_vacancy character varying(2000) NOT NULL
);
