# ---------- Etapa de build ----------
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copia el POM y descarga dependencias para cachear capas
COPY pom.xml .
RUN mvn -B -q -DskipTests dependency:go-offline

# Copia el código y empaqueta
COPY src ./src
RUN mvn -B -q -DskipTests clean package

# ---------- Etapa de runtime ----------
FROM eclipse-temurin:17-jre
WORKDIR /app

# TZ para Java y libs nativas
ENV TZ=America/Bogota
RUN apt-get update && apt-get install -y tzdata && rm -rf /var/lib/apt/lists/*

# Copia el JAR resultante
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto (ajústalo si usas otro)
EXPOSE 8081

# Ejecuta
ENTRYPOINT ["java","-jar","/app/app.jar"]
