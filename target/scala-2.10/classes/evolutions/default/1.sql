# Rounds schema
 
# --- !Ups

CREATE TABLE round (
    id integer NOT NULL auto_increment PRIMARY KEY,
    game varchar(255)
);
 
# --- !Downs
 
DROP TABLE round;