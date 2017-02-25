FROM java:8
MAINTAINER shamlau23@gmail.com
VOLUME /tmp
ADD target/eureka-0.0.1-SNAPSHOT.jar eureka.jar
EXPOSE 8761
RUN bash -c 'touch /eureka.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/eureka.jar"]