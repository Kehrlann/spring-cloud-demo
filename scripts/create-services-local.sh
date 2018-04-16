#!/bin/bash

cf cups eureka -p '{"url": "http://bcn-eureka.local.pcfdev.io/eureka/"}'
cf cups zipkin -p '{"url": "http://bcn-zipkin.local.pcfdev.io/"}'
