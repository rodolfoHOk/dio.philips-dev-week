# Projeto BackEnd da Philips Dev Week

Projeto do BackEnd desenvolvido durante o evento Philips Dev Week promovido pela Philips e pela DIO

Período: 08-03-2022 a 11-03-2022

## Tecnologias do BackEnd

- Linguagem : Java

- FrameWork : Spring Boot

- Arquitetura : Rest API

- Banco de Dados : MySQL

## Implementações além do apresentado no evento

- Flyway : DB Migration

- Docker : Banco de dados MySQL

- Pequenas refatorações no código

## Docker Banco do Dados

	docker volume create mysql_vol
	
	docker run --name mysqldev -p 3306:3306 -v "mysql_vol:/var/lib/mysql" -e "MYSQL_ROOT_PASSWORD=mysqladmin" -d mysql
	
	docker exec -it mysqldev bash
	
	mysql -u root -p

## Repositorio do FrontEnd

[https://github.com/rodolfoHOk/dio.philips-dev-week-frontend](https://github.com/rodolfoHOk/dio.philips-dev-week-frontend)