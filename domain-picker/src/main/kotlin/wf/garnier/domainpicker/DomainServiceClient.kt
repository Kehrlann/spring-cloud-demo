package wf.garnier.domainpicker

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import wf.garnier.domain.Domain
import wf.garnier.domain.DomainListResponse

@Service
class DomainServiceClient(val httpClient: RestTemplate) {

    val url = "http://domain-service"

    fun listDomains(search: String): Collection<Domain> =
            httpClient.getForObject("$url/api/domains?search=$search", DomainListResponse::class.java)!!
                    .domains
}