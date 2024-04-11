create table usuarios (
id bigint auto_increment,
email varchar(255) unique,
password varchar(255),
idade bigint,
qtde_notas int,

primary key (id)
);