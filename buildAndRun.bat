@echo off
call mvn clean package
call docker build -t com.mycompany/productosCRUDupdate .
call docker rm -f productosCRUDupdate
call docker run -d -p 9080:9080 -p 9443:9443 --name productosCRUDupdate com.mycompany/productosCRUDupdate