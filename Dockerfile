FROM openjdk:8
EXPOSE 8080
ADD target/${project.artifactId}.jar ${project.artifactId}
ENTRYPOINT ["java","jar","/spring-boot-docker.jar"]