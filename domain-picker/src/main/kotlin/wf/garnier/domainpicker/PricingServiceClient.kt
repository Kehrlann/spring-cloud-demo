package wf.garnier.domainpicker

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Component
class PricingServiceClient(val feignClient: PricingFeignClient) {
    @HystrixCommand(defaultFallback = "fakePrice")
    fun price(domain: String): Int = feignClient.price(domain)

    fun fakePrice() = -1
}


@Component
@FeignClient("pricing-service")
interface PricingFeignClient {
    @RequestMapping("/api/price")
    fun price(@RequestParam("domain") domain: String): Int
}