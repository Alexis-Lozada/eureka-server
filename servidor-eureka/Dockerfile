# ===== STAGE 1: build =====
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn -q -DskipTests package

# ===== STAGE 2: run =====
FROM eclipse-temurin:21-jdk

WORKDIR /app

RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

# Ajusta al nombre real del JAR si es diferente
COPY --from=build /app/target/servidor-eureka-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8761

ENTRYPOINT ["java","-jar","/app/app.jar"]
