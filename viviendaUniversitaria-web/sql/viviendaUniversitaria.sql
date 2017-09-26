/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  c.santacruza
 * Created: 25/09/2017
 */

delete from UbicacionEntity;
delete from UniversidadEntity;

insert into UbicacionEntity (id,direccion,latitud, altitud) values (1,'Holaa','13654', '315135');
insert into UbicacionEntity(id,direccion,latitud, altitud) values (2,'sad','213', '1232');
insert into UbicacionEntity(id,direccion,latitud, altitud) values (1,'sad','233', '1272');

insert into UniversidadEntity(id,nombre) values (1,'asdsaf',1);
insert into UniversidadEntity(id,nombre) values (2,'sd',2);
insert into UniversidadEntity(id,nombre) values (1,'holaqehace',1);

insert into UniversidadEntity_UbicacionEntity (uni_id,ubi_id ) values (1,1);
insert into UniversidadEntity_UbicacionEntity (uni_id,ubi_id ) values (1,2);
insert into UniversidadEntity_UbicacionEntity (uni_id,ubi_id ) values (2,1);
