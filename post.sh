#!/bin/bash

TARGET=${1:-"http://localhost:8000/api/reservation"} 

echo "Domain name : "
read line
DOMAIN=$line

curl -X POST -H "Content-Type: application/json" -d "{ \"domain\" : \"$DOMAIN\" }" $TARGET | jq

