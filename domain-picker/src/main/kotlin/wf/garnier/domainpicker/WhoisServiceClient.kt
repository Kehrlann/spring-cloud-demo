package wf.garnier.domainpicker

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import wf.garnier.domain.WhoIs

@Component
class WhoisServiceClient(
        val httpClient: WebClient,
        val url: String = "http://whois-service"
) {

    fun whois(domain: String): Mono<WhoIs> {
        return httpClient
                .get()
                .uri("$url/api/whois?domain=$domain")
                .retrieve()
                .bodyToMono(WhoIs::class.java)
    }
}
