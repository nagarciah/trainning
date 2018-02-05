# https://spring.io/guides/gs/spring-boot-docker/
FROM openjdk:8-jdk-alpine
ADD target/goals-frontend-0.0.1-SNAPSHOT.jar app.jar
# Variables informativas que se pueden sobreescribir con docker run
EXPOSE 8080
ENV JAVA_OPTS=""
ENV SPRING_PROFILES_ACTIVE="k8s"
ENV GOALS_BACKEND_URL=http://goals-backend:8080/
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
