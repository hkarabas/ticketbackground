FROM openjdk

VOLUME /tmp
ADD maven/ticketbackground-0.0.1-SNAPSHOT.jar ticketbackground-0.0.1-SNAPSHOT.jar
RUN sh -c 'touch /ticketbackground-0.0.1-SNAPSHOT'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/ticketbackground-0.0.1-SNAPSHOT.jar"]