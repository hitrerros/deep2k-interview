FROM amazoncorretto:17
EXPOSE 8081

# the JAR file path
ARG JAR_FILE=target/*.jar

# Copy the JAR file from the build context into the Docker image
COPY ${JAR_FILE} application.jar

# Set the default command to run the Java application
ENTRYPOINT ["java", "-jar", "/application.jar"]

