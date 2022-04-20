CREATE TYPE groupe AS ENUM ('staff', 'student', 'other');
CREATE TABLE ft_table (
id BIGSERIAL NOT NULL PRIMARY KEY,
login VARCHAR(27) NOT NULL DEFAULT ('toto'),
groupe GROUPE NOT NULL,
date_de_creation DATE NOT NULL);