#!/bin/sh
mvn clean package && docker build -t com.mycompany/productosCRUDupdate .
docker rm -f productosCRUDupdate || true && docker run -d -p 9080:9080 -p 9443:9443 --name productosCRUDupdate com.mycompany/productosCRUDupdate