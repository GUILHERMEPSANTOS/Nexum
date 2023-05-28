FROM openjdk:17-oracle
WORKDIR /app 
COPY target/backend-0.0.1-SNAPSHOT.jar /app/backend-0.0.1-SNAPSHOT.jar
VOLUME /app
CMD ["java", "-jar", "/app/backend-0.0.1-SNAPSHOT.jar", "&"]