package wf.garnier.domainservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import wf.garnier.domain.Domain
import wf.garnier.domain.DomainListResponse

@RestController
class DomainController(val config: DomainServiceConfiguration) {

    // TODO : make some unavailable
    @GetMapping("/api/domains")
    fun getDomains(@RequestParam("search") searchTerm: String) =
            DomainListResponse(domains = config.extensions.map { Domain(searchTerm, it, true) })
}