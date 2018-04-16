#!/bin/bash

echo 'Firing on domain-picker as fast as possible ...'
while(true); do curl http://domain-picker.local.pcfdev.io/api/domains?search=test > /dev/null 2>&1; date +%H:%M:%S.%N; done;
