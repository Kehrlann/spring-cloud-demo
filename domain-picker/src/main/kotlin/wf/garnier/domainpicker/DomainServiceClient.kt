package wf.garnier.domainpicker

import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import wf.garnier.domain.DomainListResponse

@Component
class DomainServiceClient(val httpClient: RestTemplate) {

    val url = "http://localhost:8080"

    fun listDomains(searchTerm: String): DomainListResponse {
        return httpClient
                .getForObject("$url/api/domains?search=$searchTerm", DomainListResponse::class.java)!!
    }
}
