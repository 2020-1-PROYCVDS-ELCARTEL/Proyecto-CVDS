CREATE TYPE tipoUsuario AS ENUM ('Admin', 'User', 'PMO', 'Proponente');

CREATE TYPE tipoEstado AS ENUM ('En espera de revision', 'En revision', 'Proyecto', 'Solucionado');

create table usuario(
	id serial,
	nombre VARCHAR(120) not NULL,
	correo VARCHAR(120) not NULL,
	contrasena VARCHAR(20) not NULL,
	tipoUser tipoUsuario not NULL,
	dependencia VARCHAR(100));

create table iniciativa(
	id serial,
	nombre VARCHAR(120) not null,
	estado tipoEstado not null,
	numeroVotos int not null,
	descripcion VARCHAR(300) not null,
	palabrasClave VARCHAR(180) not null,
	nombreUsuario VARCHAR(120) not null,
	correoUsuario VARCHAR(120) not null,
	fecha date not null);
