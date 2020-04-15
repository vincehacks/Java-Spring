# Alien REST API

Created by Vince Chang </br>

Spring Boot application built to deal with Aliens. This project creates a REST
API to create, read, update and delete Aliens from MySQL database using the
jdbc API.

#### Java on my Mac

- `/Library/Java/JavaVirtualMachines/<version>/Contents/Home/`

#### How to Test MySQL from terminal

- MySQL location: `/usr/local/mysql`
- From here can run the commands just outside the `bin` folder
- [MySQL from Terminal](https://dev.mysql.com/doc/refman/8.0/en/testing-server.html)

#### Troubles Encountered

1. Versions of MySQL connector was not compatible with MySQL 8

- Now both versions match
  - mysql-connector-java is running on 8.0.19
  - MySQL running on 8.0.19

2.  Connecting to the database was a challenge using the new version of connector

- [Troubleshooting DB connection](https://stackoverflow.com/questions/50382824/mysqlnontransientconnectionexception-could-not-create-connection-to-database-ser)

```java
// This is the correct way to connect
String url = "jdbc:mysql://localhost:3306/restdb?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT";
```

3. Syntax on how to use Spring Boot Annotations for REST APIs
