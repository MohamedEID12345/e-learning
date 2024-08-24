# استخدام صورة Java
FROM openjdk:17-jdk-slim

# إعداد دليل العمل
WORKDIR /app

# نسخ ملفات البناء إلى الحاوية
COPY target/user-service-0.0.1-SNAPSHOT.jar app.jar

# تشغيل التطبيق
ENTRYPOINT ["java", "-jar", "app.jar"]
