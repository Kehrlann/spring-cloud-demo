#!/bin/bash

cf cups eureka -p '{"url": "http://bcn-eureka.cfapps.io/eureka/"}'
cf cups zipkin -p '{"url": "http://bcn-zipkin.cfapps.io/"}'
