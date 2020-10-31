FROM adoptopenjdk/openjdk15
RUN mkdir /opt/app
COPY japp.jar /opt/app

ENTRYPOINT ["java", "-jar", "/opt/app/japp.jar"]