CREATE TABLE IF NOT EXISTS top
(
    id_secret    serial primary key,
    time_secret  character varying(2000) NOT NULL,
    name_secret  character varying(2000) NOT NULL,
    email_secret character varying(2000) NOT NULL,
    login_secret character varying(2000) NOT NULL,
    pass_secret  character varying(2000) NOT NULL,
    byte_secret  bytea
);
