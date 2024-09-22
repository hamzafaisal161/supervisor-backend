FROM openjdk:18.0-slim
COPY target/*.jar supervisor-0.0.1-SNAPSHOT.jar.jar
EXPOSE 5000
ENTRYPOINT ["java","-jar","supervisor-0.0.1-SNAPSHOT.jar.jar"]