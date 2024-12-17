# Step 1: Use an official OpenJDK base image
FROM openjdk:17-jdk-slim

# Step 2: Install Maven
RUN apt-get update && apt-get install -y maven && apt-get clean

# Step 3: Set the working directory in the container
WORKDIR /usr/app

# Step 4: Copy the Maven project files into the container
COPY pom.xml /usr/app/
COPY src /usr/app/src/

# Step 5: Build the application using Maven
RUN mvn clean install -DskipTests

# Step 6: Expose the port (if you want to run a web application, for example)
EXPOSE 8080

# Step 7: Command to run the application (assuming it's a Spring Boot app or any other Java app)
ENTRYPOINT ["mvn", "spring-boot:run"]
