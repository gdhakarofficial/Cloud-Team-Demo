FROM openjdk:17
EXPOSE 8080
ADD target/cloud-team-demo.jar cloud-team-demo.jar
ENTRYPOINT ["java","-jar","/cloud-team-demo.jar"]