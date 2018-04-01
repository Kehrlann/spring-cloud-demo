package wf.garnier.domainpicker

import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import wf.garnier.domain.WhoIs

@Component
class WhoisServiceClient(val httpClient: RestTemplate) {

    val url = "http://whois-service"

    fun whois(domain: String): WhoIs {
        return httpClient.getForObject("$url/api/whois?domain=$domain", WhoIs::class.java)!!
    }
}
