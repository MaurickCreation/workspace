
CREATE ROLE lalahmode LOGIN
  ENCRYPTED PASSWORD 'md58b13337d47339cfe0a99faf847ec2356'
  SUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;

-- Database: lalahmode

-- DROP DATABASE lalahmode;

CREATE DATABASE lalahmode
  WITH OWNER = lalahmode
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'French_France.1252'
       LC_CTYPE = 'French_France.1252'
       CONNECTION LIMIT = -1;