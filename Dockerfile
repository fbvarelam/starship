FROM openjdk:22-jdk-slim

WORKDIR /app

COPY target/starship-0.0.1-SNAPSHOT.jar /app/starship.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "starship.jar"]