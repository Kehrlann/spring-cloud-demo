package wf.garnier.domainpicker

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class DomainController(
        val domainClient: DomainServiceClient,
        val pricingClient: PricingServiceClient
) {

    @GetMapping("/api/domains")
    fun getAll(@RequestParam("search") search: String): Collection<AugmentedDomain> =
            domainClient.listDomains(search).domains
                    .map { AugmentedDomain(it) }
                    .map {
                        val price = if(!it.available) 0 else pricingClient.price(it.fullName())
                        it.copy(price = price)
                    }
}