FROM openjdk:17
WORKDIR /HOTEL

COPY target/hotel-inventory.jar hotel-inventory.jar
EXPOSE 8000

ENTRYPOINT ["java", "-jar", "/spring-mysql-inventory.jar"]
