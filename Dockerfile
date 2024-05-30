FROM openjdk:17
WORKDIR /HOTEL

COPY target/hotel-inventory.jar hotel-inventory.jar

ENTRYPOINT ["java", "-jar", "/spring-mysql-inventory.jar"]
