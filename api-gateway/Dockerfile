FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app
# Copy và cài đặt parent pom
COPY ../pom.xml .
RUN mvn install -N
# Copy và build api-gateway
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY --from=build /app/target/*.jar app.jar
EXPOSE 9000

ENTRYPOINT [ "java","-jar","app.jar"]
