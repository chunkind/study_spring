DROP TABLE USERS PURGE;

CREATE TABLE USERS
( USER_ID VARCHAR2(500)
, USER_NAME VARCHAR2(500)
, PASSWORD VARCHAR2(500)
, GRADE INTEGER
, AGE INTEGER
, REG_DATE DATE
);