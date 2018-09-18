#!/bin/bash
mvn clean install
docker build -t event-checker .
docker run -it -d -p 80:80 event-checker