@echo off
call mvn clean package
call docker build -t filmregister .
call docker compose up
