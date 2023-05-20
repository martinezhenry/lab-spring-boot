FROM openjdk:18-jdk-slim

# copiar jar a la carpeta de la imagen
COPY target/*.jar /app/bin/users.jar

ENTRYPOINT java -jar /app/bin/users.jar