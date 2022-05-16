CREATE SCHEMA course_schedule;

CREATE TABLE course_schedule.department (
    id      BIGINT PRIMARY KEY,
    name    VARCHAR(30)
);

CREATE TABLE course_schedule.professor (
    id      		BIGINT PRIMARY KEY,
    name    	    VARCHAR(30),
    department_id   BIGINT
);

CREATE TABLE course_schedule.course (
    id      			BIGINT PRIMARY KEY,
    name    			VARCHAR(50),
    department_id       BIGINT REFERENCES course_schedule.department(id),
    credits				SMALLINT
);

CREATE TABLE course_schedule.schedule (
    professor_id    BIGINT REFERENCES course_schedule.professor(id),
    course_id       BIGINT REFERENCES course_schedule.course(id),
    semester 		SMALLINT,
    year			SMALLINT
);

CREATE SEQUENCE course_schedule.seq_department START WITH 1;
CREATE SEQUENCE course_schedule.seq_professor START WITH 1;
CREATE SEQUENCE course_schedule.seq_course START WITH 1;
