# Goals
- Velocity with Spring Boot and Kotlin
  - Hit the ground running
- Scalability with Spring Cloud
- Easy integration with cloud PaaSes
- PCF is the natural place to run Spring apps (Luis)
  - Spring Config Server
  - Eureka server
  - Hystrix Dashboard
- + other PCF freebies (Luis)

# Demo shape
Simple app that relies on three back-end services (...)

Something around domain names

- search-service, around available domains
  - Lets you talk about spring boot and kotlin
  - Not very high value to integrate with, but good start
  - Technology : rest template, kotlin, controller, spring boot

- pricing-service, to get prices
  - Webclient and parallel stuff
    - Introduce fake latency in my service
    - Then parallelize stuff
  - Eureka and service discovery

- whois-service, to run whois on unavailable domain names
  - Show feign client 
  - Show hystrix circuit breaker
  - Alleviate load

- Simple front-end app to show prices and whois-es for domain names

Eureka is easy
What about config service ... ?

# TODO next
[x] Deploy all to CF
[x] Correct routes for services using eureka
[x] Shutdown pricing on CF, test
[x] Do a simple spring JPA integration, with H2 locally and MySQL on CF
  - How do I mysql ?!
  - Apparently, Eureka conflicts with the autoconfigurator provided by cloud foundry
  - It adds two javax.sql.Datasource beans, which is too much for the SpringAutoReconfiguration added by the buildpack
  - Consequence : only do a simple service with a sql integration
[x] Prepare simple Kotlin explanation
[x] Prepare the demo
[~] Run the demo, and time it !
[x] Make whois-service delay configurable 
[x] Spring Sleuth
[x] Primer on Reactor / nio
[x] Circuit breaker never opens ?!
  - Just gotta go fast ... while(true); do curl ... done;

# Questions
- How do I present labs ?
- How does the SCS-Eureka-server fare in a multi-instance context ; what if one instance "dies" ?

# What else could we do ?!
- How does this work with PCF ?
- App autoscaling ?
- Mmmmmg zipkin ? distributed tracing ?
