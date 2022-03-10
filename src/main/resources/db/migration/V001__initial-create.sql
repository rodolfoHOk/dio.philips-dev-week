CREATE TABLE regiao (id INT auto_increment PRIMARY KEY, regiao varchar(20), qtd_exames int );
CREATE TABLE faixa_etaria (id INT auto_increment PRIMARY KEY, faixa_i int, faixa_n int, descricao varchar (50));
CREATE TABLE incidencia_exame (id INT auto_increment PRIMARY KEY, regiao_id int, mes int, faixa_id int, qtd_exames int);

Alter table incidencia_exame add constraint fk_incidencia_exame foreign key (regiao_id) references regiao (id);
Alter table incidencia_exame add constraint fk_faixa_etaria foreign key (faixa_id) references faixa_etaria (id);