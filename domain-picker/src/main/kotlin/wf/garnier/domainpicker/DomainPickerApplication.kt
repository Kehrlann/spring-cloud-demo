package wf.garnier.domainpicker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class DomainPickerApplication(val restTemplateBuilder: RestTemplateBuilder) {

    @Bean
    fun restTemplate(): RestTemplate = restTemplateBuilder.build()
}

fun main(args: Array<String>) {
    runApplication<DomainPickerApplication>(*args)
}
