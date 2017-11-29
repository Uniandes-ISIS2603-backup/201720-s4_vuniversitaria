--select * from ReglaEntity where (hospedaje_Id = 1) and (id = 1);
delete from APP.HOSPEDAJELUGARENTITY;
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

insert into UniversidadEntity (nombre,imagen) values ('Universidad Nacional de Colombia','http://s3-eu-west-1.amazonaws.com/rankia/images/valoraciones/0013/6061/nacional.jpg?1389192659');
insert into UniversidadEntity (nombre,imagen) values ('Universidad de Pamplona','https://upload.wikimedia.org/wikipedia/commons/thumb/6/6c/Escudo_Universidad_de_Pamplona.svg/1200px-Escudo_Universidad_de_Pamplona.svg.png');
insert into UniversidadEntity (nombre,imagen) values ('Universidad de Antioquia','http://portal.udea.edu.co/wps/wcm/connect/udea/3ef4bbd1-4ae7-4c87-b843-685c6f017501/logo-udea.png?MOD=AJPERES&CACHEID=ROOTWORKSPACE.Z18_L8L8H8C0LODDC0A6SSS2AD2GO4-3ef4bbd1-4ae7-4c87-b843-685c6f017501-lr.XbEn');
insert into UniversidadEntity (nombre,imagen) values ('Universidad Libre','http://www.unilibre.edu.co/cartagena/images/Logo/ulibre_ctg_h.png');
insert into UniversidadEntity (nombre,imagen) values ('Universidad de Cartagena','http://www.unicartagena.edu.co/images/identificadores/logotipo-lineal-oficial-unicartagena.png');
insert into UniversidadEntity (nombre,imagen) values ('Universidad Distrital Francisco José de Caldas','http://laud.udistrital.edu.co/sites/default/files/images/Escudo%20UD.jpg');
insert into UniversidadEntity (nombre,imagen) values ('Universidad EAN - Sede Nogal','https://upload.wikimedia.org/wikipedia/commons/e/e3/Escudo_de_la_Universidad_EAN_de_Bogot%C3%A1%2C_Colombia.jpg');
insert into UniversidadEntity (nombre,imagen) values ('Universidad Cooperativa de Colombia','http://equiposdevideoconferencias.com/wp-content/uploads/2017/08/logo-con-fondo-transparente.png');
insert into UniversidadEntity (nombre,imagen) values ('Universidad de los Andes','https://uniandes.edu.co/sites/default/files/logo-uniandes.png');
insert into UniversidadEntity (nombre,imagen) values ('Universidad Piloto de Colombia','http://www.unipiloto.edu.co/wp-content/uploads/2017/02/IMLogoHorizontalJPG.jpg');
--Consulta

insert into APP.UBICACIONENTITY (direccion, latitud, longitud) values ('Cra 45,Bógota',4.638268,-74.084003);
insert into APP.UBICACIONENTITY (direccion, latitud, longitud) values ('Cl. 5 #4-19, Pamplona, Norte de Santander',7.108983, -73.110102);
insert into APP.UBICACIONENTITY (direccion, latitud, longitud) values ('Cl. 67 #53 - 108, Medellín, Antioquia', 4.625176, -74.074887);
insert into APP.UBICACIONENTITY (direccion, latitud, longitud) values ('Cl. 8 #580, Bogotá', 4.594794, -74.075559);
insert into APP.UBICACIONENTITY (direccion, latitud, longitud) values ('Cra. 6 #36-100, Cartagena, Bolívar',10.425718, -75.549864);
insert into APP.UBICACIONENTITY (direccion, latitud, longitud) values ('Cra. 7 #40B - 53, Bogotá', 4.628266, -74.065421);
insert into APP.UBICACIONENTITY (direccion, latitud, longitud) values ('Cl. 79 #11-45, Bogotá, Cundinamarca',4.663756, -74.055060);
insert into APP.UBICACIONENTITY (direccion, latitud, longitud) values ('Cra. 14a #40A-39, Bogotá',4.631761, -74.068707);
insert into APP.UBICACIONENTITY (direccion, latitud, longitud) values ('a 1-99,, Cl. 22 #119,Bógota',4.604608, -74.065890);
insert into APP.UBICACIONENTITY (direccion, latitud, longitud) values ('Cl. 45a #9-77, Bogotá',4.632512, -74.065310);
--pruebas EstudianteEntity
insert into EstudianteEntity (cedula, nombre, nombreUsuario, contrasenia, rutaImagen) values (1, 'amilkar','amilkar', '123','http://deimageneschidas.com/wp-content/uploads/2016/04/imagenes-para-perfil-de-facebook-1.jpg');
insert into EstudianteEntity (cedula, nombre, nombreUsuario, contrasenia, rutaImagen) values (2, 'camilo','camilo', '124','https://images7.memedroid.com/images/UPLOADED43/5385438d7a708.jpeg');
insert into EstudianteEntity (cedula, nombre, nombreUsuario, contrasenia, rutaImagen) values (3, 'kelly','kelly', '125','https://s-media-cache-ak0.pinimg.com/originals/9e/61/23/9e6123e27bd3cf2f04463070220f7d7d.jpg');
insert into EstudianteEntity (cedula, nombre, nombreUsuario, contrasenia, rutaImagen) values (4, 'william','william', '126','https://k37.kn3.net/taringa/6/8/7/7/7/3/1/agushhhhh/FAD.jpg?7748');

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
values ('Sunny', 'Hoteles', 5,0,'http://02e0385.netsolhost.com/crownparadise/web/uploads/imagenes/109/p18gk5m791ja918ts1rr2193o1ic64.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Lauryn', 'Hoteles', 5,0,'http://www.gdlgo.com/wp-content/uploads/2015/03/Habitacion.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Mariette', 'Apart-Hoteles', 4,0,'https://t-ec.bstatic.com/images/hotel/max1024x768/833/83345518.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Violet', 'Apart-Hoteles', 4,0,'http://www.xochitla.org.mx/imagenes/varios/hotel-city-express-tepotzotlan.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Roseline', 'Apart-Hoteles', 4,0,'https://s-ec.bstatic.com/images/hotel/max1024x768/715/71566660.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Shelby', 'Apart-Hoteles', 3,0,'https://www.mexicanbusinessweb.mx/wp-content/uploads/2016/02/CNS.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Erwin', 'Hostales', 3,0,'https://media-cdn.tripadvisor.com/media/photo-s/04/bb/4a/0b/hospedaje-magallanes.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Robinette', 'Hostales', 5,0,'http://www.chirripo.org/wp-content/uploads/2016/05/Hospedaje-Albergue-Chirripo.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Carley', 'Hostales', 5,0,'https://images.adsttc.com/media/images/56d0/b2f0/e58e/ce01/c200/0006/large_jpg/17.jpg?1456517863');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Karine', 'Hostales', 0,0,'https://media-cdn.tripadvisor.com/media/photo-s/08/2a/65/e3/hospedaje-la-bonita.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Albie', 'Hostales', 0,0,'https://media-cdn.tripadvisor.com/media/photo-s/05/2d/53/e3/hospedaje-dimar-inn.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Bonita', 'Albergues', 1,0,'https://t-ec.bstatic.com/images/hotel/max1024x768/278/27831940.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Hospedaje 1', 'Albergues', 1,0,'http://www.guiaejecafetero.com/wp-content/uploads/photo-gallery/Alojamientos/46.CampingMonteroca/rasta-house-camping-boquia-salento3.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Hospedaje 2', 'Hostales', 2,0,'http://02e0385.netsolhost.com/crownparadise/web/uploads/imagenes/109/p18gk5m791ja918ts1rr2193o1ic64.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Hospedaje 3', 'Hostales', 5,0,'http://www.gdlgo.com/wp-content/uploads/2015/03/Habitacion.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Hospedaje 4', 'Apart-Hoteles', 3,0,'https://t-ec.bstatic.com/images/hotel/max1024x768/833/83345518.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Hospedaje 5', 'Albergues', 4,0,'http://www.xochitla.org.mx/imagenes/varios/hotel-city-express-tepotzotlan.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Hospedaje 6', 'Apart-Hoteles', 3,0,'https://t-ec.bstatic.com/images/hotel/max1024x768/833/83345518.jpg');
insert into APP.HOSPEDAJEENTITY (DESCRIPCION, TIPOARRENDAMIENTO, VALORACION, CANTIDADVOTACIONES, RUTAIMAGEN) 
values ('Hospedaje 7', 'Albergues', 0,0,'http://www.xochitla.org.mx/imagenes/varios/hotel-city-express-tepotzotlan.jpg');


-- Arrendador

insert into APP.ARRENDADORENTITY (nombreUsuario, contrasenia, id, nombre, rutaImagen) values ('a0', 'er', 3177523825303, 'Milo Pimentel', 'https://cdn3.uvnimg.com/dims4/default/1463aea/2147483647/resize/860x645%3E/quality/75/?url=https%3A%2F%2Fcdn1.uvnimg.com%2Fe9%2F83%2F55755c2844dc825c1fe2b3b8c026%2Fscreen-shot-2016-11-03-at-11.54.32%20AM.png');
insert into APP.ARRENDADORENTITY (nombreUsuario, contrasenia, id, nombre, rutaImagen) values ('a1', 'er', 968668294465, 'Bertrand Velez', 'http://i.eldiario.com.ec/fotos-manabi-ecuador/2015/12/20151211022808_a-a-tres-da-as-de-la-gran-final.jpg');
insert into APP.ARRENDADORENTITY (nombreUsuario, contrasenia, id, nombre, rutaImagen) values ('a2', 'er', 203123592715, 'Papageno Colon', 'https://pbs.twimg.com/media/CyIndfkW8AA39Rm.jpg:large');
insert into APP.ARRENDADORENTITY (nombreUsuario, contrasenia, id, nombre, rutaImagen) values ('a3', 'er', 7095082710217, 'Ermanno Jesus', 'https://s-media-cache-ak0.pinimg.com/originals/b6/ae/18/b6ae189c11a971a1af4d17c1188a73ed.jpg');
insert into APP.ARRENDADORENTITY (nombreUsuario, contrasenia, id, nombre, rutaImagen) values ('a4', 'e12', 8364709267017, 'Lennie Camacho', 'https://pmcvarietylatino.files.wordpress.com/2016/08/screen-shot-2016-08-02-at-6-07-35-pm.png');
insert into APP.ARRENDADORENTITY (nombreUsuario, contrasenia, id, nombre, rutaImagen) values ('a5', 'e21', 3026925437839, 'Maurie Buffay', 'https://media1.popsugar-assets.com/files/thumbor/MBHtesX6rzydLZ-5oMHGS28vzpQ/fit-in/1024x1024/filters:format_auto-!!-:strip_icc-!!-/2014/07/28/951/n/1922283/91c8d314f242e434_thumb_temp_cover_file20701441406582209/i/Phoebe-Buffay-Friends-GIFs.jpg');
insert into APP.ARRENDADORENTITY (nombreUsuario, contrasenia, id, nombre, rutaImagen) values ('a6', 'e21', 7687381485806, 'Monique Geller', 'https://friendv.files.wordpress.com/2013/08/monica-geller.jpg');
insert into APP.ARRENDADORENTITY (nombreUsuario, contrasenia, id, nombre, rutaImagen) values ('a7', 'e21', 3991096447077, 'Andeee Green', 'http://akns-images.eonline.com/eol_images/Entire_Site/2014111/rs_560x415-140211085529-560.jennifer-aniston-friends.ls.21114_copy.jpg');
insert into APP.ARRENDADORENTITY (nombreUsuario, contrasenia, id, nombre, rutaImagen) values ('a8', 'e21', 1163763388482, 'Maddalena Collins', 'https://i.pinimg.com/736x/28/a3/c2/28a3c249e7963ae6dd1063c2157a8735--lily-himym-lily-aldrin.jpg');
insert into APP.ARRENDADORENTITY (nombreUsuario, contrasenia, id, nombre, rutaImagen) values ('a9', 'e21', 3489848653801, 'Astrix Pena', 'https://cbsb96radio.files.wordpress.com/2015/06/gettyimages-462704428.jpg');
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



-- Reservas
insert into APP.RESERVAENTITY (id,fechaFin,fechaInicio) values (10000,'02/02/2019','03/02/2009');
insert into APP.RESERVAENTITY (id,fechaFin,fechaInicio) values (10001,'03/05/2018','03/02/2011');
insert into APP.RESERVAENTITY (id,fechaFin,fechaInicio) values (10002,'04/08/2015','03/02/2001');
insert into APP.RESERVAENTITY (id,fechaFin,fechaInicio) values (10003,'05/07/2013','03/02/2001');


-- Ligares Interes

insert into LugaresInteresEntity (name,descripcion, rutaImagen) values ('Juan Valdez',' Perfecto lugar para un cafe 100% colombiano ', 'http://www.masfranquicias.com/wp-content/uploads/2016/02/Juan_Valdez_Caf%C3%A917_Masfranquicias.jpg');
insert into LugaresInteresEntity (name,descripcion, rutaImagen) values ('Exito','almacen de todo tipo de suministros ', 'http://static.hsbnoticias.com/sites/default/files/styles/original/public/gallery/2015/03/mg-9788r.jpg?itok=khDChg30');
insert into LugaresInteresEntity (name,descripcion, rutaImagen) values ('Banco davivienda','Banco davivienda perfecto para realizar pagos,giros,etc', 'https://res.cloudinary.com/civico/image/upload/c_fit,f_auto,fl_lossy,h_1200,q_auto,w_1200/v1470935784/entity/image/file/512/000/57acb2e82f41f3703b000512.jpg');
insert into LugaresInteresEntity (name,descripcion, rutaImagen) values ('Parque la colina','centro comercial que cuenta con salas de cine, bancos, zona de comidas y diferentes almacenes de marca', 'http://pyd.com.co/wp-content/uploads/2017/08/internet-parque-colina.jpg');
insert into LugaresInteresEntity (name,descripcion, rutaImagen) values ('MacDonalds',' restaurante MacDonalds con parqueadero y auto mac', 'http://www.rchconstructores.com/wp-content/uploads/2011/08/mcdonalds01.jpg');
insert into LugaresInteresEntity (name,descripcion, rutaImagen) values ('Clinica Colina','hospital privado', 'https://imgcdn.larepublica.co/cms/2013/05/06224016/colina0507-1000.jpg');
insert into LugaresInteresEntity (name,descripcion, rutaImagen) values ('abraham lincoln','colegio privado bilingue ', 'http://locationcolombia.com/wp-content/uploads/2014/05/BOGOTA-Colegio-Abraham-Lincoln-CIELITO-LINDO-1.jpg');
insert into LugaresInteresEntity (name,descripcion, rutaImagen) values ('Petrobras','estacion de gasolina', 'http://cdn.colombia.com/sdi/2014/03/07/a4a5db94d8bc431e98b54c02ade342af.jpg');
insert into LugaresInteresEntity (name,descripcion, rutaImagen) values ('Comercial Papelera','papeleria con servicio de 24 horas', 'https://res.cloudinary.com/civico/image/upload/c_fit,f_auto,fl_lossy,h_1200,q_auto,w_1200/v1404939232/entity/image/file/022/000/53bdabdfb9dd5d74fb000022.jpg');
insert into LugaresInteresEntity (name,descripcion, rutaImagen) values ('Bogota beer company','Bar', 'http://cr00.epimg.net/radio/imagenes/2015/09/22/nacional/1442956730_087930_1442957047_noticia_normal.jpg');
insert into LugaresInteresEntity (name,descripcion, rutaImagen) values ('Subway','restaurante de sandwich', 'http://www.impulsonegocios.com/resources/original/IN_2015/-norberto20152/000subway070415.jpg');

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

--HospedajeLugar
insert into APP.HOSPEDAJELUGARENTITY (DISTANCIA, HOSPEDAJE_ID, LUGARINTERES_ID) values (9.085, 1, 1);
insert into APP.HOSPEDAJELUGARENTITY (DISTANCIA, HOSPEDAJE_ID, LUGARINTERES_ID) values (8.274, 2, 2);
insert into APP.HOSPEDAJELUGARENTITY (DISTANCIA, HOSPEDAJE_ID, LUGARINTERES_ID) values (6.6, 3, 3);
insert into APP.HOSPEDAJELUGARENTITY (DISTANCIA, HOSPEDAJE_ID, LUGARINTERES_ID) values (9.021, 4, 4);
insert into APP.HOSPEDAJELUGARENTITY (DISTANCIA, HOSPEDAJE_ID, LUGARINTERES_ID) values (6.509, 5, 5);
insert into APP.HOSPEDAJELUGARENTITY (DISTANCIA, HOSPEDAJE_ID, LUGARINTERES_ID) values (7.495, 6, 6);
insert into APP.HOSPEDAJELUGARENTITY (DISTANCIA, HOSPEDAJE_ID, LUGARINTERES_ID) values (6.118, 7, 7);
insert into APP.HOSPEDAJELUGARENTITY (DISTANCIA, HOSPEDAJE_ID, LUGARINTERES_ID) values (8.045, 8, 8);
insert into APP.HOSPEDAJELUGARENTITY (DISTANCIA, HOSPEDAJE_ID, LUGARINTERES_ID) values (9.68, 9, 9);
insert into APP.HOSPEDAJELUGARENTITY (DISTANCIA, HOSPEDAJE_ID, LUGARINTERES_ID) values (5.715, 10, 10);

-- Facturas

insert into FacturaEntity (fecha, total, iva,estapago) values ('10/5/2016', 64.81, 11.15, 1);
insert into FacturaEntity (fecha, total, iva,estapago) values ('12/23/2016', 50.81, 21.57, 0);
insert into FacturaEntity (fecha, total, iva,estapago) values ('5/20/2017', 56.99, 34.11,1);
insert into FacturaEntity (fecha, total, iva,estapago) values ('5/2/2017', 96.69, 31.06,0);
insert into FacturaEntity (fecha, total, iva,estapago) values ('12/24/2016', 13.38, 78.64,1);
insert into FacturaEntity (fecha, total, iva,estapago) values ('5/6/2017', 51.17, 48.42, 1);
insert into FacturaEntity (fecha, total, iva,estapago) values ('7/16/2017', 6.26, 63.93,1);
insert into FacturaEntity (fecha, total, iva,estapago) values ('7/15/2017', 84.58, 96.49, 0);
insert into FacturaEntity (fecha, total, iva,estapago) values ('10/16/2016', 81.67, 44.0, 1);
insert into FacturaEntity (fecha, total, iva,estapago) values ('10/22/2016', 69.23, 38.07, 0);
insert into FacturaEntity (fecha, total, iva,estapago) values ('11/9/2016', 49.36, 10.3, 1);
insert into FacturaEntity (fecha, total, iva,estapago) values ('11/24/2016', 73.03, 71.63, 0);
insert into FacturaEntity (fecha, total, iva,estapago) values ('1/25/2017', 2.79, 53.55, 1);
insert into FacturaEntity (fecha, total, iva,estapago) values ('2/24/2017', 40.74, 51.5, 0);
insert into FacturaEntity (fecha, total, iva,estapago) values ('4/23/2017', 85.23, 14.01,1);
insert into FacturaEntity (fecha, total, iva,estapago) values ('1/10/2017', 37.12, 5.26, 0);
insert into FacturaEntity (fecha, total, iva,estapago) values ('11/30/2016', 99.47, 26.8,1);
insert into FacturaEntity (fecha, total, iva,estapago) values ('2/7/2017', 81.88, 97.86,1);
insert into FacturaEntity (fecha, total, iva,estapago) values ('12/13/2016', 6.0, 42.73,1);
insert into FacturaEntity (fecha, total, iva,estapago) values ('4/21/2017', 41.4, 94.23,1);
-- Asociaciones

update HOSPEDAJEENTITY set arrendador_id = 3177523825303 where id = 1;
update HOSPEDAJEENTITY set arrendador_id = 3177523825303 where id = 2;
update HOSPEDAJEENTITY set arrendador_id = 968668294465 where id = 3;
update HOSPEDAJEENTITY set arrendador_id = 203123592715 where id = 4;
update HOSPEDAJEENTITY set arrendador_id = 7095082710217 where id = 5;
update HOSPEDAJEENTITY set arrendador_id = 8364709267017 where id = 6;
update HOSPEDAJEENTITY set arrendador_id = 3026925437839 where id = 7;
update HOSPEDAJEENTITY set arrendador_id = 7687381485806 where id = 8;
update HOSPEDAJEENTITY set arrendador_id = 3991096447077 where id = 9;
update HOSPEDAJEENTITY set arrendador_id = 3489848653801 where id = 10;
update HOSPEDAJEENTITY set arrendador_id = 1163763388482 where id = 11;
update HOSPEDAJEENTITY set arrendador_id = 1163763388482 where id = 12;

update FacturaEntity set estudiante_id = 1 where id =1;
update FacturaEntity set estudiante_id = 1 where id =2;
update FacturaEntity set estudiante_id = 1 where id =3;
update FacturaEntity set estudiante_id = 1 where id =4;
update FacturaEntity set estudiante_id = 1 where id =5;
update FacturaEntity set estudiante_id = 2 where id =6;
update FacturaEntity set estudiante_id = 2 where id =7;
update FacturaEntity set estudiante_id = 2 where id =8;
update FacturaEntity set estudiante_id = 2 where id =9;
update FacturaEntity set estudiante_id = 2 where id =10;
update FacturaEntity set estudiante_id = 3 where id =11;
update FacturaEntity set estudiante_id = 3 where id =12;
update FacturaEntity set estudiante_id = 3 where id =13;
update FacturaEntity set estudiante_id = 3 where id =14;
update FacturaEntity set estudiante_id = 3 where id =15;
update FacturaEntity set estudiante_id = 4 where id =16;
update FacturaEntity set estudiante_id = 4 where id =17;
update FacturaEntity set estudiante_id = 4 where id =18;
update FacturaEntity set estudiante_id = 4 where id =19;
update FacturaEntity set estudiante_id = 4 where id =20;

update FacturaEntity set hospedaje_id = 1 where id =1;
update FacturaEntity set hospedaje_id = 2 where id =2;
update FacturaEntity set hospedaje_id = 3 where id =3;
update FacturaEntity set hospedaje_id = 4 where id =4;
update FacturaEntity set hospedaje_id = 5 where id =5;
update FacturaEntity set hospedaje_id = 6 where id =6;
update FacturaEntity set hospedaje_id = 7 where id =7;
update FacturaEntity set hospedaje_id = 8 where id =8;
update FacturaEntity set hospedaje_id = 9 where id =9;
update FacturaEntity set hospedaje_id = 10 where id =10;
update FacturaEntity set hospedaje_id = 11 where id =11;
update FacturaEntity set hospedaje_id = 12 where id =12;
update FacturaEntity set hospedaje_id = 13 where id =13;
update FacturaEntity set hospedaje_id = 14 where id =14;
update FacturaEntity set hospedaje_id = 15 where id =15;
update FacturaEntity set hospedaje_id = 16 where id =16;
update FacturaEntity set hospedaje_id = 17 where id =17;
update FacturaEntity set hospedaje_id = 18 where id =18;
update FacturaEntity set hospedaje_id = 19 where id =19;
update FacturaEntity set hospedaje_id = 19 where id =20;

update CALIFICACIONENTITY set hospedaje_id = 1 where id = 1;
update CALIFICACIONENTITY set hospedaje_id = 1 where id = 2;
update CALIFICACIONENTITY set hospedaje_id = 2 where id = 3;
update CALIFICACIONENTITY set hospedaje_id = 3 where id = 4;
update CALIFICACIONENTITY set estudiante_id = 1 where id = 1;
update CALIFICACIONENTITY set estudiante_id = 2 where id = 4;
update CALIFICACIONENTITY set estudiante_id = 3 where id = 3;
update CALIFICACIONENTITY set estudiante_id = 4 where id = 2;

update EstudianteEntity set origen_id = 1 where id = 1;
update EstudianteEntity set origen_id = 2 where id = 2;
update EstudianteEntity set origen_id = 3 where id = 3;
update EstudianteEntity set origen_id = 4 where id = 4;

update ReservaEntity set estudiante_id = 1 where id = 10000; 
update ReservaEntity set hospedaje_id = 1 where id = 10000;
update ReservaEntity set estudiante_id = 2 where id = 10001; 
update ReservaEntity set hospedaje_id = 2 where id = 10001;
update ReservaEntity set estudiante_id = 3 where id = 10002; 
update ReservaEntity set hospedaje_id = 3 where id = 10002;
update ReservaEntity set estudiante_id = 4 where id = 10003; 
update ReservaEntity set hospedaje_id = 4 where id = 10003; 

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


update UniversidadEntity set UBICACION_ID = 1 where id = 1;
update UniversidadEntity set UBICACION_ID = 2 where id = 2;
update UniversidadEntity set UBICACION_ID = 3 where id = 3;
update UniversidadEntity set UBICACION_ID = 4 where id = 4;
update UniversidadEntity set UBICACION_ID = 5 where id = 5;
update UniversidadEntity set UBICACION_ID = 6 where id = 6;
update UniversidadEntity set UBICACION_ID = 7 where id = 7;
update UniversidadEntity set UBICACION_ID = 8 where id = 8;
update UniversidadEntity set UBICACION_ID = 9 where id = 9;
update UniversidadEntity set UBICACION_ID = 10 where id = 10;

update HOSPEDAJEENTITY set UBICACION_ID = 1 where id = 1;
update HOSPEDAJEENTITY set UBICACION_ID = 2 where id = 2;
update HOSPEDAJEENTITY set UBICACION_ID = 3 where id = 3;
update HOSPEDAJEENTITY set UBICACION_ID = 4 where id = 4;
update HOSPEDAJEENTITY set UBICACION_ID = 5 where id = 5;
update HOSPEDAJEENTITY set UBICACION_ID = 6 where id = 6;
update HOSPEDAJEENTITY set UBICACION_ID = 7 where id = 7;
update HOSPEDAJEENTITY set UBICACION_ID = 8 where id = 8;
update HOSPEDAJEENTITY set UBICACION_ID = 9 where id = 9;
update HOSPEDAJEENTITY set UBICACION_ID = 10 where id = 10;

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
