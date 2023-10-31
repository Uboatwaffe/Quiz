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

## Tutorial

- https://youtu.be/qBBXBZXKi0w?si=CLcEu_FQWCAV4XAP