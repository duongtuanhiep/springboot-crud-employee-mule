# springboot-crud-employee-mule {v. 1.0}

## [SpringBoot][REST API] 

## Description
These are RESTful APIs created based on raml specification. The APIs was designed and tested with H2 in-memory database.
You can find the detail sppecification written in RAML files at src/main/api.

NOTE : Please be aware that the work of the project is not corresponds 100% to the specification in Raml files. There is a few features of the API will be implemented on an intergration platform ( Mulesoft's Anypoints Platform in my case). Detail in Usage. 

## Built with
This application was built using :
- [Spring Boot](https://spring.io/projects/spring-boot)
- [H2 Database](https://www.h2database.com/html/main.html)
- [Spring Data](https://spring.io/projects/spring-data)
- [Spring web mvc](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html)
- [Hibernate](https://hibernate.org/)
- [Maven](https://maven.apache.org/)

## Installation 

This project is a spring boot project using maven. You can download this project to your local computer andd import into your local Spring Tool Suite as maven project.

## Usage

The project is ready to use as a Spring Boot Application. 

The database used in this application is the H2 database which is a in-memory database that should be used for testing purpose only. You can hook an actual mySQL database to the application by modifying the file "application.properties" located in \src\main\resources\.
More info on modifying "application.properties" : 
https://www.tutorialspoint.com/spring_boot/spring_boot_application_properties.htm

If you wish to use the H2 database and inspect the data, you can also access H2 console to inspect or modify the tables through :
```
http://localhost:{Running-Port}/h2-console/
```
The username and password can be modified using "application.properties". By default, it is : 
```
username : sa
password :
NOTE : password is empty 
```

List of features and traits that are different/not implemented in this project : 
- ci1764-traits.paged : The parameter <pageBy> follows the pattern " <pageNumber> , <pageSize> " . In the project this 1 parameters is separated into 2 parameters : pageNumber and pageSize. 
- ci1764-traits.timedQueryable : not implemented. 
- ci1764ResponseTraits.ErrorResponse : not implemented. 

## Contributing & author

Duong Tuan Hiep - Duongtuanhiep18398@gmail.com
