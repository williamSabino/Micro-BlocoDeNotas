create table notas(
id bigint auto_increment,
titulo varchar(100) unique,
texto varchar(255),
usuario_id bigint not null,

primary key (id)
);