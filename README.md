# What is the postcodes repository?

- A RESTful API with a database for storing UK Postcodes
- Can be used to validate any UK Postcode (**on initialisation, we read in 2 million postcodes from data.sql**)
- Technology built with Maven, Spring Boot, JPA, Hibernate, MySQL and Docker

## Running the project with Docker

- Install [Docker](https://docs.docker.com/)
- Navigate to the directory with the `Dockerfile` 
- Run `docker build -t java-webserver .`
- Run `docker run -d -p 9191:9191 java-webserver`

## Pre-requisites before building the project [non-Docker]

- Create a local MySQL instance, with user **root** and password **toor** (OR edit the application.properties' user & schema.sql with your DB's credentials)
- Install [Maven 3](https://maven.apache.org/index.html) and [Java](https://www.oracle.com/java/technologies/downloads/)

## Building the project [non-Docker]

- Run **mvn spring-boot:run** on the command line*

  *the project can also be imported to Spring Tool Suite (Eclipse or other IDEs) and run within it. **Tests** can be run with **mvn clean test**

## **API Usage:** 

**1. ADD a postcode**
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

---

**2. REMOVE a postcode**

```html
POST http://localhost:9191/deletePostCode/{postcode}
```
e.g. 
```html
POST http://localhost:9191/deletePostCode/W5 1AT
```
RETURNS **200** HTTP Status<br/>
RETURNS **Integer**<br/>

IF DELETED:
```html
1
```
IF NOT:
```html
0
```

---

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
{"id": 1, "code": "W5 1AT","inuse": "No","district": "Some district in London"}
```

---

**4. CHECK if a postcode is in the database**

```html
GET http://localhost:9191/checkViaDatabase/{postCode}
```
e.g. 
```html
GET http://localhost:9191/checkViaDatabase/W5 1AT
```

RETURNS **200** HTTP Status<br/>
RETURNS **Integer**<br/>

IF FOUND:
```html
1
```
IF NOT:
```html
0
```

---

**5. CHECK if a postcode follows all the formatting rules (e.g. Q,V,X not being in the first position etc.)** 

```html
GET http://localhost:9191/checkViaRegex/{postCode}
```
e.g. 
```html
GET http://localhost:9191/checkViaRegex/W5 1AT
```
RETURNS **200** HTTP Status<br/>
RETURNS **Boolean**<br/>

IF FORMATTED CORRECTLY:
```html
True
```
IF NOT:
```html
False
```

---


**6. Format a postcode (capitalizes, adds space between outer and inner code, removes non-alphanumerics etc.)**


```html
GET http://localhost:9191/formatPostCode/{postCode}
```
e.g. 
```html
GET http://localhost:9191/formatPostCode/w51*at
```
RETURNS **200** HTTP Status<br/>
RETURNS **String**<br/>
```html
W5 1AT
```
