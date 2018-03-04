#!/bin/sh

if [ ! -d "bitnami-docker-wordpress" ]; then
	git clone https://github.com/bitnami/bitnami-docker-wordpress.git
fi
cd bitnami-docker-wordpress
docker-compose up -d
cd ..
sleep 30
chmod +x ./wait-for-it.sh
./wait-for-it.sh -t 30 localhost:80 -- echo "wordpress is up"
cd geb-tester
chmod +x ./gradlew
./gradlew test
cd ..
cd bitnami-docker-wordpress
docker-compose down
