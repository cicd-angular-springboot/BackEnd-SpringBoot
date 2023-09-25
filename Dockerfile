# # Build stage
# FROM maven:3.6.3-openjdk-17-slim AS build
# WORKDIR /app
# COPY pom.xml .
# RUN mvn dependency:go-offline
# COPY src/ /app/src/
# RUN mvn clean package

# # Run stage
# FROM openjdk:17-oracle
# WORKDIR /app
# EXPOSE 8080
# COPY --from=build /app/target/*.jar app.jar
# ENTRYPOINT ["java", "-jar", "app.jar"]

FROM openjdk:17-oracle

LABEL MAINTAINER="tongochung1809@gmail.com"

ARG JAR_FILE=/target/*.jar

WORKDIR /app

ADD $JAR_FILE api.jar

EXPOSE 8080

ENTRYPOINT [ "java","-jar","/app/api.jar" ]