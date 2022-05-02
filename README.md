What is **com.uk.postcodes**?

A RESTful API with Spring Boot, JPA, Hibernate and MySQL

=> Can be used to validate any UK Postcode (on initilization, we read in 2 million postcodes from data.sql)

=> A CRUD prototype for storing UK Postcodes 

**Pre-Reqs:** Create a local MySQL instance, with root user and 'toor' password (OR edit the application.properties user/ schema.sql)

**Pre-Reqs:** Install Maven 3 and Java 11

This sample project can be run on the command line with **mvn spring-boot:run** OR 
it can be imported to Spring Tool Suite (Eclipse or any IDE) and run within it. TESTS: can be run with **mvn clean test**

**API Usage:** You can use Postman to add items to the 'postcode' db.


**1 - ADD a postcode**

POST http://localhost:9191/createPostCode
{
    "code": "W5 1AT",
    "inuse": "Yes",
    "district": "Ealing"
}

RETURNS JSON {"id": generatedIntegerId, "code": "W5 1AT","inuse": "Yes","district": "Ealing"}


**2 - REMOVE a postcode**

POST http://localhost:9191/deletePostCode/{postcode}

i.e.  deletePostCode/W5 1AT

RETURNS Integer 1 if deleted, 0 if not


**3 - UPDATE a postcode**

POST http://localhost:9191/updatePostCode
{
    "code": "W5 1AT",
    "inuse": "No",
    "district": "Some district in London"
}

RETURNS JSON {"id": databaseRecordId, "code": "W5 1AT","inuse": "No","district": "Some district in London"}


**4 - CHECK if a postcode is in the database**

GET http://localhost:9191/checkViaDatabase/{postCode}

i.e. checkViaDatabase/W5 1AT

RETURNS Integer 1 if found, 0 if false


**5 - CHECK if a postcode follows all the formatting rules (e.g like Q,V,X not being in the first position etc.)** 

GET http://localhost:9191/checkViaRegex/{postCode}

i.e. checkViaRegex/W5 1AT

RETURNS boolean TRUE if postcode follows all formatting rules, FALSE if not


**6 - Format a post code (capitalizes, adds space between outer and inner code, removes non alphanumerics etc.)**

GET http://localhost:9191/formatPostCode/{postCode}

i.e. formatPostCode/w51at

RETURNS "W5 1AT"

i.e. formatPostCode/w/51a\*t

RETURNS "W5 1AT"
