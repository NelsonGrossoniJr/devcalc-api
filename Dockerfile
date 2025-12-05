# Stage 1: Build e Test
FROM maven:3.9.11-amazoncorretto-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean test package     # ← Compila E executa testes

# Stage 2: Runtime
FROM amazoncorretto:17
WORKDIR /app
COPY --from=builder /app/target/devcalc-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
