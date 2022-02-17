FROM openjdk:11
COPY build/libs/project-1-1.0-SNAPSHOT.jar project1.jar
CMD ["java", "-jar", "project1.jar"]