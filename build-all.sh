#!/bin/bash

mvn clean install -pl domain-lib
mvn clean package -DskipTests=true
