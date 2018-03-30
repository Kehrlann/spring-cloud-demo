package wf.garnier.domainpicker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
@EnableEurekaClient
class DomainPickerApplication(val restTemplateBuilder: RestTemplateBuilder) {

    @Bean
    @LoadBalanced
    fun restTemplate(): RestTemplate = restTemplateBuilder.build()
}

fun main(args: Array<String>) {
    runApplication<DomainPickerApplication>(*args)
}
