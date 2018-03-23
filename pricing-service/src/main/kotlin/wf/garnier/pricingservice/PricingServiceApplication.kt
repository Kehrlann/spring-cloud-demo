package wf.garnier.pricingservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PricingServiceApplication

fun main(args: Array<String>) {
    runApplication<PricingServiceApplication>(*args)
}
