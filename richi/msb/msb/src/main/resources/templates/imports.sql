INSERT INTO entityb (id, nameb) VALUES (1, 'Nombre 1');
INSERT INTO entityb (id, nameb) VALUES (2, 'Nombre 2');
INSERT INTO entityb (id, nameb) VALUES (3, 'Nombre 3');


INSERT INTO entitybentitya (id, id_entitybid, entitya_id) VALUES (1, 1, 1);
INSERT INTO entitybentitya (id, id_entitybid, entitya_id) VALUES (2, 2, 2);
INSERT INTO entitybentitya (id, id_entitybid, entitya_id) VALUES (3, 3, 3);

SELECT * FROM ENTITYA;
ID  	NOMBREA  
(no rows, 1 ms)


SELECT * FROM ENTITYB;
ID  	NAMEB  
(no rows, 1 ms)


SELECT * FROM ENTITYBENTITYA;
ID  	ID_ENTITYBID  	ENTITYA_ID  
(no rows, 1 ms)

INSERT INTO ENTITYA (ID, NOMBREA) VALUES (1, 'Nombre 1');
INSERT INTO ENTITYA (ID, NOMBREA) VALUES (2, 'Nombre 2');
INSERT INTO ENTITYA (ID, NOMBREA) VALUES (3, 'Nombre 3');
