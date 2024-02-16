#!/usr/bin/env bash

service mysql start

sleep 10

# update the user 
mysql -u root < priv.sql

sleep 2

# start the java command
java -jar postcodes-docker.jar