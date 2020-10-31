FROM adoptopenjdk/openjdk15
RUN mkdir /opt/app
COPY /target/eclat-jwt.jar /opt/app

ENTRYPOINT ["java", "-jar", "/opt/app/eclat-jwt.jar"]