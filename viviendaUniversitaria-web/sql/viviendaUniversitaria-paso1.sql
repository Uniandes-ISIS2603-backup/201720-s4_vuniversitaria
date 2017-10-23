
delete from REGLAENTITY;
delete from FACTURAENTITY;
delete from CALIFICACIONENTITY;
delete from UBICACIONENTITY;
delete from ReservaEntity;
delete from HOSPEDAJEENTITY;
delete from ARRENDADORENTITY;
delete from HOSPEDAJEENTITY;
delete from OrigenEntity;
delete from ServiciosEntity;
delete from EstudianteEntity;
delete from LugaresInteresEntity;
delete from APP.DETALLESERVICIOENTITY;
delete from APP.DETALLERESERVAENTITY;

ALTER TABLE APP.REGLAENTITY ALTER COLUMN id RESTART WITH 1;
ALTER TABLE APP.HOSPEDAJEENTITY ALTER COLUMN id RESTART WITH 1;
ALTER TABLE APP.CALIFICACIONENTITY ALTER COLUMN id RESTART WITH 1;
ALTER TABLE APP.UBICACIONENTITY ALTER COLUMN id RESTART WITH 1;
ALTER TABLE OrigenEntity ALTER COLUMN id RESTART WITH 1;
ALTER TABLE ServiciosEntity ALTER COLUMN id RESTART WITH 1;
ALTER TABLE FacturaEntity ALTER COLUMN id RESTART WITH 1;
ALTER TABLE ReservaEntity ALTER COLUMN id RESTART WITH 1;
ALTER TABLE LugaresInteresEntity ALTER COLUMN id RESTART WITH 1;
ALTER TABLE EstudianteEntity ALTER COLUMN id RESTART WITH 1;

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

--Servicios
insert into ServiciosEntity (descripcion, costo) values ('Marietta', 96.55);
insert into ServiciosEntity (descripcion, costo) values ('Ailsun', 67.54);
insert into ServiciosEntity (descripcion, costo) values ('Gloria', 7.48);
insert into ServiciosEntity (descripcion, costo) values ('Yance', 80.89);
insert into ServiciosEntity (descripcion, costo) values ('Nikolaus', 79.26);
insert into ServiciosEntity (descripcion, costo) values ('Deana', 80.39);
insert into ServiciosEntity (descripcion, costo) values ('Erma', 32.76);
insert into ServiciosEntity (descripcion, costo) values ('Jillene', 8.15);
insert into ServiciosEntity (descripcion, costo) values ('Myranda', 44.1);
insert into ServiciosEntity (descripcion, costo) values ('Mycah', 62.82);
insert into ServiciosEntity (descripcion, costo) values ('Wake', 90.52);
insert into ServiciosEntity (descripcion, costo) values ('Odie', 14.28);
insert into ServiciosEntity (descripcion, costo) values ('Barr', 33.41);
insert into ServiciosEntity (descripcion, costo) values ('Amabel', 62.68);
insert into ServiciosEntity (descripcion, costo) values ('Albertina', 41.72);
insert into ServiciosEntity (descripcion, costo) values ('Brunhilde', 35.91);
insert into ServiciosEntity (descripcion, costo) values ('Milly', 25.65);
insert into ServiciosEntity (descripcion, costo) values ('Corrinne', 7.73);
insert into ServiciosEntity (descripcion, costo) values ('Liza', 32.34);
insert into ServiciosEntity (descripcion, costo) values ('Berte', 27.24);

-- Facturas

insert into FacturaEntity (fecha, total, iva) values ('10/5/2016', 64.81, 11.15);
insert into FacturaEntity (fecha, total, iva) values ('12/23/2016', 50.81, 21.57);
insert into FacturaEntity (fecha, total, iva) values ('5/20/2017', 56.99, 34.11);
insert into FacturaEntity (fecha, total, iva) values ('5/2/2017', 96.69, 31.06);
insert into FacturaEntity (fecha, total, iva) values ('12/24/2016', 13.38, 78.64);
insert into FacturaEntity (fecha, total, iva) values ('5/6/2017', 51.17, 48.42);
insert into FacturaEntity (fecha, total, iva) values ('7/16/2017', 6.26, 63.93);
insert into FacturaEntity (fecha, total, iva) values ('7/15/2017', 84.58, 96.49);
insert into FacturaEntity (fecha, total, iva) values ('10/16/2016', 81.67, 44.0);
insert into FacturaEntity (fecha, total, iva) values ('10/22/2016', 69.23, 38.07);
insert into FacturaEntity (fecha, total, iva) values ('11/9/2016', 49.36, 10.3);
insert into FacturaEntity (fecha, total, iva) values ('11/24/2016', 73.03, 71.63);
insert into FacturaEntity (fecha, total, iva) values ('1/25/2017', 2.79, 53.55);
insert into FacturaEntity (fecha, total, iva) values ('2/24/2017', 40.74, 51.5);
insert into FacturaEntity (fecha, total, iva) values ('4/23/2017', 85.23, 14.01);
insert into FacturaEntity (fecha, total, iva) values ('1/10/2017', 37.12, 5.26);
insert into FacturaEntity (fecha, total, iva) values ('11/30/2016', 99.47, 26.8);
insert into FacturaEntity (fecha, total, iva) values ('2/7/2017', 81.88, 97.86);
insert into FacturaEntity (fecha, total, iva) values ('12/13/2016', 6.0, 42.73);
insert into FacturaEntity (fecha, total, iva) values ('4/21/2017', 41.4, 94.23);

-- Reservas
insert into APP.RESERVAENTITY (id,cedulaHuesped,fechaFin,fechaInicio,idHospedaje) values (1,123,'02/02/2009','03/02/2021',2);
insert into APP.RESERVAENTITY (id,cedulaHuesped,fechaFin,fechaInicio,idHospedaje) values (2,1235,'03/05/2008','03/02/2031',3);
insert into APP.RESERVAENTITY (id,cedulaHuesped,fechaFin,fechaInicio,idHospedaje) values (3,1236,'04/08/2005','03/02/2011',4);
insert into APP.RESERVAENTITY (id,cedulaHuesped,fechaFin,fechaInicio,idHospedaje) values (4,1234,'05/07/2003','03/02/2020',5);


-- Ligares Interes

insert into LugaresInteresEntity (descripcion, distancia, rutaImagen) values ('Ipsum.ppt', 8, 'http://dummyimage.com/140x242.png/5fa2dd/ffffff');
insert into LugaresInteresEntity (descripcion, distancia, rutaImagen) values ('VelNullaEget.doc', 97, 'http://dummyimage.com/119x181.png/ff4444/ffffff');
insert into LugaresInteresEntity (descripcion, distancia, rutaImagen) values ('NonMattisPulvinar.jpeg', 25, 'http://dummyimage.com/188x148.png/dddddd/000000');
insert into LugaresInteresEntity (descripcion, distancia, rutaImagen) values ('UltricesPhasellus.tiff', 62, 'http://dummyimage.com/137x224.bmp/ff4444/ffffff');
insert into LugaresInteresEntity (descripcion, distancia, rutaImagen) values ('AmetSem.pdf', 30, 'http://dummyimage.com/210x235.png/cc0000/ffffff');
insert into LugaresInteresEntity (descripcion, distancia, rutaImagen) values ('UltricesPosuereCubilia.gif', 67, 'http://dummyimage.com/217x181.jpg/ff4444/ffffff');
insert into LugaresInteresEntity (descripcion, distancia, rutaImagen) values ('VitaeNisiNam.xls', 17, 'http://dummyimage.com/118x175.png/ff4444/ffffff');
insert into LugaresInteresEntity (descripcion, distancia, rutaImagen) values ('IdPretiumIaculis.mp3', 89, 'http://dummyimage.com/245x230.bmp/cc0000/ffffff');
insert into LugaresInteresEntity (descripcion, distancia, rutaImagen) values ('Integer.avi', 77, 'http://dummyimage.com/141x107.bmp/ff4444/ffffff');
insert into LugaresInteresEntity (descripcion, distancia, rutaImagen) values ('PretiumIaculis.ppt', 74, 'http://dummyimage.com/133x226.bmp/dddddd/000000');
insert into LugaresInteresEntity (descripcion, distancia, rutaImagen) values ('Aenean.avi', 28, 'http://dummyimage.com/148x138.jpg/5fa2dd/ffffff');



-- Asociaciones

update HOSPEDAJEENTITY set arrendador_id = 3177523825303 where id = 1;
update HOSPEDAJEENTITY set arrendador_id = 3177523825303 where id = 2;
update HOSPEDAJEENTITY set arrendador_id = 3177523825303 where id = 3;
update CALIFICACIONENTITY set hospedaje_id = 1 where id = 1;
update CALIFICACIONENTITY set hospedaje_id = 1 where id = 2;
update CALIFICACIONENTITY set hospedaje_id = 2 where id = 3;
update CALIFICACIONENTITY set hospedaje_id = 3 where id = 4;

update UBICACIONENTITY set hospedaje_id = 1 where id = 1;
update UBICACIONENTITY set hospedaje_id = 2 where id = 2;
update UBICACIONENTITY set hospedaje_id = 3 where id = 3;



update UBICACIONENTITY set lugaresInteres_id = 1 where id = 3;
update UBICACIONENTITY set lugaresInteres_id = 2 where id = 3;
update UBICACIONENTITY set lugaresInteres_id = 3 where id = 3;
update UBICACIONENTITY set lugaresInteres_id = 4 where id = 3;
update UBICACIONENTITY set lugaresInteres_id = 5 where id = 3;
update UBICACIONENTITY set lugaresInteres_id = 6 where id = 3;
update UBICACIONENTITY set lugaresInteres_id = 7 where id = 3;
update UBICACIONENTITY set lugaresInteres_id = 8 where id = 3;
update UBICACIONENTITY set lugaresInteres_id = 9 where id = 3;
update UBICACIONENTITY set lugaresInteres_id = 10 where id = 3;




select * from APP.HospedajeEntity;
select * from APP.ARRENDADORENTITY;
select * from APP.CALIFICACIONENTITY ;
select * from APP.UBICACIONENTITY;
select * from APP.REGLAENTITY;
select * from EstudianteEntity;
select * from OrigenEntity;
select * from ServiciosEntity;
select * from FacturaEntity;
select * from ReservaEntity;
select * from LugaresInteresEntity;




