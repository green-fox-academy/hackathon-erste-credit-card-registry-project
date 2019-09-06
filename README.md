# Erste Credit Card Registry

## Hackathon Project

## Team members:

* **Mariann Horvath [Mariann881018](https://github.com/Mariann881018)**
* **Tibor Foldes [foldestiborlajos](https://github.com/foldestiborlajos)**
* **Krisztian Kovacs [bensahar42](https://github.com/bensahar42)**
* **Zsolt Molnar [hulfyback](https://github.com/hulfyback)**

## Applied technologies

* *Spring Boot*
* *Gradle*
* *MySQL*
* *Flyway*
* *Jenkins*
* *CircleCI*
* *Heroku*
* *Swagger*

## Enviroment variables:

|  Variable name          |  Value                                                                                             |
|-------------------------|----------------------------------------------------------------------------------------------------|
|  DATASOURCE_URL         |  jdbc:mysql://{host}:{port}/{SID}  e.g: jdbc:mysql://localhost:3306/**db_name**?serTimezone=GMT-6  | 
|  DATASOURCE_USERNAME    |  {your db username}                                                                                |
|  DATASOURCE_PASSWORD    |  {your db password}                                                                                |
|  HIBERNATE_DIALECT      |  org.hibernate.dialect.MySQL5Dialect                                                               |

## Setup instructions: 

1. To run the program you will need at least JDK 8, if you have older version first download and install it
2. You will also need MySQL
3. Clone repository from : https://github.com/green-fox-academy/hackathon-erste-credit-card-registry-project
4. Set the above mentioned environment variables 
5. Create a new SQL database for the program:
    ```mysql 
    CREATE DATABASE db_name IF NOT EXISTS; 
    ```
6. In command line go to the root directory and use: 
    ```
    gradlew bootrun
    ```
7. For detailed information and functions of the program go to the swagger documentation: http://localhost:8080/swagger-ui.html/ (port number may vary depending on your local settings)

