
USE CANIBAU;

-- LAST UPDATE:

-- AGGIUNTE NUOVE TUPLE




-- CREDIT CARDS

INSERT INTO CREDIT_CARDS VALUES ('5311234567899811', 'RICCARDO', 'GIURA', '2018-10-31','111', 100);
INSERT INTO CREDIT_CARDS VALUES ('5311234567650022', 'GIANNI', 'NORVEGESE', '2022-06-30','589', 20000);
INSERT INTO CREDIT_CARDS VALUES ('5311555566667777', 'FILIPPO', 'ALFIERI', '2023-02-28', '608', 10000);
INSERT INTO CREDIT_CARDS VALUES ('5311234567654321', 'GIOVANNI', 'MUCIACCIA', '2023-06-30', '609', 0);
INSERT INTO CREDIT_CARDS VALUES ('5311222233334444', 'MARCO', 'CARTA', '2023-11-30', '699', 200);
INSERT INTO CREDIT_CARDS VALUES ('5311888899990000', 'ERICA', 'ROSSI', '2023-12-31', '009', 500);
INSERT INTO CREDIT_CARDS VALUES ('5311234567659999', 'MARIO', 'BIANCHI', '2023-10-31', '444', 2000);
INSERT INTO CREDIT_CARDS VALUES ('5311234567653377', 'PETER', 'PARKER', '2021-05-31', '287', 100);
INSERT INTO CREDIT_CARDS VALUES ('5311234567651221', 'PADRE', 'DI BENEDETTO', '2017-07-31', '231', 1000);
INSERT INTO CREDIT_CARDS VALUES ('5311234567654936', 'DONALD', 'TRUMP', '2024-12-31', '499', 100000000);
INSERT INTO CREDIT_CARDS VALUES ('5311234567657100', 'TOMMASO', 'CROCIERA', '2021-10-31', '044', 2000000);
INSERT INTO CREDIT_CARDS VALUES ('5311234567656081', 'SALVATORE', 'MONTALBANO', '2020-01-31', '304', 400);
INSERT INTO CREDIT_CARDS VALUES ('5311234567650133', 'SILVIO', 'BERLUSCONI', '2023-10-31', '400', 100000000);
INSERT INTO CREDIT_CARDS VALUES ('5311667788990099', 'SERGIO', 'MATTARELLA', '2021-09-30', '333', 8889009);
INSERT INTO CREDIT_CARDS VALUES ('5311332211446677', 'CARLO', 'ROLANDI', '2025-04-30', '354', 39393);
INSERT INTO CREDIT_CARDS VALUES ('5311886655778123', 'LUIGI', 'DI MAIO', '2020-08-31', '666', 4342);
INSERT INTO CREDIT_CARDS VALUES ('5311886655776520', 'FABIO', 'VERDI', '2020-08-31', '666', 4342);




-- ADDRESS

INSERT INTO ADDRESS VALUES ('RICCARDOGIURA@GMAIL.COM', 'ITALY', 'PAVIA', 'VIA ROMA', '5', '27100');
INSERT INTO ADDRESS VALUES ('GIOVANNINO0@GMAIL.COM', 'ITALY', 'ROMA', 'VIA TEVERE', '10B', '00100');
INSERT INTO ADDRESS VALUES ('GIANNINORVEGESE@GMAIL.COM', 'ITALY', 'PAVIA', 'VIALE MATTEOTTI', '33C', '27100');
INSERT INTO ADDRESS VALUES ('PETERPARKER@GMAIL.COM', 'ITALY', 'CORTEOLONA', 'VIA CAVALLOTTI', '12', '27014');
INSERT INTO ADDRESS VALUES ('MARIOBIANCHI@LIBERO.COM', 'ITALY', 'BELGIOIOSO', 'VIA MANZONI', '1', '27011');
INSERT INTO ADDRESS VALUES ('BENEDETTO00@GMAIL.COM','ITALY', 'NORCIA','CORSO MONASTERO', '11A', '13500');
INSERT INTO ADDRESS VALUES ('ERICA.ROSSI@GMAIL.COM', 'ITALY', 'MILANO', 'VIA CANALETTO', '101', '20019');
INSERT INTO ADDRESS VALUES ('TRUMPDNLD@GMAIL.COM', 'UNITED KINGDOM', 'LONDON', 'VIA ROMA', '5', 'E1');
INSERT INTO ADDRESS VALUES ('FILIPPO_ALFIERI@GMAIL.COM', 'UNITED STATES', 'CHICAGO', 'NORTH AVENUE', '155', '60007');
INSERT INTO ADDRESS VALUES ('TOMMASOCROCIERA@GMAIL.COM', 'UNITED STATES', 'NEW YORK', '5TH AVENUE', '12', '3444');
INSERT INTO ADDRESS VALUES ('SALVOMONTA@GMAIL.COM', 'UNITED STATES', 'CHICAGO', 'ILLINOIS ST', '503', '60007');
INSERT INTO ADDRESS VALUES ('BERLUSCA.SILVIO@GMAIL.COM', 'ITALY', 'FIRENZE', 'VIA DANTE', '14', '50100');
INSERT INTO ADDRESS VALUES ('MARCO.CARTA@GMAIL.COM', 'ITALY', 'PAVIA', 'PIAZZA MEARDI', '12', '15999');
INSERT INTO ADDRESS VALUES ('SERGIOMATTARELLA@GMAIL.COM', 'ITALY', 'ROMA', 'VIA INFAME', '90', '99990');
INSERT INTO ADDRESS VALUES ('CARLOROLANDI@GMAIL.COM', 'ITALY', 'MILANO', 'VIA RUSPA','12','54321');
INSERT INTO ADDRESS VALUES ('LUIGIDIMAIO@GMAIL.COM', 'ITALY', 'ROMA', 'CORSO STELLE', '23', '12');
INSERT INTO ADDRESS VALUES ('FABIOVERDI@GMAIL.COM', 'ITALY', 'PAVIA', 'VIA FERRATA', '23', '12');


-- CUSTOMERS

INSERT INTO CUSTOMERS VALUES('RICCARDOGIURA@GMAIL.COM', 'RICCARDO', 'GIURA', 'PROGETTO123', 3334445556, '1995-04-03', '5311234567899811');
INSERT INTO CUSTOMERS VALUES('GIOVANNINO0@GMAIL.COM', 'GIOVANNI', 'MUCIACCIA', 'HEARTATTACK', 3494923123, '1960-02-01', '5311234567654321');
INSERT INTO CUSTOMERS VALUES('GIANNINORVEGESE@GMAIL.COM', 'GIANNI', 'NORVEGESE', 'CHIMIAIUTA', 3321213435, '1921-06-08', '5311234567650022');
INSERT INTO CUSTOMERS VALUES('MARIOBIANCHI@LIBERO.COM', 'MARIO', 'BIANCHI', 'SUPERMARIO', 3317858334, '1912-11-30', '5311234567659999');
INSERT INTO CUSTOMERS VALUES('PETERPARKER@GMAIL.COM', 'PETER', 'PARKER', 'RAGNOUOMO', 3354324689, '1989-12-25', '5311234567653377');
INSERT INTO CUSTOMERS VALUES('BENEDETTO00@GMAIL.COM', 'BENEDETTO', 'DA NORCIA', 'ORAETLABORA', 3998877651, '1910-07-19', '5311234567651221');
INSERT INTO CUSTOMERS VALUES('TRUMPDNLD@GMAIL.COM', 'DONALD', 'TRUMP', 'MAKEAMERIKAGRTAGAIN', 3314364659, '1961-02-21', '5311234567654936');
INSERT INTO CUSTOMERS VALUES('TOMMASOCROCIERA@GMAIL.COM', 'TOMMASO', 'CROCIERA', 'MISSIONIMPOSSIBLE', 3400667216, '1959-01-12', '5311234567657100');
INSERT INTO CUSTOMERS VALUES('SALVOMONTA@GMAIL.COM', 'SALVATORE', 'MONTALBANO', 'VIGATA123', 3356750828, '1964-03-01', '5311234567656081');
INSERT INTO CUSTOMERS VALUES('BERLUSCA.SILVIO@GMAIL.COM', 'SILVIO', 'BERLUSCONI', 'CAVALIEREEE', 3235791110, '1937-05-09', '5311234567650133');

-- DOGSITTERS

INSERT INTO DOGSITTERS VALUES ('MARCO.CARTA@GMAIL.COM', 'MARCO','CARTA','PROGETTO123',3245761239, '1985-12-24', '5311222233334444', TRUE, 5, 'MI CHIAMO MARCO CARTA, DI PROFESSIONE FACCIO IL CANTANTE MA NEL TEMPO LIBERO MI PIACE FARE IL DOGISTTER. I CANI SONO INFATTI LA MIA PIù GRANDE PASSIONE DOPO LA MUSICA. MI PIACE TENERLI IN ORDINE, PORTARLI A SPASSO, FARLI GIOCARE E COCCOLARLI.');
INSERT INTO DOGSITTERS VALUES ('FILIPPO_ALFIERI@GMAIL.COM', 'FILIPPO', 'ALFIERI', 'PROVA001', 3324790136, '1993-09-20','5311555566667777', TRUE, 3, 'AMO L ELETTRONICA E IL ROCK N ROLL' );
INSERT INTO DOGSITTERS VALUES ('ERICA.ROSSI@GMAIL.COM', 'ERICA', 'ROSSI', 'SDFGHJKL12', 3412345670, '2000-01-23', '5311888899990000', FALSE , 1, 'HOLA' );
INSERT INTO DOGSITTERS VALUES ('MARIOBIANCHI@LIBERO.COM', 'MARIO', 'BIANCHI', 'SUPERMARIO', 3317858334, '1960-11-30', '5311234567659999', TRUE, 2, 'MI CHIAMO BIANCHI MA SONO TOLLERANTE VERSO TUTTE LE ETNIE');
INSERT INTO DOGSITTERS VALUES ('SERGIOMATTARELLA@GMAIL.COM', 'SERGIO', 'MATTARELLA', 'SAVONANO', 3345332111, '1930-10-02', '5311667788990099', TRUE, 2, 'NO CANI PARTICOLARMENTE AGITATI, GRAZIE.');
INSERT INTO DOGSITTERS VALUES ('CARLOROLANDI@GMAIL.COM', 'CARLO', 'ROLANDI', 'RUSPA', 3146789054, '1950-03-04', '5311332211446677', TRUE, 5, 'DOGSITTER PER PASSIONE');
INSERT INTO DOGSITTERS VALUES ('LUIGIDIMAIO@GMAIL.COM', 'LUIGI', 'DI MAIO', 'ONESTI', 3445446443, '1969-05-01', '5311886655778123', FALSE, 4, 'FRA UN DECRETO E L ALTRO MI PIAC PORTARE A SPASSO I CANI');
INSERT INTO DOGSITTERS VALUES ('FABIOVERDI@GMAIL.COM', 'FABIO', 'VERDI', 'PASSWORD', 3445446000, '1989-05-18', '5311886655776520', TRUE, 5, 'APPASSIONATO DI LABRADOR E GOLDEN RETRIEVER');


-- DOGS

INSERT INTO DOGS VALUES (1, 'FIDO', 'BULLDOG', 15.5, '2011-09-06', 'GIANNINORVEGESE@GMAIL.COM', TRUE);
INSERT INTO DOGS VALUES (2, 'PALLINA', 'PUG', 6, '2012-05-09', 'GIOVANNINO0@GMAIL.COM', TRUE);
INSERT INTO DOGS VALUES (3, 'HERMES', 'BORDER COLLIE', 20, '2013-09-10', 'RICCARDOGIURA@GMAIL.COM', TRUE);
INSERT INTO DOGS VALUES (4, 'THOR', 'GERMAN SHORTHAIRED POINTER', 30, '2014-01-15', 'RICCARDOGIURA@GMAIL.COM', TRUE);
INSERT INTO DOGS VALUES (5, 'ALFONSO', 'BIG HALF-BREED', 40, '2015-09-06', 'RICCARDOGIURA@GMAIL.COM', TRUE);
INSERT INTO DOGS VALUES (6, 'TONINO', 'COLLIE', 10.8, '2016-09-06', 'PETERPARKER@GMAIL.COM', TRUE);
INSERT INTO DOGS VALUES (7, 'PHIL', 'PAPILLON', 10.01, '2017-09-02', 'BENEDETTO00@GMAIL.COM', TRUE);
INSERT INTO DOGS VALUES (8, 'COULSON', 'ROTTWEILER', 20, '2011-09-06', 'TRUMPDNLD@GMAIL.COM', TRUE);
INSERT INTO DOGS VALUES (9, 'STEVE', 'PUG', 5, '2012-04-19', 'TOMMASOCROCIERA@GMAIL.COM', TRUE);
INSERT INTO DOGS VALUES (10, 'ROGERS', 'SIBERIAN HUSKY', 30.01, '2010-09-11', 'SALVOMONTA@GMAIL.COM', TRUE);
INSERT INTO DOGS VALUES (11, 'TONY', 'POMERANIAN', 10.06, '2017-09-05', 'BERLUSCA.SILVIO@GMAIL.COM', TRUE);
INSERT INTO DOGS VALUES (12, 'STARK', 'BULLMASTIFF', 10.01, '2004-08-18', 'BERLUSCA.SILVIO@GMAIL.COM', TRUE);

 
-- ASSIGNMENT

INSERT INTO ASSIGNMENT VALUES (1, 'RICCARDOGIURA@GMAIL.COM', 'MARCO.CARTA@GMAIL.COM', 'DELETED', '2018-07-24 19:20:00', '2018-07-25 15:20:00');
INSERT INTO ASSIGNMENT VALUES (2, 'GIOVANNINO0@GMAIL.COM', 'MARCO.CARTA@GMAIL.COM', 'CONFIRMED', '2018-03-09 09:00:00', '2018-03-11 19:00:00');
INSERT INTO ASSIGNMENT VALUES (3, 'PETERPARKER@GMAIL.COM', 'SERGIOMATTARELLA@GMAIL.COM', 'CONFIRMED', '2018-09-23 12:00:00', '2018-09-23 12:30:00');
INSERT INTO ASSIGNMENT VALUES (4, 'RICCARDOGIURA@GMAIL.COM', 'CARLOROLANDI@GMAIL.COM', 'DELETED', '2018-05-17 19:20:00', '2018-05-17 22:20:00');
INSERT INTO ASSIGNMENT VALUES (5, 'RICCARDOGIURA@GMAIL.COM', 'MARCO.CARTA@GMAIL.COM', 'CONFIRMED', '2018-06-25 19:20:00', '2018-06-25 20:20:00');
INSERT INTO ASSIGNMENT VALUES (6, 'RICCARDOGIURA@GMAIL.COM', 'MARCO.CARTA@GMAIL.COM', 'CONFIRMED', '2018-07-17 19:20:00', '2018-07-17 20:20:00');	
INSERT INTO ASSIGNMENT VALUES (7, 'RICCARDOGIURA@GMAIL.COM', 'FABIOVERDI@GMAIL.COM', 'CONFIRMED', '2018-07-16 19:20:00', '2018-07-16 20:20:00');	


-- TRANSACTIONS

INSERT INTO TRANSACTIONS VALUES ('RICCARDOGIURA@GMAIL.COM', 'MARCO.CARTA@GMAIL.COM', '2018-03-08 20:00:00', 1, 10.00);
INSERT INTO TRANSACTIONS VALUES ('GIOVANNINO0@GMAIL.COM', 'MARCO.CARTA@GMAIL.COM', '2018-03-08 20:00:00', 2, 5.00);
INSERT INTO TRANSACTIONS VALUES ('PETERPARKER@GMAIL.COM', 'SERGIOMATTARELLA@GMAIL.COM', '2018-05-29 16:00:00', 3, 15.00);
INSERT INTO TRANSACTIONS VALUES ('RICCARDOGIURA@GMAIL.COM', 'CARLOROLANDI@GMAIL.COM', '2018-05-12 20:00:00', 4, 25.00);
INSERT INTO TRANSACTIONS VALUES ('RICCARDOGIURA@GMAIL.COM', 'MARCO.CARTA@GMAIL.COM', '2018-06-25 19:21:00', 5, 6.00);
INSERT INTO TRANSACTIONS VALUES ('RICCARDOGIURA@GMAIL.COM', 'FABIOVERDI@GMAIL.COM', '2018-06-25 19:21:00', 7, 6.00);



-- DOG ASSIGNMENT

INSERT INTO DOG_ASSIGNMENT VALUES (1, 3);
INSERT INTO DOG_ASSIGNMENT VALUES (2, 2);
INSERT INTO DOG_ASSIGNMENT VALUES (3, 6);
INSERT INTO DOG_ASSIGNMENT VALUES (4, 3);
INSERT INTO DOG_ASSIGNMENT VALUES (4, 4);
INSERT INTO DOG_ASSIGNMENT VALUES (5, 3);
INSERT INTO DOG_ASSIGNMENT VALUES (6, 3);
INSERT INTO DOG_ASSIGNMENT VALUES (7, 3);


-- REVIEW

INSERT INTO REVIEW VALUES (1, '2018-07-10 20:30:26', 5, 'OTTIMO DOGSITTER, LO CONSIGLIO', 'COME DA TITOLO, MI SONO TROVATO MOLTO BENE', NULL);
INSERT INTO REVIEW VALUES (3, '2018-05-30 18:10:26', 4, 'ESEMPIO TITOLO 3 ', 'ESEMPIO DESCRIZIONE 3', 'ESEMPIO RISPOSTA 3');
INSERT INTO REVIEW VALUES (4, '2018-05-17 23:30:26', 3, 'ESEMPIO TITOLO 4 ', 'ESEMPIO DESCRIZIONE 4', 'ESEMPIO RISPOSTA 4');
INSERT INTO REVIEW VALUES (5, '2018-06-25 22:20:00', 4, 'BRAVO MA IN RITARDO ALL APPUNTAMENTO', 'AVREI PREFERITO FOSSE PUNTALE. 4 STELLE', NULL);
INSERT INTO REVIEW VALUES (7, '2018-06-25 22:20:00', 4, 'IL MIGLIOR DOGSITTER DELLA ZONA', 'VERAMENTE MOLTO BRAVO E CORDIALE. HO APPREZZATO CHE ABBIA RISPETTATO GLI ORARI DI INIZIO E FINE SENZA STORIE', 'GRAZIE MILLE, MI FA PIACERE');




-- DOGSITTER AREA
INSERT INTO DOGSITTER_AREA VALUES ('MARCO.CARTA@GMAIL.COM', 'PAVIA');
INSERT INTO DOGSITTER_AREA VALUES ('MARCO.CARTA@GMAIL.COM', 'MILANO');
INSERT INTO DOGSITTER_AREA VALUES ('MARCO.CARTA@GMAIL.COM', 'GENOVA');
INSERT INTO DOGSITTER_AREA VALUES ('MARCO.CARTA@GMAIL.COM', 'VOGHERA');
INSERT INTO DOGSITTER_AREA VALUES ('MARCO.CARTA@GMAIL.COM', 'CORTEOLONA');
INSERT INTO DOGSITTER_AREA VALUES ('MARCO.CARTA@GMAIL.COM', 'BELGIOIOSO');
INSERT INTO DOGSITTER_AREA VALUES ('MARCO.CARTA@GMAIL.COM', 'SAN MARTINO SICCOMARIO');
INSERT INTO DOGSITTER_AREA VALUES ('MARCO.CARTA@GMAIL.COM', 'BRONI');


INSERT INTO DOGSITTER_AREA VALUES ('FILIPPO_ALFIERI@GMAIL.COM', 'MILANO');
INSERT INTO DOGSITTER_AREA VALUES ('FILIPPO_ALFIERI@GMAIL.COM', 'PAVIA');
INSERT INTO DOGSITTER_AREA VALUES ('FILIPPO_ALFIERI@GMAIL.COM', 'CORTEOLONA');
INSERT INTO DOGSITTER_AREA VALUES ('FILIPPO_ALFIERI@GMAIL.COM', 'BELGIOIOSO');
INSERT INTO DOGSITTER_AREA VALUES ('FILIPPO_ALFIERI@GMAIL.COM', 'SAN MARTINO SICCOMARIO');
INSERT INTO DOGSITTER_AREA VALUES ('FILIPPO_ALFIERI@GMAIL.COM', 'VOGHERA');
INSERT INTO DOGSITTER_AREA VALUES ('FILIPPO_ALFIERI@GMAIL.COM', 'STRADELLA');
INSERT INTO DOGSITTER_AREA VALUES ('FILIPPO_ALFIERI@GMAIL.COM', 'BRONI');


INSERT INTO DOGSITTER_AREA VALUES ('MARIOBIANCHI@LIBERO.COM', 'TORINO');
INSERT INTO DOGSITTER_AREA VALUES ('MARIOBIANCHI@LIBERO.COM', 'TORTONA');
INSERT INTO DOGSITTER_AREA VALUES ('MARIOBIANCHI@LIBERO.COM', 'CORTEOLONA');
INSERT INTO DOGSITTER_AREA VALUES ('MARIOBIANCHI@LIBERO.COM', 'BELGIOIOSO');
INSERT INTO DOGSITTER_AREA VALUES ('MARIOBIANCHI@LIBERO.COM', 'SAN MARTINO SICCOMARIO');
INSERT INTO DOGSITTER_AREA VALUES ('MARIOBIANCHI@LIBERO.COM', 'VOGHERA');
INSERT INTO DOGSITTER_AREA VALUES ('MARIOBIANCHI@LIBERO.COM', 'PAVIA');
INSERT INTO DOGSITTER_AREA VALUES ('MARIOBIANCHI@LIBERO.COM', 'STRADELLA');
INSERT INTO DOGSITTER_AREA VALUES ('MARIOBIANCHI@LIBERO.COM', 'BRONI');

INSERT INTO DOGSITTER_AREA VALUES ('SERGIOMATTARELLA@GMAIL.COM', 'ROMA');

INSERT INTO DOGSITTER_AREA VALUES ('CARLOROLANDI@GMAIL.COM', 'MILANO');
INSERT INTO DOGSITTER_AREA VALUES ('CARLOROLANDI@GMAIL.COM', 'SAN MARTINO SICCOMARIO');
INSERT INTO DOGSITTER_AREA VALUES ('CARLOROLANDI@GMAIL.COM', 'BELGIOIOSO');
INSERT INTO DOGSITTER_AREA VALUES ('CARLOROLANDI@GMAIL.COM', 'VOGHERA');
INSERT INTO DOGSITTER_AREA VALUES ('CARLOROLANDI@GMAIL.COM', 'PAVIA');
INSERT INTO DOGSITTER_AREA VALUES ('CARLOROLANDI@GMAIL.COM', 'STRADELLA');
INSERT INTO DOGSITTER_AREA VALUES ('CARLOROLANDI@GMAIL.COM', 'BRONI');

INSERT INTO DOGSITTER_AREA VALUES ('LUIGIDIMAIO@GMAIL.COM', 'GENOVA');

INSERT INTO DOGSITTER_AREA VALUES ('ERICA.ROSSI@GMAIL.COM', 'BELGIOIOSO');
INSERT INTO DOGSITTER_AREA VALUES ('ERICA.ROSSI@GMAIL.COM', 'CORTEOLONA');
INSERT INTO DOGSITTER_AREA VALUES ('ERICA.ROSSI@GMAIL.COM', 'TORTONA');
INSERT INTO DOGSITTER_AREA VALUES ('ERICA.ROSSI@GMAIL.COM', 'PAVIA');
INSERT INTO DOGSITTER_AREA VALUES ('ERICA.ROSSI@GMAIL.COM', 'VOGHERA');
INSERT INTO DOGSITTER_AREA VALUES ('ERICA.ROSSI@GMAIL.COM', 'STRADELLA');
INSERT INTO DOGSITTER_AREA VALUES ('ERICA.ROSSI@GMAIL.COM', 'BRONI');

INSERT INTO DOGSITTER_AREA VALUES ('FABIOVERDI@GMAIL.COM', 'TORINO');
INSERT INTO DOGSITTER_AREA VALUES ('FABIOVERDI@GMAIL.COM', 'TORTONA');
INSERT INTO DOGSITTER_AREA VALUES ('FABIOVERDI@GMAIL.COM', 'CORTEOLONA');
INSERT INTO DOGSITTER_AREA VALUES ('FABIOVERDI@GMAIL.COM', 'BELGIOIOSO');
INSERT INTO DOGSITTER_AREA VALUES ('FABIOVERDI@GMAIL.COM', 'SAN MARTINO SICCOMARIO');
INSERT INTO DOGSITTER_AREA VALUES ('FABIOVERDI@GMAIL.COM', 'BRONI');
INSERT INTO DOGSITTER_AREA VALUES ('FABIOVERDI@GMAIL.COM', 'STRADELLA');
INSERT INTO DOGSITTER_AREA VALUES ('FABIOVERDI@GMAIL.COM', 'PAVIA');
INSERT INTO DOGSITTER_AREA VALUES ('FABIOVERDI@GMAIL.COM', 'VOGHERA');


-- DOGS_ACCEPTED
INSERT INTO DOGS_ACCEPTED VALUES ('MARCO.CARTA@GMAIL.COM', TRUE, TRUE, TRUE, TRUE);
INSERT INTO DOGS_ACCEPTED VALUES ('ERICA.ROSSI@GMAIL.COM', TRUE, FALSE, FALSE, FALSE);
INSERT INTO DOGS_ACCEPTED VALUES ('FILIPPO_ALFIERI@GMAIL.COM', TRUE, TRUE, FALSE, FALSE);
INSERT INTO DOGS_ACCEPTED VALUES ('MARIOBIANCHI@LIBERO.COM', TRUE, TRUE, TRUE, FALSE);
INSERT INTO DOGS_ACCEPTED VALUES ('CARLOROLANDI@GMAIL.COM', TRUE, TRUE, TRUE, TRUE);
INSERT INTO DOGS_ACCEPTED VALUES ('SERGIOMATTARELLA@GMAIL.COM', TRUE, TRUE, TRUE, FALSE);
INSERT INTO DOGS_ACCEPTED VALUES ('LUIGIDIMAIO@GMAIL.COM', TRUE, TRUE, TRUE, TRUE);
INSERT INTO DOGS_ACCEPTED VALUES ('FABIOVERDI@GMAIL.COM', TRUE, TRUE, TRUE, TRUE);



-- AVAILABILITY
INSERT INTO AVAILABILITY VALUES ('ERICA.ROSSI@GMAIL.COM', '00:00', '23:59', '00:00', '23:59', '14:00', '15:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO AVAILABILITY VALUES ('MARCO.CARTA@GMAIL.COM', '00:00', '23:59', '00:00', '23:59', '14:00', '15:00', '00:00', '23:59','00:00', '23:59', NULL, NULL, NULL, NULL);
INSERT INTO AVAILABILITY VALUES ('FILIPPO_ALFIERI@GMAIL.COM', NULL, NULL, '00:00', '23:59', '14:00', '15:00', '00:00', '23:59', NULL, NULL, NULL, NULL, '11:00', '18:00');
INSERT INTO AVAILABILITY VALUES ('MARIOBIANCHI@LIBERO.COM', NULL, NULL, '00:00', '23:59', '14:00', '15:00', '00:00', '23:59', '00:00', '12:00', NULL, NULL, '11:00', '18:00');
INSERT INTO AVAILABILITY VALUES ('SERGIOMATTARELLA@GMAIL.COM', '00:00', '23:59', '00:00', '23:59', '14:00', '15:00', '00:00', '23:59', '00:00', '12:00', NULL, NULL, '11:00', '18:00');
INSERT INTO AVAILABILITY VALUES ('CARLOROLANDI@GMAIL.COM', NULL, NULL, '00:00', '23:59', '14:00', '15:00', '00:00', '23:59', '00:00', '12:00', NULL, NULL, '11:00', '18:00');
INSERT INTO AVAILABILITY VALUES ('LUIGIDIMAIO@GMAIL.COM', '00.00', '23.59', '00:00', '23:59', '00:00', '23:59', '00:00', '23:59', '00:00', '23:59', '00.00', '23.59', '00:00', '23:59');
INSERT INTO AVAILABILITY VALUES ('FABIOVERDI@GMAIL.COM', '00.00', '23.59', '00:00', '23:59', '00:00', '23:59', '00:00', '23:59', '00:00', '23:59', '00.00', '23.59', '00:00', '23:59');



-- MEETING POINT
INSERT INTO MEETING_POINT VALUES (1, 'ITALY', 'PAVIA', 'VIALE MATTEOTTI', '33C', '27100');
INSERT INTO MEETING_POINT VALUES (2, 'ITALY', 'PAVIA', 'VIALE GIANNI', '12C', '27100');
INSERT INTO MEETING_POINT VALUES (3, 'ITALY', 'VIGEVANO', 'CORSO CHENNESO', '10','13333');
INSERT INTO MEETING_POINT VALUES (4, 'ITALY', 'MILANO', 'VIALE ABDUL', '10', '15299');
INSERT INTO MEETING_POINT VALUES (5, 'ITALY', 'PAVIA', 'PIAZZA DELLA VITTORIA', '1', '27100');
INSERT INTO MEETING_POINT VALUES (6, 'ITALY', 'PAVIA', 'PIAZZA DELLA VITTORIA', '1', '27100');
INSERT INTO MEETING_POINT VALUES (7, 'ITALY', 'PAVIA', 'PIAZZA DELLA VITTORIA', '1', '27100');


