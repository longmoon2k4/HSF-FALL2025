# Runtime-only Dockerfile: use locally-built WAR to avoid downloading dependencies inside Docker build
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Copy the WAR produced locally by `mvn -DskipTests clean package`
COPY target/SpringBootDemo-0.0.1-SNAPSHOT.war app.war
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.war"]
