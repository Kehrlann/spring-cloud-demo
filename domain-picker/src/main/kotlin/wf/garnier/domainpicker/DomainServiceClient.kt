package wf.garnier.domainpicker

import org.springframework.stereotype.Component
import wf.garnier.domain.Domain

@Component
class DomainServiceClient {

    fun listDomains(): Collection<Domain> = listOf()
}