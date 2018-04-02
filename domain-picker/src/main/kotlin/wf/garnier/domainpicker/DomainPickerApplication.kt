package wf.garnier.domainpicker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
class DomainPickerApplication(val restTemplateBuilder: RestTemplateBuilder) {

    @Bean
    @LoadBalanced
    fun restTemplate(): RestTemplate = restTemplateBuilder.build()

    @Bean
    @LoadBalanced
    fun webClientBuilder(): WebClient.Builder = WebClient.builder()

    @Bean
    fun webClient(builder: WebClient.Builder): WebClient = builder.build()
}

fun main(args: Array<String>) {
    runApplication<DomainPickerApplication>(*args)
}
