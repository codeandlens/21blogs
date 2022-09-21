# Use official base image of Java Runtime
FROM openjdk:8-jdk-alpine

ENV JVM_OPTS='-Dspring.profiles.active=default'

# Make port 8080 available to the world outside container
EXPOSE 8080

# Set application's JAR file
ARG JAR_FILE=target/admin-service-1.0.0.jar

# Add the application's JAR file to the container
ADD ${JAR_FILE} admin-service.jar

COPY src/main/resources/application.yml /admin-service/application.yml

# Run the JAR file
ENTRYPOINT exec java $JVM_OPTS -jar ./admin-service.jar --spring.config.location=file:/admin-service/application.yml