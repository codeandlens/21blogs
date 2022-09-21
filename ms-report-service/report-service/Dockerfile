# Use official base image of Java Runtime
FROM openjdk:8-jdk-alpine
RUN apk add ttf-dejavu

ENV JVM_OPTS='-Dspring.profiles.active=default -Djava.awt.headless=true'

# Make port 8080 available to the world outside container
EXPOSE 8080

# Set application's JAR file
ARG JAR_FILE=target/report-service-1.0.0.jar

# Add the application's JAR file to the container
ADD ${JAR_FILE} report-service.jar

COPY src/main/resources/application.yml /report-service/application.yml

# Run the JAR file
ENTRYPOINT exec java $JVM_OPTS -jar ./report-service.jar --spring.config.location=file:/report-service/application.yml