FROM openjdk:latest

COPY target/stage-0.0.1-SNAPSHOT.jar root.jar
ENTRYPOINT ["java","-jar","/root.jar"]