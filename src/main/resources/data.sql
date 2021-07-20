insert into persons(name, last_name, address, cellphone, city_name) values ('Camilo', 'Ruiz', 'cra', '124', 'Medellin');
insert into persons(name, last_name, address, cellphone, city_name) values ('Andres', 'Escobar', 'cra', '1244', 'Envigado');
insert into persons(name, last_name, address, cellphone, city_name) values ('Luis', 'Perez', 'cra', '124', 'Medellin');
insert into persons(name, last_name, address, cellphone, city_name) values ('Pedro', 'Castro', 'cra', '1244', 'Envigado');

insert into positions(name) values ('dev');
insert into positions(name) values ('qa');

insert into employees(person_id, position_id, salary) values(1, 1, 2000);
insert into employees(person_id, position_id, salary) values(2, 1, 1000);
insert into employees(person_id, position_id, salary) values(3, 2, 1500);
insert into employees(person_id, position_id, salary) values(4, 2, 1000);

--SELECT * FROM  EMPLOYEES E JOIN PERSONS P ON (E.PERSON_ID = P.ID) JOIN POSITIONS PO ON (E.POSITION_ID = PO.ID)