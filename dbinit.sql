create database spring_mvc;
use spring_mvc;

create table customer(
id int auto_increment primary key,
name varchar(255),
email varchar(255),
address varchar(255)
);

insert into customer(name,email,address) values
("Marco Rossi", "marcorossi@gmail.com", "viale Zara 30"),
("Giacomo Verdi", "giacomoverdi@gmail.com", "viale Fulvio Testi 320"),
("Anna Bianchi", "abianchi@yahoo.com", "via murat 10"),
("Maria Neri", "nmaria@gmail.com", "viale Monza 40");