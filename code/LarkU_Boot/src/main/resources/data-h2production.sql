
INSERT INTO COURSE (CODE,CREDITS,TITLE) VALUES 
('BKTW-101',3.0,'Introduction to BasketWeaving'),
('BOT-202',2.0,'Yet more Botany'),
('MATH-101',4.0,'Intro To Math');

INSERT INTO SCHEDULEDCLASS (STARTDATE,ENDDATE,COURSE_ID) VALUES 
('2012-10-10','2013-2-20',1),
('2012-10-10','2013-08-10',2),
('2012-10-10','2013-10-10',3);

INSERT INTO STUDENT (NAME,PHONENUMBER,STATUS) VALUES 
('Manoj-h2prod','222 333-4444','FULL_TIME'),
('Ana-h2prod','222 333-7900','PART_TIME'),
('Roberta-h2prod','383 343-5879','HIBERNATING'),
('Madhu-h2prod','383 598-8279','PART_TIME');

INSERT INTO STUDENT_SCHEDULEDCLASS (STUDENTS_ID,CLASSES_ID) VALUES 
(1,2),
(2,3);