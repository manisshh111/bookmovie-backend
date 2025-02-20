FROM openjdk:17-jdk-slim
EXPOSE 8080
ADD target/bookmovie-docker.jar bookmovie-docker.jar
ENTRYPOINT ["java","-jar","/bookmovie-docker.jar"]

