SET foreign_key_checks=0;

DROP DATABASE IF EXISTS todolist;
CREATE DATABASE todolist;

USE todolist;
CREATE TABLE IF NOT EXISTS tasks (
 id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 title VARCHAR(255) NOT NULL,
 created_at TIMESTAMP NOT NULL default now(),
 updated_at TIMESTAMP NOT NULL default now()
);