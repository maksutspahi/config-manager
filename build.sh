#!/bin/bash
set -e
username='maksutspahi'
service='config-manager'
mvn package
docker build -t $username/$service:latest .
