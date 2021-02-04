FROM java:8

# Add Author info
LABEL maintainer="minssan9@gmail.com"

# Add a volume to /tmp
VOLUME /charger

# Make port 8080 available to the world outside this container
EXPOSE 54000

# The application's jar file
ARG JAR_FILE=build/libs/charger-*.jar

# Add the application's jar to the container
ADD ${JAR_FILE} charger-springboot.jar

# Run the jar file
ENTRYPOINT ["java", "-jar","/charger-springboot.jar"]
