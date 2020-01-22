FROM openjdk:8
EXPOSE 8085
ADD target/application.jar application.jar
ENTRYPOINT ["java","-jar","/application.jar"]