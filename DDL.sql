create schema rpg;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on rpg.* to user@'localhost';

use rpg;

create table rac_raca (
  rac_id bigint unsigned not null auto_increment,
  rac_nome varchar(20) not null,
  rac_hp int(3),
  rac_mp int(3),
  rac_ataque int(2),
  rac_defesa int(2),
  rac_agilidade int(2), 
  rac_inteligencia int(2), 
  primary key (rac_id),
  unique key uni_raca_nome (rac_nome),
);

create table cls_classe (
  cls_id bigint unsigned not null auto_increment,
  cls_nome varchar(20) not null,
  cls_hp int(3),
  cls_mp int(3),
  cls_ataque int(2),
  cls_defesa int(2),
  cls_agilidade int(2), 
  cls_inteligencia int(2), 
  primary key (cls_id),
  unique key uni_classe_nome (cls_nome),
);

create table usr_usuario (
  usr_id bigint unsigned not null auto_increment,
  usr_nome varchar(20) not null,
  usr_email varchar(100) not null,
  usr_senha varchar(100) not null,
  usr_raca varchar(40),
  usr_classe varchar(40),
  usr_hp int(3),
  usr_mp int(3),
  usr_ataque int(2),
  usr_defesa int(2),
  usr_agilidade int(2), 
  usr_inteligencia int(2), 
  primary key (usr_id),
  unique key uni_usuario_nome (usr_nome),
  unique key uni_usuario_email (usr_email)
);

create table mon_monstro (
  mon_id bigint unsigned not null auto_increment,
  mon_nome varchar(20) not null,
  mon_raca varchar(40),
  mon_hp int(3),
  mon_mp int(3),
  mon_ataque int(2),
  mon_defesa int(2),
  mon_agilidade int(2), 
  mon_inteligencia int(2), 
  primary key (mon_id),
  unique key uni_monstro_nome (mon_nome),
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
  foreign key uau_usr_fk (usr_id) references usr_usuario (usr_id) on delete restrict on update cascade,
  foreign key uau_aut_fk (aut_id) references aut_autorizacao (aut_id) on delete restrict on update cascade
);

insert into usr_usuario (usr_nome, usr_email, usr_senha)
  values ('admin', 'admin@email.com', '$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C');

insert into aut_autorizacao (aut_nome)
  value ('ROLE_ADMIN');

insert into uau_usuario_autorizacao (usr_id, aut_id)
  select usr_id, aut_id
    from usr_usuario, aut_autorizacao
    where usr_nome = 'admin'
    and aut_nome = 'ROLE_ADMIN';