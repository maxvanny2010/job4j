CREATE TABLE public.driver
(
    id_driver serial primary key      NOT NULL,
    name      character varying(2000) NOT NULL
)
    WITH (
        OIDS = FALSE
    );
ALTER TABLE public.driver
    OWNER to postgres;

CREATE TABLE public.engine
(
    id_engine serial primary key      NOT NULL,
    volume    character varying(2000) NOT NULL
)
    WITH (
        OIDS = FALSE
    );
ALTER TABLE public.engine
    OWNER to postgres;

CREATE TABLE public.car
(
    id_car    serial primary key      NOT NULL,
    brand     character varying(2000) NOT NULL,
    engine_id bigint unique           NOT NULL,
    CONSTRAINT engine_id_fk FOREIGN KEY (engine_id)
        REFERENCES public.engine (id_engine) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
    WITH (
        OIDS = FALSE
    );

ALTER TABLE public.car
    OWNER to postgres;

CREATE TABLE public.owner
(
    id_owner  serial primary key NOT NULL,
    driver_id bigint             NOT NULL,
    car_id    bigint             NOT NULL,
    CONSTRAINT driver__id_fk FOREIGN KEY (driver_id)
        REFERENCES public.driver (id_driver) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT car_id_fk FOREIGN KEY (car_id)
        REFERENCES public.car (id_car) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
    WITH (
        OIDS = FALSE
    );

ALTER TABLE public.owner
    OWNER to postgres;

