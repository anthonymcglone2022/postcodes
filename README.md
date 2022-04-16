What is com.uk.postcodes?

A RESTful API with Spring Boot, JPA, Hibernate and MySQL

=> Used to validate any UK Postcode

=> A CRUD prototype for storing UK Postcodes

**Pre-Reqs:** Create a local MySQL database called 'postcode', with root user and 'toor' password

**Pre-Reqs:** Install Maven 3 and Java 11

This sample project can be run on the command line with **mvn spring-boot:run** OR 
it can be imported to Spring Tool Suite (or Eclipse) and run within it.

Use Postman to add items to the 'postcode' db. An example:

POST http://localhost:9191/addPostCode
{
    "postCode": "W5 1AT",
    "outerCode": "W5",
    "innerCode": "1AT"
}
