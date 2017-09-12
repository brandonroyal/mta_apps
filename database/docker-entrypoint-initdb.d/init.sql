CREATE DATABASE IF NOT EXISTS atsea;

ALTER DATABASE atsea
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

USE atsea;

CREATE TABLE appinfo
(
  label varchar(255) UNIQUE PRIMARY KEY,
  value varchar(1000)
);

INSERT INTO appinfo VALUES ('App Framework', 'Spring Boot');
INSERT INTO appinfo VALUES ('App Framework Version', '1.5.6');
INSERT INTO appinfo VALUES ('DB', 'MySql');
INSERT INTO appinfo VALUES ('DB Version', '8.0');
INSERT INTO appinfo VALUES ('Maintained By', 'Docker Customer Success');