# Step 1
echo "Running maven clean install"
mvn clean install

# Step 2
echo "Stopping and deleting container and image"
docker stop eclat-service
docker container rm eclat-service
docker rmi eclat

# Step 3
# echo "Building a new image and running a container"
# docker build -t eclat:latest . # Image creation
# docker run -d -p 8881:8881 --name eclat-service eclat # Running created image in a container

#Step 3 updated by docker-compose
docker-compose up