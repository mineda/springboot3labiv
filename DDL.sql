drop schema if exists spring;

drop user if exists 'user'@'localhost';

create schema spring;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on spring.* to user@'localhost';

use spring;

create table usr_usuario (
  usr_id bigint unsigned not null auto_increment,
  usr_nome varchar(20) not null,
  usr_senha varchar(150) not null,
  primary key (usr_id),
  unique key uni_usuario_nome (usr_nome)
);

create table aut_autorizacao (
  aut_id bigint unsigned not null auto_increment,
  aut_nome varchar(20) not null,
  primary key (aut_id),
  unique key uni_aut_nome (aut_nome)
);

create table uau_usuario_autorizacao (
  usr_id bigint unsigned not null,
  aut_id bigint unsigned not null,
  primary key (usr_id, aut_id),
  foreign key aut_usuario_fk (usr_id) references usr_usuario (usr_id) on delete restrict on update cascade,
  foreign key aut_autorizacao_fk (aut_id) references aut_autorizacao (aut_id) on delete restrict on update cascade
);

create table ant_anotacao (
  ant_id bigint unsigned not null auto_increment,
  ant_texto varchar(256) not null,
  ant_data_hora datetime not null,
  ant_usr_id bigint unsigned not null,
  primary key (ant_id),
  foreign key ant_usr_fk (ant_usr_id) references usr_usuario(usr_id)
);

create table atv_atividade (
  atv_id bigint primary key auto_increment,
  atv_enunciado varchar(100) not null,
  atv_data_hora_cadastro datetime not null,
  atv_data_hora_limite datetime not null,
  atv_peso int,
  atv_observacoes varchar(200)
);

create table dcn_dicionario (
  dcn_id bigint primary key auto_increment,
  dcn_verbete varchar(100) not null,
  dcn_significado varchar(200) not null,
  dcn_versao int,
  dcn_data_hora_cadastro datetime not null,
  dcn_data_hora_revisado datetime
);

create table cpm_compromisso (
  cpm_id bigint primary key auto_increment,
  cpm_nome varchar(100) not null,
  cpm_data_hora datetime not null,
  cpm_duracao_prevista float not null,
  cpm_cep bigint,
  cpm_numero int
);

create table jog_jogo (
  jog_id bigint primary key auto_increment,
  jog_titulo varchar(100) not null,
  jog_estudio varchar(100) not null,
  jog_data_hora_lancamento datetime not null,
  jog_classificacao varchar(3),
  jog_duracao_media float
);

insert into usr_usuario (usr_nome, usr_senha)
  values ('admin', '$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C');
insert into aut_autorizacao (aut_nome)
  values ('ROLE_ADMIN');
insert into uau_usuario_autorizacao (usr_id, aut_id) 
  values (1, 1);
insert into ant_anotacao(ant_texto, ant_data_hora, ant_usr_id)
  values('Meu novo projeto', '2023-08-01 19:10', 1);
insert into atv_atividade (atv_enunciado, atv_data_hora_cadastro, atv_data_hora_limite, atv_observacoes)
  values ('Teste 1', current_timestamp(), '2023-10-5 23:59:59', 'Entregue arquivo pdf'),
  ('Teste 2', current_timestamp(), '2023-10-12 23:59:59', 'Apresentar');
insert into dcn_dicionario (dcn_verbete, dcn_significado, dcn_data_hora_cadastro)
  values ('tupla', 'linha de uma tabela', '2023-10-01 10:00:06'),
  ('tupla', 'conjunto de atributos relacionados', current_timestamp());
insert into cpm_compromisso (cpm_nome, cpm_data_hora, cpm_duracao_prevista)
  values ('Dentista', '2023-10-5 16:00:00', 0.5);
insert into cpm_compromisso (cpm_nome, cpm_data_hora, cpm_duracao_prevista, cpm_cep, cpm_numero)
  values ('Prova', '2023-10-4 21:25:00', 1.5, 12247014, 1350);
insert into jog_jogo (jog_titulo, jog_estudio, jog_data_hora_lancamento)
  values ('God Of War', 'Santa Monica', '2005-3-22 00:00:00');
insert into jog_jogo (jog_titulo, jog_estudio, jog_data_hora_lancamento, jog_classificacao, jog_duracao_media)
  values ('Hogwarts Legacy', 'Avalanche', '2023-2-10 00:00:00', '12', 25);