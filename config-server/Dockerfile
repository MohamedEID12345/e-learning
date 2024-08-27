FROM openjdk:17-jdk
WORKDIR /app
COPY target/config-server-0.0.1-SNAPSHOT.jar config-server.jar
ENTRYPOINT ["java", "-jar", "config-server.jar"]
