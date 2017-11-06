delete from REGLAENTITY;
delete from FACTURAENTITY;
delete from CALIFICACIONENTITY;
delete from ReservaEntity;
delete from ServiciosEntity;
delete from HOSPEDAJEENTITY;
delete from ARRENDADORENTITY;
delete from OrigenEntity;
delete from EstudianteEntity;
delete from LugaresInteresEntity;
delete from APP.DETALLESERVICIOENTITY;
delete from APP.DETALLERESERVAENTITY;
delete from UniversidadEntity;
delete from UBICACIONENTITY;

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
ALTER TABLE UniversidadEntity ALTER COLUMN id RESTART WITH 1;


--Universidad

insert into UniversidadEntity (nombre) values ('Ardene');
insert into UniversidadEntity (nombre) values ('Della');
insert into UniversidadEntity (nombre) values ('Fredrick');
insert into UniversidadEntity (nombre) values ('Leonora');
insert into UniversidadEntity (nombre) values ('Emiline');
insert into UniversidadEntity (nombre) values ('Marthe');
insert into UniversidadEntity (nombre) values ('Alma');
insert into UniversidadEntity (nombre) values ('Amery');
insert into UniversidadEntity (nombre) values ('Elmira');
insert into UniversidadEntity (nombre) values ('Roseann');

--pruebas EstudianteEntity
insert into EstudianteEntity (cedula, nombre) values (1, 'amilkar');
insert into EstudianteEntity (cedula, nombre) values (2, 'camilo');
insert into EstudianteEntity (cedula, nombre) values (3, 'kelly');
insert into EstudianteEntity (cedula, nombre) values (4, 'william');

--pruebas OrigenEntity
insert into OrigenEntity ( name) values ( 'bucaramanga');
insert into OrigenEntity ( name) values ( 'cali');
insert into OrigenEntity ( name) values ('bogota');
insert into OrigenEntity ( name) values ( 'ibague');

--Hopedaje

/*
http://www4.congreso.gob.pe/comisiones/1999/turismo/normas/DS12.94.HTML
*/

insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Sunny', 'Hoteles', 27,0,'http://02e0385.netsolhost.com/crownparadise/web/uploads/imagenes/109/p18gk5m791ja918ts1rr2193o1ic64.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Lauryn', 'Hoteles', 99,0,'http://www.gdlgo.com/wp-content/uploads/2015/03/Habitacion.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Mariette', 'Apart-Hoteles', 14,0,'https://t-ec.bstatic.com/images/hotel/max1024x768/833/83345518.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Violet', 'Apart-Hoteles', 44,0,'http://www.xochitla.org.mx/imagenes/varios/hotel-city-express-tepotzotlan.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Roseline', 'Apart-Hoteles', 42,0,'https://s-ec.bstatic.com/images/hotel/max1024x768/715/71566660.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Shelby', 'Apart-Hoteles', 82,0,'https://www.mexicanbusinessweb.mx/wp-content/uploads/2016/02/CNS.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Erwin', 'Hostales', 22,0,'https://media-cdn.tripadvisor.com/media/photo-s/04/bb/4a/0b/hospedaje-magallanes.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Robinette', 'Hostales', 76,0,'http://www.chirripo.org/wp-content/uploads/2016/05/Hospedaje-Albergue-Chirripo.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Carley', 'Hostales', 49,0,'https://images.adsttc.com/media/images/56d0/b2f0/e58e/ce01/c200/0006/large_jpg/17.jpg?1456517863');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Karine', 'Hostales', 4,0,'https://media-cdn.tripadvisor.com/media/photo-s/08/2a/65/e3/hospedaje-la-bonita.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Albie', 'Hostales', 35,0,'https://media-cdn.tripadvisor.com/media/photo-s/05/2d/53/e3/hospedaje-dimar-inn.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Bonita', 'Albergues', 53,0,'https://t-ec.bstatic.com/images/hotel/max1024x768/278/27831940.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Hospedaje 1', 'Albergues', 25,0,'http://www.guiaejecafetero.com/wp-content/uploads/photo-gallery/Alojamientos/46.CampingMonteroca/rasta-house-camping-boquia-salento3.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Hospedaje 2', 'Hostales', 27,0,'http://02e0385.netsolhost.com/crownparadise/web/uploads/imagenes/109/p18gk5m791ja918ts1rr2193o1ic64.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Hospedaje 3', 'Hostales', 99,0,'http://www.gdlgo.com/wp-content/uploads/2015/03/Habitacion.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Hospedaje 4', 'Apart-Hoteles', 14,0,'https://t-ec.bstatic.com/images/hotel/max1024x768/833/83345518.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Hospedaje 5', 'Albergues', 44,0,'http://www.xochitla.org.mx/imagenes/varios/hotel-city-express-tepotzotlan.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Hospedaje 6', 'Apart-Hoteles', 14,0,'https://t-ec.bstatic.com/images/hotel/max1024x768/833/83345518.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Hospedaje 7', 'Albergues', 44,0,'http://www.xochitla.org.mx/imagenes/varios/hotel-city-express-tepotzotlan.jpg');


-- Arrendador

insert into APP.ARRENDADORENTITY (id, nombre, rutaImagen) values (3177523825303, 'Milo Pimentel', 'https://cdn3.uvnimg.com/dims4/default/1463aea/2147483647/resize/860x645%3E/quality/75/?url=https%3A%2F%2Fcdn1.uvnimg.com%2Fe9%2F83%2F55755c2844dc825c1fe2b3b8c026%2Fscreen-shot-2016-11-03-at-11.54.32%20AM.png');
insert into APP.ARRENDADORENTITY (id, nombre, rutaImagen) values (968668294465, 'Bertrand Velez', 'http://i.eldiario.com.ec/fotos-manabi-ecuador/2015/12/20151211022808_a-a-tres-da-as-de-la-gran-final.jpg');
insert into APP.ARRENDADORENTITY (id, nombre, rutaImagen) values (203123592715, 'Papageno Colon', 'https://pbs.twimg.com/media/CyIndfkW8AA39Rm.jpg:large');
insert into APP.ARRENDADORENTITY (id, nombre, rutaImagen) values (7095082710217, 'Ermanno Jesus', 'https://s-media-cache-ak0.pinimg.com/originals/b6/ae/18/b6ae189c11a971a1af4d17c1188a73ed.jpg');
insert into APP.ARRENDADORENTITY (id, nombre, rutaImagen) values (8364709267017, 'Lennie Camacho', 'https://pmcvarietylatino.files.wordpress.com/2016/08/screen-shot-2016-08-02-at-6-07-35-pm.png');
insert into APP.ARRENDADORENTITY (id, nombre, rutaImagen) values (3026925437839, 'Maurie Buffay', 'https://media1.popsugar-assets.com/files/thumbor/MBHtesX6rzydLZ-5oMHGS28vzpQ/fit-in/1024x1024/filters:format_auto-!!-:strip_icc-!!-/2014/07/28/951/n/1922283/91c8d314f242e434_thumb_temp_cover_file20701441406582209/i/Phoebe-Buffay-Friends-GIFs.jpg');
insert into APP.ARRENDADORENTITY (id, nombre, rutaImagen) values (7687381485806, 'Monique Geller', 'https://friendv.files.wordpress.com/2013/08/monica-geller.jpg');
insert into APP.ARRENDADORENTITY (id, nombre, rutaImagen) values (3991096447077, 'Andeee Green', 'http://akns-images.eonline.com/eol_images/Entire_Site/2014111/rs_560x415-140211085529-560.jennifer-aniston-friends.ls.21114_copy.jpg');
insert into APP.ARRENDADORENTITY (id, nombre, rutaImagen) values (1163763388482, 'Maddalena Collins', 'https://i.pinimg.com/736x/28/a3/c2/28a3c249e7963ae6dd1063c2157a8735--lily-himym-lily-aldrin.jpg');
insert into APP.ARRENDADORENTITY (id, nombre, rutaImagen) values (3489848653801, 'Astrix Pena', 'https://cbsb96radio.files.wordpress.com/2015/06/gettyimages-462704428.jpg');

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

insert into LugaresInteresEntity (descripcion, distancia, rutaImagen) values ('Juan Valdez: Perfecto lugar para un cafe 100% colombiano ', 8, 'http://www.masfranquicias.com/wp-content/uploads/2016/02/Juan_Valdez_Caf%C3%A917_Masfranquicias.jpg');
insert into LugaresInteresEntity (descripcion, distancia, rutaImagen) values ('Exito: almacen de todo tipo de suministros ', 97, 'http://static.hsbnoticias.com/sites/default/files/styles/original/public/gallery/2015/03/mg-9788r.jpg?itok=khDChg30');
insert into LugaresInteresEntity (descripcion, distancia, rutaImagen) values ('Banco davivienda: Banco davivienda perfecto para realizar pagos,giros,etc', 25, 'https://res.cloudinary.com/civico/image/upload/c_fit,f_auto,fl_lossy,h_1200,q_auto,w_1200/v1470935784/entity/image/file/512/000/57acb2e82f41f3703b000512.jpg');
insert into LugaresInteresEntity (descripcion, distancia, rutaImagen) values ('Parque la colina: centro comercial que cuenta con salas de cine, bancos, zona de comidas y diferentes almacenes de marca', 62, 'http://pyd.com.co/wp-content/uploads/2017/08/internet-parque-colina.jpg');
insert into LugaresInteresEntity (descripcion, distancia, rutaImagen) values ('MacDonalds: restaurante MacDonalds con parqueadero y auto mac', 30, 'http://www.rchconstructores.com/wp-content/uploads/2011/08/mcdonalds01.jpg');
insert into LugaresInteresEntity (descripcion, distancia, rutaImagen) values ('Clinica Colina', 67, 'https://imgcdn.larepublica.co/cms/2013/05/06224016/colina0507-1000.jpg');
insert into LugaresInteresEntity (descripcion, distancia, rutaImagen) values ('abraham lincoln : colegio privado bilingue ', 17, 'http://locationcolombia.com/wp-content/uploads/2014/05/BOGOTA-Colegio-Abraham-Lincoln-CIELITO-LINDO-1.jpg');
insert into LugaresInteresEntity (descripcion, distancia, rutaImagen) values ('Petrobras: estacion de gasolina', 89, 'http://cdn.colombia.com/sdi/2014/03/07/a4a5db94d8bc431e98b54c02ade342af.jpg');
insert into LugaresInteresEntity (descripcion, distancia, rutaImagen) values ('Comercial Papelera: papeleria con servicio de 24 horas', 77, 'https://res.cloudinary.com/civico/image/upload/c_fit,f_auto,fl_lossy,h_1200,q_auto,w_1200/v1404939232/entity/image/file/022/000/53bdabdfb9dd5d74fb000022.jpg');
insert into LugaresInteresEntity (descripcion, distancia, rutaImagen) values ('Bogota beer company', 74, 'http://cr00.epimg.net/radio/imagenes/2015/09/22/nacional/1442956730_087930_1442957047_noticia_normal.jpg');
insert into LugaresInteresEntity (descripcion, distancia, rutaImagen) values ('Subway', 28, 'http://www.impulsonegocios.com/resources/original/IN_2015/-norberto20152/000subway070415.jpg');

-- Reglas
insert into REGLAENTITY (regla,hospedaje_id) values ('Se pohiben las mascotas',1);
insert into REGLAENTITY (regla,hospedaje_id) values ('Se prohibe escuchar musica con un volumen muy alto',1);
insert into REGLAENTITY (regla,hospedaje_id) values ('Se prohiben las mascotas',2);
insert into REGLAENTITY (regla,hospedaje_id) values ('Cerrar las puedtas de los cuartos con llve',3);
insert into REGLAENTITY (regla,hospedaje_id) values ('No se responde si se le roban la bicicletas',1);
insert into REGLAENTITY (regla,hospedaje_id) values ('La puerta se cierra a las 17:00',1);
insert into REGLAENTITY (regla,hospedaje_id) values ('So se puede dajar al bebe llorar por más de 20 minutos',2);
insert into REGLAENTITY (regla,hospedaje_id) values ('No se le pueden hechar lor perros a las celadoras lindas',2);
insert into REGLAENTITY (regla,hospedaje_id) values ('Se pohiben las mascotas',1);
insert into REGLAENTITY (regla,hospedaje_id) values ('No se aceptan niños',3);

-- Asociaciones

update HOSPEDAJEENTITY set arrendador_id = 3177523825303 where id = 1;
update HOSPEDAJEENTITY set arrendador_id = 3177523825303 where id = 2;
update HOSPEDAJEENTITY set arrendador_id = 3177523825303 where id = 3;
update CALIFICACIONENTITY set hospedaje_id = 1 where id = 1;
update CALIFICACIONENTITY set hospedaje_id = 1 where id = 2;
update CALIFICACIONENTITY set hospedaje_id = 2 where id = 3;
update CALIFICACIONENTITY set hospedaje_id = 3 where id = 4;


update ServiciosEntity set hospedaje_id =1 where id =1;
update ServiciosEntity set hospedaje_id =2 where id =2;
update ServiciosEntity set hospedaje_id =3 where id =3;
update ServiciosEntity set hospedaje_id =4 where id =4;
update ServiciosEntity set hospedaje_id =5 where id =5;
update ServiciosEntity set hospedaje_id =6 where id =6;
update ServiciosEntity set hospedaje_id =7 where id =7;
update ServiciosEntity set hospedaje_id =8 where id =8;
update ServiciosEntity set hospedaje_id =9 where id =9;
update ServiciosEntity set hospedaje_id =10 where id =10;
update ServiciosEntity set hospedaje_id =11 where id =11;
update ServiciosEntity set hospedaje_id =12 where id =12;
update ServiciosEntity set hospedaje_id =13 where id =13;
update ServiciosEntity set hospedaje_id =14 where id =14;
update ServiciosEntity set hospedaje_id =15 where id =15;
update ServiciosEntity set hospedaje_id =16 where id =16;
update ServiciosEntity set hospedaje_id =17 where id =17;
update ServiciosEntity set hospedaje_id =18 where id =18;
update ServiciosEntity set hospedaje_id =19 where id =19;
update ServiciosEntity set hospedaje_id =19 where id =20;


update UniversidadEntity set UBICACION_ID = 7 where id = 1;
update UniversidadEntity set UBICACION_ID = 8 where id = 2;
update UniversidadEntity set UBICACION_ID = 9 where id = 3;
update UniversidadEntity set UBICACION_ID = 10 where id = 4;
update UniversidadEntity set UBICACION_ID = 11 where id = 5;
update UniversidadEntity set UBICACION_ID = 12 where id = 6;

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
select * from UniversidadEntity;
