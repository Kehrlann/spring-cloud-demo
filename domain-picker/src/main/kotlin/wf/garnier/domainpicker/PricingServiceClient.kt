package wf.garnier.domainpicker

import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class PricingServiceClient(val httpClient: RestTemplate) {
    private val url = "http://pricing-service"

    fun price(domain: String): Int = httpClient.getForObject("$url/api/price?domain=$domain", Int::class.java)!!
}
