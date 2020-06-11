FROM openjdk
# image layer
FROM maven:alpine
WORKDIR /app
# Image layer: with the application
COPY . /app
CMD mvn clean package docker:build
VOLUME /tmp
EXPOSE 8081
ADD   target/ticketbackground-0.0.1-SNAPSHOT.jar ticketbackground-0.0.1-SNAPSHOT.jar
RUN sh -c 'touch /ticketbackground-0.0.1-SNAPSHOT'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","ticketbackground-0.0.1-SNAPSHOT.jar"]






