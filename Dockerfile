FROM openjdk:8
WORKDIR /app/springboot/
ADD build/libs/sha-database-service-0.0.1-SNAPSHOT.jar sha-database-service.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "sha-database-service.jar"]