# Stage 1: Build with JDK 21
FROM eclipse-temurin:21-jdk-jammy as builder

WORKDIR /app

# Copy build files (cached unless changed)
COPY mvnw .
COPY .mvn/ .mvn/
COPY pom.xml .

# Resolve dependencies first (faster rebuilds)
RUN ./mvnw dependency:go-offline -B

# Copy source and build
COPY src/ src/
RUN ./mvnw package -DskipTests

# Stage 2: Runtime with JRE 21
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Copy built JAR and properties
COPY --from=builder /app/target/*.jar app.jar
COPY src/main/resources/application.properties ./config/

# Expose Spring Boot's port
EXPOSE 8080

# Run with production-ready JVM settings
ENTRYPOINT ["java", "-jar", "-Xmx512m", "app.jar"]