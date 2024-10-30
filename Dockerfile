# Usar una imagen de Oracle JDK 21 como base
FROM oraclelinux:8-slim

# Instalar Oracle JDK 21
RUN dnf -y install oracle-epel-release-el8 && \
    dnf -y install java-21-openjdk && \
    dnf clean all

# Crear el directorio de trabajo
WORKDIR /app

# Copiar el JAR de la aplicación al contenedor
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que se ejecutará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]