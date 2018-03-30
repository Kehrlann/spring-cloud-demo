package wf.garnier.domainpicker

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class DomainController(val domainClient: DomainServiceClient) {

    @GetMapping("/api/domains")
    fun getAll(@RequestParam("search") search: String) =
        domainClient.listDomains(search).domains.map { AugmentedDomain(it) }

}