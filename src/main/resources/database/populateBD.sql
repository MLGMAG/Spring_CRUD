CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
INSERT INTO authorities VALUES (uuid_generate_v4(),'USER');
INSERT INTO authorities VALUES (uuid_generate_v4(),'ADMIN');