FROM openjdk:8-jdk-alpine
VOLUME /tmp /var/log
ENV SPRING_PROFILES_ACTIVE=containerized \
    SERVER_PORT=8080 \
    LOG_PATH=/var/log \
    LOG_FILE=$LOG_PATH/app.log
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app.jar"]
