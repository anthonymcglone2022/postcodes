What is **com.uk.postcodes**?

A RESTful API with Spring Boot, JPA, Hibernate and MySQL

=> Can be used to validate any UK Postcode (on initilization, we read in 2 million postcodes from data.sql)

=> A CRUD prototype for storing UK Postcodes (CREATE, DELETE)

**Pre-Reqs:** Create a local MySQL instance, with root user and 'toor' password (OR edit the application.properties user/ schema.sql)

**Pre-Reqs:** Install Maven 3 and Java 11

This sample project can be run on the command line with **mvn spring-boot:run** OR 
it can be imported to Spring Tool Suite (or Eclipse) and run within it.

Use Postman to add items to the 'postcode' db. An example:

POST http://localhost:9191/addPostCode
{
    "code": "W5 1AT",
    "inuse": "Yes",
    "district": "Ealing"
}
