#!/bin/bash

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
BIN_DIR=$(readlink -f "$SCRIPT_DIR/../bin")

mkdir -p $BIN_DIR

echo "Downloading zipkin ..."
curl -o $BIN_DIR/zipkin.jar -L "https://search.maven.org/remote_content?g=io.zipkin.java&a=zipkin-server&v=LATEST&c=exec"
echo "Done ! You can run 'java -jar $BIN_DIR/zipkin.jar'."
