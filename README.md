# What is the postcodes repository?

- A RESTful API with a database for storing UK Postcodes
- Can be used to validate any UK Postcode (**on initilization, we read in 2 million postcodes from data.sql**)
- Technology built with Spring Boot, JPA, Hibernate and MySQL

## Pre-requisites before building the project

- Create a local MySQL instance, with user **root** and password **toor** (OR edit the application.properties user/ schema.sql with your DB's credentials)
- Install Maven 3 and Java 11

## Building the project

- Run **mvn spring-boot:run** on the command line*

*the project can also be imported to Spring Tool Suite (Eclipse or other IDEs) and run within it. TESTS can be run with **mvn clean test**

## **API Usage:** 

<font size="15">**1. ADD a postcode**<font/>
```html
POST http://localhost:9191/createPostCode
{
    "code": "W5 1AT",
    "inuse": "Yes",
    "district": "Ealing"
}
```
RETURNS **201** HTTP Status<br/>
RETURNS **JSON**
```html
 {"id": 1, "code": "W5 1AT","inuse": "Yes","district": "Ealing"}
```


**2. REMOVE a postcode**

```html
POST http://localhost:9191/deletePostCode/{postcode}
```
e.g. 
```html
POST http://localhost:9191/deletePostCode/W5 1AT
```
RETURNS **200** HTTP Status<br/>
RETURNS **Integer**
```html
1 if deleted
0 if not
```


**3. UPDATE a postcode**
```html
POST http://localhost:9191/updatePostCode
{
    "code": "W5 1AT",
    "inuse": "No",
    "district": "Some district in London"
}
```
RETURNS **200** HTTP Status<br/>
RETURNS **JSON**
```html
{"id": databaseRecordId, "code": "W5 1AT","inuse": "No","district": "Some district in London"}
```

**4. CHECK if a postcode is in the database**

GET http://localhost:9191/checkViaDatabase/{postCode}

i.e. checkViaDatabase/W5 1AT

RETURNS Integer 1 if found, 0 if false


**5. CHECK if a postcode follows all the formatting rules (e.g like Q,V,X not being in the first position etc.)** 

GET http://localhost:9191/checkViaRegex/{postCode}

i.e. checkViaRegex/W5 1AT

RETURNS boolean TRUE if postcode follows all formatting rules, FALSE if not


**6. Format a post code (capitalizes, adds space between outer and inner code, removes non alphanumerics etc.)**

GET http://localhost:9191/formatPostCode/{postCode}

i.e. formatPostCode/w51at

RETURNS "W5 1AT"

i.e. formatPostCode/w/51a\*t

RETURNS "W5 1AT"
