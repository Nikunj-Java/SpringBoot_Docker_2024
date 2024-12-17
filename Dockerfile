# Use OpenJDK 17 image
FROM openjdk:17 AS build

# Install Maven
RUN sudo apt-get update 
RUN sudo apt-get install maven

# Copy project files
COPY . /usr/src/app
WORKDIR /usr/src/app

# Build project using Maven
RUN mvn clean package

# Run the jar
FROM openjdk:17
COPY --from=build /usr/src/app/target/SpringBoot_JDBC_Template-0.0.1-SNAPSHOT.jar /usr/app/app.jar

WORKDIR /usr/app
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
