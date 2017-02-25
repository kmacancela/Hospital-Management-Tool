FROM java:8
MAINTAINER shamlau23@gmail.com
VOLUME /tmp
ADD target/PatientAPI-1.0-SNAPSHOT.jar PatientAPI.jar
EXPOSE 12355
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/PatientAPI.jar"]