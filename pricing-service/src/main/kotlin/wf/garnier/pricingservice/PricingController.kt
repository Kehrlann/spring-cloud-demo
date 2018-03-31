package wf.garnier.pricingservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PricingController {

    @GetMapping("/api/price")
    fun getPrice(@RequestParam("domain") domain: String) = 5 + domain.length
}