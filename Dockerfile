FROM adoptopenjdk:11-jre-hotspot
WORKDIR /app
EXPOSE 8080
COPY /target/filmregister-0.0.1-SNAPSHOT.jar filmregister.jar
ENTRYPOINT ["java", "-jar", "filmregister.jar"]