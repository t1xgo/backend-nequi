FROM eclipse-temurin:23-jdk as builder

# Set the working directory
WORKDIR /app

# Copy the project code
COPY . .

# Build the project
RUN ./mvnw clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:23-jre

# Set the working directory
WORKDIR /app

# Copy the built jar file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port the app will run on
EXPOSE 8080