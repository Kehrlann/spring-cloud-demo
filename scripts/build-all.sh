#!/bin/bash

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

pushd $SCRIPT_DIR/..
mvn clean install -pl domain-lib
mvn clean package -DskipTests=true
popd
