CREATE TABLE manufacturers (
  id                      uuid            NOT NULL UNIQUE,
  name                    VARCHAR(255)    NOT NULL UNIQUE,

  PRIMARY KEY (id)
);

CREATE TABLE products (
  id                      uuid              NOT NULL UNIQUE,
  name                    VARCHAR(255)      NOT NULL UNIQUE,
  price                   DECIMAL(16, 2)    NOT NULL,
  manufacturer_id         uuid              NOT NULL,

  PRIMARY KEY (id),
  FOREIGN KEY (manufacturer_id) REFERENCES manufacturers (id)
);

CREATE TABLE users (
  id                      uuid            NOT NULL UNIQUE,
  first_name              VARCHAR(255)    NOT NULL,
  last_name               VARCHAR(255)    NOT NULL,
  username                VARCHAR(32)     NOT NULL UNIQUE,
  password                VARCHAR(60)     NOT NULL,
  email                   VARCHAR(255)    NOT NULL UNIQUE,

  NonExpired              boolean         NOT NULL,
  NonLocked               boolean         NOT NULL,
  CredentialsNonExpired   boolean         NOT NULL,
  Enabled                 boolean         NOT NULL,

  PRIMARY KEY (id)
);

CREATE TABLE user_authority (

id                        uuid            NOT NULL,
authority                 VARCHAR(255)    NOT NULL,

FOREIGN KEY(id) REFERENCES users(id)
);