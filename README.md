# Spring Boot JWT 
> Spring boot template project with JWT Role based authentication integrated with spring-data-jpa

#### Docker Configuration
##### Dockerfile
Docker file contains the things that are need by the application in order to run.
Particular for spring boot we built the following Dockerfile
```dockerfile
FROM adoptopenjdk/openjdk15
RUN mkdir /opt/app
COPY /target/app.jar /opt/app
ENTRYPOINT ["java", "-jar", "/opt/app/app.jar"]
```
##### Docker Compose
Docker compose is a short way of building the images and running containers instead of running
them individually. It's extension can be **`yml`** or **`yaml`**.

It also gives us the option to up and down the docker containers in a single command.
 - `docker-compose up -d --build` Use **`--build`** to build a new image every time.
 - `docker-compose down` only to stop & remove containers
 - `docker-compose down --rmi all` to stop & remove containers and all images
 - Docker compose example
     -  ```yaml
        version: "3.8"
        services:
          service-name:
            container_name: your_container_name
            build: .
            image: your_image_name
            ports:
              - "8080:8080"
        ```
 - Without docker compose
    - ```shell script
        docker build -t image_name:tag_name . 
        docker run -d -p 8080:8080 --name container_name image_name
      ```
    
##### Bash Script
Instead of typing the script over and over again we write a script to do all the step automatically
```shell script
mvn clean install
docker-compose down --rmi all
docker-compose up -d
```