package wf.garnier.domainservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class DomainServiceApplication

fun main(args: Array<String>) {
    runApplication<DomainServiceApplication>(*args)
}
