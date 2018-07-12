CREATE DATABASE docker_ws;
USE docker_ws;
CREATE TABLE user(id INTEGER AUTO_INCREMENT, first_name TEXT, last_name TEXT, PRIMARY KEY(id));
INSERT INTO user(first_name, last_name) VALUES("Carmelo","Riolo");
