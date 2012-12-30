# Rounds schema
 
# --- !Ups

CREATE SEQUENCE round_id_seq;
CREATE TABLE round (
  id integer NOT NULL PRIMARY KEY DEFAULT nextval('round_id_seq'),
  game_id integer
);
 
# --- !Downs

DROP SEQUENCE round_id_seq;
DROP TABLE round;