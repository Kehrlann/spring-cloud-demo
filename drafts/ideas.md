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

# Questions
- How do I present labs ?
- How does the SCS-Eureka-server fare in a multi-instance context ; what if one instance "dies" ?

# What else could we do ?!
- Should we TDD the shit out of this ?
