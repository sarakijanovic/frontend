--INSERT SCRIPT PROJEKTNI ZADATAK 3, SARA KIJANOVIC IT 14/2018

--TEST PODACI 
INSERT INTO "smer"("id", "naziv", "oznaka")
VALUES (-100, 'test naziv', 'test oznaka');

INSERT INTO "projekat"("id", "naziv", "oznaka", "opis")
VALUES(-100, 'test', 'test','test');

INSERT INTO "grupa"("id", "oznaka", "smer")
VALUES (-100, 'test', 1); 

INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (-100, 'test', 'test', 'test', 1, 1);

select * from smer;
select * from projekat;
select * from grupa;
select * from student; 

--------------------------
--SMER PODACI 
INSERT INTO "smer"("id", "naziv", "oznaka")
VALUES (1, 'Inženjerstvo informacionih sistema', 'IT');

INSERT INTO "smer"("id", "naziv", "oznaka")
VALUES (2, 'Informacioni inženjering', 'IN');

INSERT INTO "smer"("id", "naziv", "oznaka")
VALUES (3, 'Računarstvo i automatika', 'RA');

INSERT INTO "smer"("id", "naziv", "oznaka")
VALUES (4, 'Primenjeno softversko inženjerstvo', 'PSI');

INSERT INTO "smer"("id", "naziv", "oznaka")
VALUES (5, 'Inženjerski menadžment', 'IM');

INSERT INTO "smer"("id", "naziv", "oznaka")
VALUES (6, 'Grafičko inženjerstvo i dizajn', 'GR');

INSERT INTO "smer"("id", "naziv", "oznaka")
VALUES (7, 'Arhitektura', 'AI');

--PROJEKAT PODACI 
--IT
INSERT INTO "projekat"("id", "naziv", "oznaka", "opis")
VALUES(1, 'Razvoj višeslojnih aplikacija', 'RVA2021', 'RVA projekat 2021');
--in
INSERT INTO "projekat"("id", "naziv", "oznaka", "opis")
VALUES(2, 'Android aplikacija', 'MIT2021', 'razvoj android aplikacije');
--arhitektura
INSERT INTO "projekat"("id", "naziv", "oznaka", "opis")
VALUES(3, 'Veliki studio', 'Studio21', 'Realizacija plana izgradnje Beograda na vodi');
--RA
INSERT INTO "projekat"("id", "naziv", "oznaka", "opis")
VALUES(4, 'Algoritmi i strukture podataka', 'AISP2021', 'Algoritamska rešenja');
INSERT INTO "projekat"("id", "naziv", "oznaka", "opis")
VALUES(5, 'WPF aplikacija', 'WPF2021', 'WPF aplikacija na temu registracije automobila');
--grid
INSERT INTO "projekat"("id", "naziv", "oznaka", "opis")
VALUES(6,'Grafika', 'GR2021', 'Grafička prezentacija XY kompanije');
--menadzment
INSERT INTO "projekat"("id", "naziv", "oznaka", "opis")
VALUES(7, 'Biznis plan', 'Bplan2021', 'Realizacija biznis plana za odabrani projekat');

--grupa podaci
--it
INSERT INTO "grupa"("id", "oznaka", "smer")
VALUES (1, 'IT 1', 1); 
INSERT INTO "grupa"("id", "oznaka", "smer")
VALUES (2, 'IT 2', 1); 
--ra
INSERT INTO "grupa"("id", "oznaka", "smer")
VALUES (3, 'RA 1', 3); 
INSERT INTO "grupa"("id", "oznaka", "smer")
VALUES (4, 'RA 2', 3); 

--in
INSERT INTO "grupa"("id", "oznaka", "smer")
VALUES (5, 'IN 1', 2); 
INSERT INTO "grupa"("id", "oznaka", "smer")
VALUES (6, 'IN 2', 2); 

--psi 
INSERT INTO "grupa"("id", "oznaka", "smer")
VALUES (7, 'PSI 1', 4); 
INSERT INTO "grupa"("id", "oznaka", "smer")
VALUES (8, 'PSI 2', 4); 

--im
INSERT INTO "grupa"("id", "oznaka", "smer")
VALUES (9, 'IM 1', 5); 
INSERT INTO "grupa"("id", "oznaka", "smer")
VALUES (10, 'IM 2', 5); 

--grid
INSERT INTO "grupa"("id", "oznaka", "smer")
VALUES (11, 'GR 1', 6); 
INSERT INTO "grupa"("id", "oznaka", "smer")
VALUES (12, 'GR 2', 6); 

--ARHITEKTURA
INSERT INTO "grupa"("id", "oznaka", "smer")
VALUES (13, 'AI 1', 7); 
INSERT INTO "grupa"("id", "oznaka", "smer")
VALUES (14, 'AI 2', 7); 

--STUDENT PODACI
--it
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (1, 'Sara', 'Kijanovic', 'IT14-2018', 1, 1);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (2, 'Teodora', 'Perisin', 'IT10-2018', 2, 1);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (3, 'Aleksa', 'Komosar', 'IT21-2018', 1, 2); 

INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (4, 'Lana', 'Slovic', 'PSI23-2019', 7, 5);

INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (5, 'Enes', 'Rovcanin', 'PSI59-2017', 8, 5);

INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (6, 'David', 'Kijanovic', 'AI1-2018', 14, 3);

INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (7, 'Vukasin', 'Perunicic', 'GR20-2019', 11, 6);

INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (8, 'Slavica', 'Nikolic','IM15-2016', 9, 7);

INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (9, 'Aleksandra', 'Mirkovic', 'IN1-2015', 5, 2);


select * from student 






