CREATE TABLE secu.user (

    id SERIAL,
    username character varying NOT NULL PRIMARY KEY,
    password character varying NOT NULL,
    active boolean  NOT NULL,
    roles character varying NOT NULL
);

INSERT INTO secu.user (username,password,active,roles)
  VALUES ('john','john123',true,'ROLE_USER');