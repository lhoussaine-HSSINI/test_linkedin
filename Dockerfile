FROM openjdk:latest

COPY target/stage-0.0.1-SNAPSHOT.jar root.war

ENTRYPOINT ["java","-jar","/root.war"]
