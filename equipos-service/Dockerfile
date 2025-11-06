# ---- build ----
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
# Copia desde el root del repo
COPY equipos-service/pom.xml ./equipos-service/pom.xml
RUN mvn -q -f equipos-service/pom.xml -DskipTests dependency:go-offline
COPY equipos-service/src ./equipos-service/src
RUN mvn -q -f equipos-service/pom.xml -DskipTests clean package

# ---- run ----
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/equipos-service/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
