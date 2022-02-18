FROM maven:3.8.4-jdk-11-slim as builder
WORKDIR /app/filmregister
COPY pom.xml ./
RUN mvn dependency:go-offline
COPY src src
RUN mvn package -DskipTests

FROM adoptopenjdk:11-jre-hotspot
WORKDIR /app/filmregister
EXPOSE 8080
COPY --from=builder /app/filmregister/target/filmregister-0.9.1-SNAPSHOT.jar filmregister.jar
ENTRYPOINT ["java", "-jar", "filmregister.jar"]