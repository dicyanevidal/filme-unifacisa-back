FROM openjdk:17-jdk-slim

WORKDIR /app

# Copiar o JAR e renomear para app.jar
COPY target/filme-unifacisa-backend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
