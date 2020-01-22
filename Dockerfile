FROM openjdk:8
EXPOSE 8080
ADD target/Application.jar Application
ENTRYPOINT ["java","jar","/spring-boot-docker.jar"]