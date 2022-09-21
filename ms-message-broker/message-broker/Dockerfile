# Use official base image of Java Runtime
FROM openjdk:8-jdk-alpine

ENV JVM_OPTS='-Dspring.profiles.active=default'

# Make port 8080 available to the world outside container
EXPOSE 8080

# Set application's JAR file
ARG JAR_FILE=target/MessageBroker-1.0.0.jar

# Add the application's JAR file to the container
ADD ${JAR_FILE} MessageBroker.jar

COPY src/main/resources/application.yml /message-broker/application.yml

# Run the JAR file
ENTRYPOINT exec java $JVM_OPTS -jar ./MessageBroker.jar --spring.config.location=file:/message-broker/application.yml