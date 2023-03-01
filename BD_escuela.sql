create table t_alumnos (
	id_t_usuarios serial,
	nombre varchar (80),
	ap_paterno varchar(80),
	ap_materno varchar(80),
	activo int default (1),
	primary key (id_t_usuarios)
) ;

insert into t_alumnos(nombre,ap_paterno,ap_materno,activo) values ('John','Dow','Down',1);
select * from t_alumnos;

create table t_materias (
	id_t_materias serial,
	nombre varchar(80),
	activo int default(1),
	primary key (id_t_materias)
);

insert into t_materias(nombre,activo) values ('matematicas',1); 
insert into t_materias(nombre,activo) values ('programacion I',1); 
insert into t_materias(nombre,activo) values ('ingenieria de sofware',1);

select * from t_materias;


create table t_calificaciones (
	id_t_calificaciones serial,
	id_t_materias int not null,
	id_t_usuarios int not null,
	calificacion decimal (10,2),
	fecha_registro date,
	primary key (id_t_calificaciones),
	foreign key (id_t_materias) references t_materias (id_t_materias),
	foreign key (id_t_materias) references t_materias (id_t_materias) 
);

insert into t_calificaciones(id_t_materias,id_t_usuarios, calificacion, fecha_registro)
values (2,1,9,now());

