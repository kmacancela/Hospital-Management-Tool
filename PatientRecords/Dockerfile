FROM java:8
MAINTAINER shamlau23@gmail.com
VOLUME /tmp
ADD target/PatientRecords-1.0-SNAPSHOT.jar PatientRecords.jar
EXPOSE 12349
RUN bash -c 'touch /PatientRecords.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/PatientRecords.jar"]