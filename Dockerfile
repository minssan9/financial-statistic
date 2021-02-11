FROM java:8
# Add Author info
LABEL maintainer="minssan9@gmail.com"

# Add a volume to /tmp
VOLUME /fn

# Make port 8080 available to the world outside this container
EXPOSE 54000

# The application's jar file
ARG JAR_FILE=build/libs/*.jar

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar

# Run the jar file
ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-jar", "/app.jar"]
