# استخدم صورة Java
FROM openjdk:17-jdk

# تعيين دليل العمل
WORKDIR /app

# نسخ JAR الملف إلى صورة Docker
COPY target/config-service-0.0.1-SNAPSHOT.jar config-service.jar

# تنفيذ تطبيق Spring Boot
ENTRYPOINT ["java", "-jar", "config-service.jar"]
