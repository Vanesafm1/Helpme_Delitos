# Guide & Docs
## Guia para setup e intializer desde:
https://www.section.io/engineering-education/how-to-create-a-rest-api-using-spring-boot-maven-and-mysql/

Using minimal project with the following dependencies: 
* spring-web 
* spring-data 
* mysql-driver 

# Mysql with DOCKER
Despues de tener docker instalado ejecutar el primer comando para descargar y correr el docker con mysql

```console 
> docker run -d -p 33060:3306 --name mysql-db -e MYSQL_ROOT_PASSWORD=root mysql 
```
Y el siguiente comando para enrar en modo terminal al mysql dentro del docker

```console 
> docker exec -it mysql-db mysql -p
> mysql> create database crimenes
```

Se usan los properties de la guia pero adicional se modifica la propiedad tal como se muestra en [stackoverflow](https://stackoverflow.com/questions/50379839/connection-java-mysql-public-key-retrieval-is-not-allowed) pues esto parece algo especifico de correr con docker

```
allowPublicKeyRetrieval=true
```

```properties 
spring.datasource.url=jdbc:mysql://localhost:33060/crimenes?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&useLegacyDatetimeCode=false
spring.datasource.username=root
spring.datasource.password=root

server.port=8081

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto=update
```

# Correr el proyecto
* Si se hace antes de modificar los properties nos aparece el error de problema en la url de la BD
* Si se usan los properites de la guia falla con el error de allowPublicKeyRetrieval

```console 
> ./mvnw spring-boot:run
```

# Conceptos

## Servicios



## Controller
Es capa ligera encargada de traducir http a java y vicecersa :
* Escuchar peticiones en Json y delega en la capa de servicios su ejecucion 
* Recibe el resultado de las ejecuciones y lo traduce a la semantica REST correspondiente (200, 303,4040, etc )




# ======= Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.3/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.3/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.6.3/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

