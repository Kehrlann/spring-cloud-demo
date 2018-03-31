package wf.garnier.domainpicker

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class PricingServiceClient(val httpClient: RestTemplate) {
    private val url = "http://pricing-service"

    @HystrixCommand(defaultFallback = "fakePrice")
    fun price(domain: String): Int = httpClient.getForObject("$url/api/price?domain=$domain", Int::class.java)!!

    fun fakePrice() = -1
}
