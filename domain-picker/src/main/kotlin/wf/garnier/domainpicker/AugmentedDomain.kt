package wf.garnier.domainpicker

import wf.garnier.domain.Domain

data class AugmentedDomain(val name: String, val extension: String, val available: Boolean) {
    constructor(domain: Domain) : this(domain.name, domain.extension, domain.available)
}