DROP DATABASE IF EXISTS products_and_users;

CREATE DATABASE products_and_users;
USE products_and_users;


CREATE TABLE manufacturers (
  id   BINARY(16)   NOT NULL UNIQUE,
  name VARCHAR(255) NOT NULL UNIQUE,

  PRIMARY KEY (id)
)
  ENGINE = InnoDB;


CREATE TABLE products (
  id              BINARY(16)     NOT NULL UNIQUE,
  name            VARCHAR(255)   NOT NULL UNIQUE,
  price           DECIMAL(16, 2) NOT NULL,
  manufacturer_id BINARY(16)     NOT NULL,

  PRIMARY KEY (id),
  FOREIGN KEY (manufacturer_id) REFERENCES manufacturers (id)
)
  ENGINE = InnoDB;

CREATE TABLE users (
  id         BINARY(16)   NOT NULL UNIQUE,
  first_name VARCHAR(255) NOT NULL,
  last_name  VARCHAR(255) NOT NULL,
  username   VARCHAR(32)  NOT NULL UNIQUE,
  password   VARCHAR(60)  NOT NULL,
  email      VARCHAR(255) NOT NULL UNIQUE,

  role       VARCHAR(10)  NOT NULL,

  PRIMARY KEY (id)
)
  ENGINE = InnoDB;