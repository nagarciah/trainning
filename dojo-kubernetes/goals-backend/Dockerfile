# https://spring.io/guides/gs/spring-boot-docker/
FROM openjdk:8-jdk-alpine
ADD target/goals-backend-0.0.1-SNAPSHOT.jar app.jar
# Variables informativas que se pueden sobreescribir con docker run
EXPOSE 8080
ENV JAVA_OPTS=""
ENV SPRING_PROFILES_ACTIVE="k8s"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]