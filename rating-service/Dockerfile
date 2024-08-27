FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/rating-service-0.0.1-SNAPSHOT.jar rating-service.jar
ENTRYPOINT ["java","-jar","/rating-service.jar"]
