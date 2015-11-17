# --- !Ups

CREATE SEQUENCE "company_id_seq" INCREMENT BY 4 START WITH 1;
CREATE SEQUENCE "child_id_seq" INCREMENT BY 1 START WITH 1;


CREATE TABLE company
(
  id integer NOT NULL DEFAULT nextval('company_id_seq'::regclass),
  name character varying NOT NULL,
  value integer NOT NULL,
  parent boolean NOT NULL,
  CONSTRAINT pkcompany PRIMARY KEY (id)
)
WITH (
OIDS=FALSE
);
ALTER TABLE company
OWNER TO postgres;

CREATE TABLE child
(
  id integer NOT NULL DEFAULT nextval('child_id_seq'::regclass),
  child integer NOT NULL,
  parent integer NOT NULL,
  CONSTRAINT pkchild PRIMARY KEY (id)
)
WITH (
OIDS=FALSE
);
ALTER TABLE child
OWNER TO postgres;


# --- !Downs

ALTER TABLE agent_position DROP CONSTRAINT company_id_seq;
ALTER TABLE agent_position DROP CONSTRAINT child_id_seq;

DROP TABLE company;
DROP TABLE child;

/******************** Drop Sequence ************************/
DROP SEQUENCE "child_id_seq";
DROP SEQUENCE "company_id_seq";