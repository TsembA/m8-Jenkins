# Use Amazon Corretto 8 JRE
FROM amazoncorretto:8-alpine3.17-jre

# Expose application port
EXPOSE 8083

# Copy and rename JAR to a fixed name
COPY ./target/java-maven-app-*.jar /usr/app/java-maven-app.jar

# Set working directory
WORKDIR /usr/app

# Start the application
ENTRYPOINT ["java", "-jar", "java-maven-app.jar"]