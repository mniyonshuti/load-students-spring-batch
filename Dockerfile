FROM openjdk:8-jdk-alpine
ADD target/students-batch-file.jar students-batch-file.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","students-batch-file.jar"]