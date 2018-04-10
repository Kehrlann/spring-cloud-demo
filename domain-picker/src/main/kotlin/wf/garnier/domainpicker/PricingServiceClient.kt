package wf.garnier.domainpicker

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class PricingServiceClient(val httpClient: RestTemplate) {

    val url = "http://pricing-service"

    @HystrixCommand(defaultFallback = "fakePrice")
    fun getPrice(domain: String): Int =
            httpClient.getForObject("$url/api/price?domain=$domain", Int::class.java)!!

    // TODO : 14 minutes here

    private fun fakePrice(): Int = -1
}