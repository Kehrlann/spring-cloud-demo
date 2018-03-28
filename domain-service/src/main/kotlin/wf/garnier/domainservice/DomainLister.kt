package wf.garnier.domainservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import wf.garnier.domain.Domain

@RestController
class DomainLister(val config: DomainServiceConfiguration) {

    init {
        println(config.extensions)
    }

    // TODO : make some unavailable
    @GetMapping("/api/domains")
    fun getDomains(@RequestParam("search") searchTerm: String) = config.extensions.map { Domain(searchTerm, it, true) }
}