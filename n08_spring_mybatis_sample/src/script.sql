CREATE TABLE MYSAWON
( NUM INTEGER PRIMARY KEY
, ID VARCHAR2(500)
, PWD VARCHAR2(500)
, NAME VARCHAR2(500)
, AGE INTEGER
, HIREDATE DATE
);

CREATE SEQUENCE MYSAWON_SEQ;

DROP TABLE MYSAWON PURGE;

DROP SEQUENCE MYSAWON_SEQ;