# ---- build ----
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
# Copia desde el root del repo
COPY api-gateway/pom.xml ./api-gateway/pom.xml
RUN mvn -q -f api-gateway/pom.xml -DskipTests dependency:go-offline
COPY api-gateway/src ./api-gateway/src
RUN mvn -q -f api-gateway/pom.xml -DskipTests clean package

# ---- run ----
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/api-gateway/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
