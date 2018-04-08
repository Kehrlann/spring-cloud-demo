package wf.garnier.domainpicker

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import wf.garnier.domain.WhoIs

@Component
class WhoisServiceClient(
        val httpClientBuilder: WebClient.Builder,
        val url: String = "http://whois-service"
) {

    fun whois(domain: String): Mono<WhoIs> {
        return httpClientBuilder
                .build()
                .get()
                .uri("$url/api/whois?domain=$domain")
                .retrieve()
                .bodyToMono(WhoIs::class.java)
    }
}
