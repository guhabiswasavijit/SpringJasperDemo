FROM openjdk:11
MAINTAINER guhabiswas.avijit@gmail.com 
ARG JAR_FILE
COPY target/${JAR_FILE} spring-boot-jasper-report-demo.jar
ENTRYPOINT ["java", "-jar", "spring-boot-jasper-report-demo.jar"]