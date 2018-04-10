package wf.garnier.domainpicker

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import wf.garnier.domain.WhoIs

@Service
class WhoisServiceClient(val httpClientBuilder: WebClient.Builder) {

    val url = "http://whois-service"

    fun whois(domain: String): Mono<WhoIs> =
            httpClientBuilder.build()
                    .get()
                    .uri("$url/api/whois?domain=$domain")
                    .retrieve()
                    .bodyToMono(WhoIs::class.java)
}