# Mongodb + Spring Data

Just Demo For Spring Data use MongoDb

## Spring application config

```yml
server:
  port: 8080
spring:
  data:
    mongodb:
      uri: mongodb://localhost/test
```

## Maven Pom.xml

```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-mongodb</artifactId>
        </dependency>
```
## User Spring Data Repository

```Java
public interface CustomerRepository extends MongoRepository<Customer, Integer> {
}
```