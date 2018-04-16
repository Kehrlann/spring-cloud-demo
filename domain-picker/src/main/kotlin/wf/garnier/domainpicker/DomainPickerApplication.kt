package wf.garnier.domainpicker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancerExchangeFilterFunction
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableFeignClients
class DomainPickerApplication(val restTemplateBuilder: RestTemplateBuilder,
                              val lbFunction: LoadBalancerExchangeFilterFunction) {
    @Bean
    @LoadBalanced
    fun restTemplate(): RestTemplate = restTemplateBuilder.build()

    @Bean
    fun webClient(): WebClient = WebClient.builder().filter(lbFunction).build()
}

fun main(args: Array<String>) {
    runApplication<DomainPickerApplication>(*args)
}
