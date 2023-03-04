FROM openjdk:18-jdk-alpine3.14
VOLUME /tmp
EXPOSE 8000
ARG JAR_FILE=target/backend-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]