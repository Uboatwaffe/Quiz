# How to set up a Database?

## 1) Download the MySQL database

## 2) Set the password to: 'password'

## 3) Open MySQL Workbench

## 4) Create new connection with these parameters:

- #### port: '3306'
- #### username: 'root'

## 5) In this connection create 3 tables

- #### admin
- #### set1
- #### tables

### Properties of these tables:

###

### 'name of the column' ; type of data ; properties ; pre-set

### OR

### 'name of the column' ; type of data ; properties

###

### admin:

- 'login' ; varchar(40) ; NN ; Login
- 'password' ; varchar(45) ; NN ; Password
- 'user' ; varchar(45) ; PK, NN ; admin

### set1:

- 'id' ; int ; PK, NN
- 'question' ; varchar(90) ; NN
- 'answer' ; varchar(45) ; NN
- 'type' ; varchar(45) ; NN

### tables:

- 'name' ; varchar(45) ; PK, NN ; set1

## SQL

1. ``CREATE SCHEMA `quiz` ;``
2. ``CREATE TABLE `quiz`.`admin` (`login` VARCHAR(40) NOT NULL,`password` VARCHAR(45) NOT NULL,`user` VARCHAR(45) NOT NULL, PRIMARY KEY (`user`));``
3. ``CREATE TABLE `quiz`.`set1` (`id` INT NOT NULL,`question` VARCHAR(90) NOT NULL,`answer` VARCHAR(45) NOT NULL,`type` VARCHAR(45) NOT NULL, PRIMARY KEY (`id`));``
4. ``CREATE TABLE `quiz`.`tables` (`name` VARCHAR(45) NOT NULL, PRIMARY KEY (`name`));``
5. ``INSERT INTO `quiz`.`admin` (`login`, `password`, `user`) VALUES ('Login', 'Password', 'admin');``
6. ``INSERT INTO `quiz`.`tables` (`name`) VALUES ('set1');``
7. ``INSERT INTO `quiz`.`set1` (`id`, `question`, `answer`, `type`) VALUES ('1', 'True or False', 'TRUE', 't');``
8. ``INSERT INTO `quiz`.`set1` (`id`, `question`, `answer`, `type`) VALUES ('2', 'Open question', 'YES', 'o');``
9. ``INSERT INTO `quiz`.`set1` (`id`, `question`, `answer`, `type`) VALUES ('3', 'Close question', 'A', 'c');``
10. ``INSERT INTO `quiz`.`set1` (`id`, `question`, `answer`, `type`) VALUES ('4', 'Question about date', '11.11.111', 'd');``

## Tutorial

- https://youtu.be/qBBXBZXKi0w?si=CLcEu_FQWCAV4XAP