# Use official lightweight Java image
FROM openjdk:17-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy your built jar file into the container
COPY target/exam-service.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
