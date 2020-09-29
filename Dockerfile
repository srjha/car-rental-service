FROM openjdk:11.0.3-jdk-slim

ENV CLASSPATH /opt/lib

COPY container-entry.sh /opt/container-entry.sh
RUN chmod -R a+rwx /opt

WORKDIR /opt

EXPOSE 8080

COPY pom.xml target/lib* /opt/lib/

COPY target/*.jar /opt/app.jar

CMD ["/opt/container-entry.sh"]