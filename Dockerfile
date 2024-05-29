FROM openjdk:17
WORKDIR /HOTEL
COPY target/inventory-mysql-docker.jar spring-mysql-inventory.jar
ENTRYPOINT ["java", "-jar", "/spring-mysql-inventory.jar"]
