# Demo API REST - Java - Spring Boot - MySQL

Template para desarrollar una **API REST** con **Spring Boot** + **MySQL**.\
Utilizamos la entidad **Persona** para realizar operaciones **CRUD** (Create, Read, Update, Delete) sobre una Base de Datos Relacional.

## API REST

## Tecnología

- [Java 8](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
- [IntelliJ IDEA](https://https://www.jetbrains.com/es-es/idea/)
- [Maven](https://maven.apache.org/)
- [Spring Boot](https://start.spring.io/)
- [MySQL](https://dev.mysql.com/downloads/installer/)
- [Git](http://https://git-scm.com/)
- [Postman](https://www.postman.com/downloads/)

## Environment

Comandos para configurar el ambiente en Ubuntu

```sh
## Java Install
$ sudo apt-get install default-jre
$ java -version

## MySQL Install
$ sudo apt install mysql-server
$ systemctl status mysql.service
## MySQL Create Database/Schema and Table
$ sudo mysql
$ > CREATE DATABASE demo CHARACTER SET utf8;
$ > SHOW DATABASES;
$ > CREATE TABLE demo.persona (dni INT NOT NULL AUTO_INCREMENT, nombre VARCHAR(45) NOT NULL, apellido VARCHAR(45) NOT NULL, PRIMARY KEY (dni));
$ > SHOW TABLES;
$ exit (\q)
## MySQL Change Privileges (Access Denied)
$ sudo mysql
$ > SELECT user, authentication_string, plugin, host FROM mysql.user;
$ > ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';
$ > FLUSH PRIVILEGES;
$ > SELECT user, authentication_string, plugin, host FROM mysql.user;
$ exit (\q)
## A partir de este momento no funciona el comando 'sudo mysql', 
## sino que hay que usar el comando 'mysql -u root -p' con password 'root'
```

## Run

Comandos para correr la API REST. 

Por defecto queda levantada en  [http://localhost/8080/](http://localhost/8080/)

```sh
$ nohup java -jar demo-api-java-mysql-0.0.1.jar &
```


## Base de Datos

**MySQL** Local.

Por defecto queda levantada en **jdbc:mysql://localhost:3306/**

**application-properties**\
``spring.datasource.url=jdbc:mysql://localhost:3306/demo?serverTimezone=UTC``\
``spring.datasource.username=root``\
``spring.datasource.password=root``\
``spring.jpa.show-sql=true``\
``spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect``
