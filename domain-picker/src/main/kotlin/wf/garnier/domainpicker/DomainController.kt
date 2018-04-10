package wf.garnier.domainpicker

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import wf.garnier.domain.Domain
import wf.garnier.domain.WhoIs

@RestController
class DomainController(
        val domainClient: DomainServiceClient,
        val pricingClient: PricingServiceClient,
        val whoisClient: WhoisServiceClient
) {
    @GetMapping("/api/domains")
    fun getAll(@RequestParam("search") search: String): Flux<AugmentedDomain> =
            domainClient.listDomains(search)
                    .map { AugmentedDomain(it) }
                    .map {
                        if (it.available) {
                            val price = pricingClient.getPrice(it.fullname)
                            it.copy(price = price)
                        } else {
                            it
                        }
                    }
                    .toFlux()
                    .flatMap {
                        val augDom = it
                        if (it.available) {
                            Mono.just(it)
                        } else {
                            whoisClient.whois(it.fullname)
                                    .map {
                                        augDom.copy(whois = it)
                                    }
                        }
                    }
    // TODO: about 22 minutes
}


data class AugmentedDomain(
        val name: String,
        val extension: String,
        val available: Boolean,
        val whois: WhoIs? = null,
        val price: Int = 0
) {
    val fullname: String
        get() = "$name.$extension"

    constructor(domain: Domain) : this(domain.name, domain.extension, domain.available)
}