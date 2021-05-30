==========================
 회원  table 생성 및 data insert
==========================

==========================
Drop Table
==========================
DROP TABLE users;


==============================
 users TABLE, CONSTRAINT CREATE   
==============================
CREATE TABLE users ( 
	user_id			VARCHAR2(7)				PRIMARY KEY,
	user_name 	VARCHAR2(15)				NOT NULL,
	password 		VARCHAR2(7)				NOT NULL,
	age 					NUMBER(3),
	reg_date DATE
);


==============================
 users TABLE INSERT   
==============================
INSERT INTO users 
VALUES('user01','홍길동','user01',10,
			  TO_DATE( '01/10/2011 01:10:11 오전', 'MM/DD/YYYY HH:MI:SS AM'));

INSERT INTO users 
VALUES('user02','이순신','user02',20,
			  TO_DATE( '02/20/2022 02:20:22 오후', 'MM/DD/YYYY HH:MI:SS AM'));

INSERT INTO users 
VALUES('user03','김유신','user03',30,
			  TO_DATE( '03/30/2033 03:30:33 오전', 'MM/DD/YYYY HH:MI:SS AM'));


==============================
 users TABLE INSERT ROW COMMIT  
==============================
COMMIT;


==============================
 users TABLE QUERY   
==============================
SELECT * FROM users;

-------------------------------------------------------------------------
DROP TABLE users purge;
CREATE TABLE users ( 
	user_id		VARCHAR2(7)	PRIMARY KEY,
	user_name 	VARCHAR2(15)	NOT NULL,
	password 	VARCHAR2(7)	NOT NULL,
	age 		NUMBER(3),
	reg_date	DATE
);

INSERT INTO users 
VALUES('user01','홍길동','user01',10,
	 TO_DATE( '01/10/2011 01:10:11 오전', 'MM/DD/YYYY HH:MI:SS AM'));

INSERT INTO users 
VALUES('user02','이순신','user02',20,
	 TO_DATE( '02/20/2022 02:20:22 오후', 'MM/DD/YYYY HH:MI:SS AM'));

INSERT INTO users 
VALUES('user03','김유신','user03',30,
	 TO_DATE( '03/30/2033 03:30:33 오전', 'MM/DD/YYYY HH:MI:SS AM'));

COMMIT;

SELECT * FROM users;

