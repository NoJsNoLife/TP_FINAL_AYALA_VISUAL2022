FROM maven:3.9.5-eclipse-temurin-11 AS build
WORKDIR /app
COPY pom.xml /app
RUN mvn -e -B dependency:resolve
COPY . /app
RUN mvn clean
RUN mvn -e -B package -DskipTests

FROM openjdk:22-bullseye
COPY --from=build /app/target/tpfinalhia2023-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD [ "java", "-jar", "app.jar" ]
