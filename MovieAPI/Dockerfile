# Start with a base image containing Java runtime
FROM openjdk:13-jdk-alpine



# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=target/movie-0.0.1-SNAPSHOT.war 	

# Add the application's jar to the container
ADD ${JAR_FILE} movie-0.0.1-SNAPSHOT.war

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/movie-0.0.1-SNAPSHOT.war"]

