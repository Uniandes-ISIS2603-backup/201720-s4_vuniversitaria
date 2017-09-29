
delete from APP.REGLAENTITY;
ALTER TABLE APP.REGLAENTITY ALTER COLUMN id RESTART WITH 1;

delete from APP.HOSPEDAJEENTITY;
ALTER TABLE APP.HOSPEDAJEENTITY ALTER COLUMN id RESTART WITH 1;

delete from APP.ARRENDADORENTITY;
ALTER TABLE APP.ARRENDADORENTITY ALTER COLUMN id RESTART WITH 1;

delete from APP.CALIFICACIONENTITY;
ALTER TABLE APP.CALIFICACIONENTITY ALTER COLUMN id RESTART WITH 1;

delete from APP.UBICACIONENTITY;
ALTER TABLE APP.UBICACIONENTITY ALTER COLUMN id RESTART WITH 1;

delete from OrigenEntity;
ALTER TABLE OrigenEntity ALTER COLUMN id RESTART WITH 1;

delete from EstudianteEntity;



--pruebas EstudianteEntity
insert into EstudianteEntity (cedula, nombre) values (123, 'amilkar');
insert into EstudianteEntity (cedula, nombre) values (1234, 'camilo');
insert into EstudianteEntity (cedula, nombre) values (1235, 'kelly');
insert into EstudianteEntity (cedula, nombre) values (1236, 'william');

--pruebas OrigenEntity
insert into OrigenEntity ( name) values ( 'bucaramanga');
insert into OrigenEntity ( name) values ( 'cali');
insert into OrigenEntity ( name) values ('bogota');
insert into OrigenEntity ( name) values ( 'ibague');

--Hopedaje

insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES) values ('Butch', 'Juggings', 29,0);
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES) values ('Hakeem', 'Caldicot', 72,0);
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES) values ('Rubi', 'McTrustrie', 29,0);
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES) values ('Sunny', 'Wince', 27,0);
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES) values ('Lauryn', 'Bontine', 99,0);
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES) values ('Kimball', 'Herreros', 54,0);
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES) values ('Mariette', 'Dufour', 14,0);
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES) values ('Violet', 'Cogley', 44,0);
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES) values ('Roseline', 'Kaley', 42,0);
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES) values ('Shelby', 'Demschke', 82,0);
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES) values ('Erwin', 'Danbi', 22,0);
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES) values ('Robinette', 'Gerholz', 76,0);
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES) values ('Carley', 'Mangeot', 49,0);
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES) values ('Karine', 'Hudspith', 4,0);
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES) values ('Albie', 'Alebrooke', 35,0);
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES) values ('Colby', 'Mickelwright', 92,0);
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES) values ('Cairistiona', 'Jasiak', 87,0);
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES) values ('Bonita', 'Earlam', 53,0);
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES) values ('Aleen', 'Gavahan', 25,0);

-- Arrendador

insert into APP.ARRENDADORENTITY (id, nombre) values (3177523825303, 'Milo');
insert into APP.ARRENDADORENTITY (id, nombre) values (7661563852634, 'Roger');
insert into APP.ARRENDADORENTITY (id, nombre) values (968668294465, 'Bertrand');
insert into APP.ARRENDADORENTITY (id, nombre) values (203123592715, 'Papageno');
insert into APP.ARRENDADORENTITY (id, nombre) values (7095082710217, 'Ermanno');
insert into APP.ARRENDADORENTITY (id, nombre) values (8364709267017, 'Lennie');
insert into APP.ARRENDADORENTITY (id, nombre) values (3026925437839, 'Maurie');
insert into APP.ARRENDADORENTITY (id, nombre) values (7687381485806, 'Monique');
insert into APP.ARRENDADORENTITY (id, nombre) values (3991096447077, 'Andeee');
insert into APP.ARRENDADORENTITY (id, nombre) values (1163763388482, 'Maddalena');
insert into APP.ARRENDADORENTITY (id, nombre) values (3489848653801, 'Astrix');
insert into APP.ARRENDADORENTITY (id, nombre) values (7387280289802, 'Daisey');
insert into APP.ARRENDADORENTITY (id, nombre) values (7654046550740, 'Dud');
insert into APP.ARRENDADORENTITY (id, nombre) values (3670417686042, 'Townie');
insert into APP.ARRENDADORENTITY (id, nombre) values (6247108163765, 'Carilyn');
insert into APP.ARRENDADORENTITY (id, nombre) values (2366712422429, 'Filip');
insert into APP.ARRENDADORENTITY (id, nombre) values (402932192995, 'Erina');
insert into APP.ARRENDADORENTITY (id, nombre) values (881600386516, 'Rozamond');
insert into APP.ARRENDADORENTITY (id, nombre) values (3022366882222, 'Anny');
insert into APP.ARRENDADORENTITY (id, nombre) values (2381665776468, 'Kerianne');
insert into APP.ARRENDADORENTITY (id, nombre) values (7763930934611, 'Eleni');

--Calificacion

insert into APP.CALIFICACIONENTITY (valoracion, fecha, comentario) values (60, '12/12/2000', 'Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus.');
insert into APP.CALIFICACIONENTITY (valoracion, fecha, comentario) values (3, '12/12/2000', 'In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.');
insert into APP.CALIFICACIONENTITY (valoracion, fecha, comentario) values (28, '12/12/2000', 'Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.');
insert into APP.CALIFICACIONENTITY (valoracion, fecha, comentario) values (51, '12/12/2000', 'Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.');
insert into APP.CALIFICACIONENTITY (valoracion, fecha, comentario) values (57, '12/12/2000', 'Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus.');
insert into APP.CALIFICACIONENTITY (valoracion, fecha, comentario) values (61, '12/12/2000', 'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.');
insert into APP.CALIFICACIONENTITY (valoracion, fecha, comentario) values (36, '12/12/2000', 'Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.');
insert into APP.CALIFICACIONENTITY (valoracion, fecha, comentario) values (46, '12/12/2000', 'Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.');
insert into APP.CALIFICACIONENTITY (valoracion, fecha, comentario) values (43, '12/12/2000', 'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.');

--Consulta

insert into APP.UBICACIONENTITY (direccion, latitud, altitud) values ('descipcion', 20,20);
insert into APP.UBICACIONENTITY (direccion, latitud, altitud) values ('Kamillah', 29, 61);
insert into APP.UBICACIONENTITY (direccion, latitud, altitud) values ('Ora', 13, 9);
insert into APP.UBICACIONENTITY (direccion, latitud, altitud) values ('Towny', 19, 71);
insert into APP.UBICACIONENTITY (direccion, latitud, altitud) values ('Batsheva', 25, 62);
insert into APP.UBICACIONENTITY (direccion, latitud, altitud) values ('Modestine', 17, 92);
insert into APP.UBICACIONENTITY (direccion, latitud, altitud) values ('Sande', 90, 11);
insert into APP.UBICACIONENTITY (direccion, latitud, altitud) values ('Willey', 10, 64);
insert into APP.UBICACIONENTITY (direccion, latitud, altitud) values ('Marijo', 85, 37);
insert into APP.UBICACIONENTITY (direccion, latitud, altitud) values ('Danette', 90, 23);
insert into APP.UBICACIONENTITY (direccion, latitud, altitud) values ('Gabriel', 59, 93);
insert into APP.UBICACIONENTITY (direccion, latitud, altitud) values ('Diarmid', 84, 80);
insert into APP.UBICACIONENTITY (direccion, latitud, altitud) values ('George', 26, 33);
insert into APP.UBICACIONENTITY (direccion, latitud, altitud) values ('Aleta', 91, 30);
insert into APP.UBICACIONENTITY (direccion, latitud, altitud) values ('Vickie', 73, 8);
insert into APP.UBICACIONENTITY (direccion, latitud, altitud) values ('Ailbert', 28, 41);
insert into APP.UBICACIONENTITY (direccion, latitud, altitud) values ('Zachery', 46, 75);
insert into APP.UBICACIONENTITY (direccion, latitud, altitud) values ('Eilis', 60, 70);
insert into APP.UBICACIONENTITY (direccion, latitud, altitud) values ('Dorelle', 86, 39);
insert into APP.UBICACIONENTITY (direccion, latitud, altitud) values ('Rhoda', 62, 3);

update HOSPEDAJEENTITY set arrendador_id = 3177523825303 where id = 1;
update HOSPEDAJEENTITY set arrendador_id = 3177523825303 where id = 2;
update HOSPEDAJEENTITY set arrendador_id = 3177523825303 where id = 3;

select * from APP.HOSPEDAJEENTITY;
select * from APP.ARRENDADORENTITY;
select * from APP.CALIFICACIONENTITY ;
select * from APP.UBICACIONENTITY;
select * from APP.REGLAENTITY;
select * from EstudianteEntity;
select * from OrigenEntity;

