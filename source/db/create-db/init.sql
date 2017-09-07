-- create db

CREATE DATABASE zenicor_users;
USE zenicor_users;



-- create zenicor user

CREATE USER 'zenicor'@'%'
IDENTIFIED BY 'rocinez';



-- create table for storing users

CREATE TABLE user (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(20) NOT NULL DEFAULT '',
  password varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

GRANT SELECT ON user
TO 'zenicor'@'%';



-- fill in some data

INSERT INTO user (name, password)
VALUES ('kokos', 'test');
