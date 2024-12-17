FROM openjdk:17



COPY ./target/SpringBoot_JDBC_Template-0.0.1-SNAPSHOT*.jar /usr/app/SpringBoot_JDBC_Template-0.0.1-SNAPSHOT.jar

WORKDIR /usr/app

EXPOSE 8080

ENTRYPOINT ["java","-jar","SpringBoot_JDBC_Template-0.0.1-SNAPSHOT.jar"]