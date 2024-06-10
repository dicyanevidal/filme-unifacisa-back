
FROM yannoff/maven:3-openjdk-17 AS builder

WORKDIR /app
COPY pom.xml /app
RUN mvn dependency:resolve
COPY . /app
RUN mvn package

FROM openjdk:17-slim AS runner

COPY --from=builder /app/target/filme-unifacisa-backend-0.0.1-SNAPSHOT.jar .
CMD java -jar filme-unifacisa-backend-0.0.1-SNAPSHOT.jar