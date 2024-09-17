# base image
FROM openjdk:21

EXPOSE 8080

COPY target/springboot-docker-example.jar app.jar


ENTRYPOINT ["java", "-jar", "/app.jar"]

