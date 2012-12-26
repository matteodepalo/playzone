# Rounds schema
 
# --- !Ups

CREATE SEQUENCE round_id_seq;
CREATE TABLE round (
    id integer NOT NULL DEFAULT nextval('round_id_seq'),
    game varchar(255)
);
 
# --- !Downs
 
DROP TABLE round;
DROP SEQUENCE round_id_seq;