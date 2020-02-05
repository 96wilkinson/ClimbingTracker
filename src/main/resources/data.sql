CREATE TABLE climber 
(ID INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(255),
firstname VARCHAR(255),
surname VARCHAR(255));

CREATE TABLE climbing_attempts
(ID INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
day INT(2),
month INT(2),
year INT(4),
difficulty INT(1),
time_spent INT(2));

INSERT INTO climber (username,firstname,surname) VALUES
    ('Scrappy','John', 'Gordon'),
    ('96wilkinson','Anthony','Wilkinson'),
    ('jh447','Jordan','Harry');


INSERT INTO climbing_attempts (day,month,year,difficulty,time_spent) VALUES
    (18,12,1996,3,5),
    (22,11,1997,3,5),
    (18,9,1976,3,5);
