DROP TABLE IF EXISTS price_data;

create table price_data (
    id integer not null auto_increment unique,
    code varchar(300),
    name varchar(300),
    price integer,
    PRIMARY KEY (id)


DROP SEQUENCE IF EXISTS hibernate_sequence;

CREATE SEQUENCE hibernate_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE hibernate_sequence
    OWNER TO postgres;                        
);