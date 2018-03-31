package wf.garnier.pricingservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class PricingServiceApplication

fun main(args: Array<String>) {
    runApplication<PricingServiceApplication>(*args)
}
