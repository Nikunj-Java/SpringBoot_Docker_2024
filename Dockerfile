# Use OpenJDK 17 image
FROM openjdk:17 AS build

# Copy project files
COPY . /usr/src/app
WORKDIR /usr/src/app
 

# Run the jar
FROM openjdk:17
COPY --from=build /usr/src/app/target/SpringBoot_JDBC_Template-0.0.1-SNAPSHOT.jar /usr/app/app.jar

WORKDIR /usr/app
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
