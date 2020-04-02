create table tipoUsuario(
	id int,
	tipo VARCHAR(30));


create table usuario(
	id int,
	nombre VARCHAR(120),
	correo VARCHAR(120),
	tipoUsuario int);
	
ALTER TABLE tipousuario 
ADD CONSTRAINT PK_tipoUsuario
PRIMARY KEY (id);

ALTER TABLE usuario 
ADD CONSTRAINT PK_Usuario
PRIMARY KEY (id);