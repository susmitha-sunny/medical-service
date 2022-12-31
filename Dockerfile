FROM openjdk:19
ADD target/medical-service-0.0.1-SNAPSHOT.jar medical-service-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "medical-service-0.0.1-SNAPSHOT.jar"]