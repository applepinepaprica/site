FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY . /app
EXPOSE 8080
CMD ["java", "-jar", "site-0.0.1-SNAPSHOT.jar"]

