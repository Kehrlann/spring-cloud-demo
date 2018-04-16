package wf.garnier.domainpicker

import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import wf.garnier.domain.Domain
import wf.garnier.domain.DomainListResponse

@Component
class DomainServiceClient(
        val httpClient: RestTemplate,
        val url: String = "http://domain-service"
) {

    fun listDomains(searchTerm: String): Collection<Domain> {
        return httpClient
                .getForObject("$url/api/domains?search=$searchTerm", DomainListResponse::class.java)
                ?.domains
                ?: listOf()
    }
}
