#!/bin/bash

echo 'Firing on domain-picker as fast as possible ...'
while(true); do curl localhost:8000/api/domains?search=test > /dev/null 2>&1; date +%H:%M:%S.%N; done;
