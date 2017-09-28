/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  a.eslava
 * Created: 28/09/2017
 */

--pruebas EstudianteEntity
delete from EstudianteEntity;
insert into EstudianteEntity (cedula, nombre) values (123, 'amilkar');
insert into EstudianteEntity (cedula, nombre) values (1234, 'camilo');
insert into EstudianteEntity (cedula, nombre) values (1235, 'kelly');
insert into EstudianteEntity (cedula, nombre) values (1236, 'william');

--pruebas OrigenEntity
delete from OrigenEntity;
insert into OrigenEntity (id, name) values (1, 'bucaramanga');
insert into OrigenEntity (id, name) values (2, 'cali');
insert into OrigenEntity (id, name) values (3, 'bogota');
insert into OrigenEntity (id, name) values (4, 'ibague');

