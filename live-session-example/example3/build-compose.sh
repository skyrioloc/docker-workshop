#!/bin/bash
echo "Building sample-spring-boot..."
mvn clean install -DskipTests=true | grep 'BUILD '
echo "Running Docker Compose..."
docker-compose up -d --build 1>/dev/null
echo "Cleaning..."
docker rmi $(docker images -f "dangling=true" -q) 1>/dev/null
echo "rm -rf target"
echo "Done!!"
