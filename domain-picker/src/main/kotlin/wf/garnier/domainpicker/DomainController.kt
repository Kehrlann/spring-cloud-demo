package wf.garnier.domainpicker

import org.springframework.web.bind.annotation.RestController

@RestController
class DomainController(val domainClient: DomainServiceClient) {
    fun getAll() =
        domainClient.listDomains().map { AugmentedDomain(it) }

}