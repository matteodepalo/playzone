# Games schema
 
# --- !Ups

CREATE SEQUENCE game_id_seq;
CREATE TABLE game (
  id integer NOT NULL PRIMARY KEY DEFAULT nextval('game_id_seq'),
  name varchar(255)
);
 
# --- !Downs

DROP SEQUENCE game_id_seq;
DROP TABLE game;