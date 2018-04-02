package wf.garnier.domainpicker

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import wf.garnier.domain.Domain
import wf.garnier.domain.DomainListResponse

@Component
class DomainServiceClient(
        val httpClientBuilder: WebClient.Builder,
        val url: String = "http://domain-service"
) {

    fun listDomains(searchTerm: String): Flux<Domain> {
        return httpClientBuilder
                .build()
                .get()
                .uri("$url/api/domains?search=$searchTerm")
                .retrieve()
                .bodyToMono(DomainListResponse::class.java)
                .flatMapIterable { it.domains }
    }
}
