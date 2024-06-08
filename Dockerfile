# Utiliza una imagen base de Maven para compilar la aplicación
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app

# Copia los archivos de proyecto y construye el JAR
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Utiliza una imagen base de OpenJDK para ejecutar la aplicación
FROM openjdk:17-jdk-alpine
WORKDIR /app

# Copia el JAR compilado desde la imagen de construcción
COPY --from=build /app/target/festivapp-backend-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que la aplicación se ejecutará
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
