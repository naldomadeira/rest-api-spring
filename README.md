![spring-api-rest](https://user-images.githubusercontent.com/1483851/111201386-77bc7380-85a1-11eb-8bc1-e97de07a52d2.png)


# Sample REST CRUD API with Java, Docker, Spring Boot, Mysql, JPA and Hibernate

**Steps to Setup**

## Components
- Java OpenJDK 15
- Insomnia
- Container Docker MySQL
- MySQL Workbench

## Dependecies
- Spring Boot
- JPA / Hibernate
- MySQL Driver

## Usage

1. Clone the application
```sh
$ https://github.com/naldomadeira/rest-api-spring.git
$ cd rest-api-spring
```
2. Create Mysql database

create database spring_database

3. Change mysql username and password as per your installation

open src/main/resources/application.properties

change spring.datasource.username and spring.datasource.password as per your mysql container or installation standard

4. Build and run the app using maven

mvn package
java -jar target/rest-api-spring-0.0.1-SNAPSHOT.jar

Alternatively, you can run the app without packaging it using -

mvn spring-boot:run

The app will start running at http://localhost:8080.

## RESTful API Server
> The following is a generic localhost configuration on port: 3000
> Note: base_url: `http://localhost:8080/api/v1`

**List of all users** - GET: base_url/users

**Create a user** - POST: base_url/users

**List a user** - GET: base_url/users/{id}

**Update a user** - PUT: base_url/users/{id}

**Delete a user** - Delete: base_url/users/{id}

## Tests
They were entirely carried out in the automated environment of insomnia. Insomnia is an extremely useful tool for testing manually or automating the testing of any REST API.

![insomnia-api-rest](https://user-images.githubusercontent.com/1483851/111201462-90c52480-85a1-11eb-82d7-42cedb758aac.PNG)
## Credits
This API was developed by Naldo Madeira

![Linkedin Badge](https://img.shields.io/badge/-LinkedIn-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/francinaldomadeira/)