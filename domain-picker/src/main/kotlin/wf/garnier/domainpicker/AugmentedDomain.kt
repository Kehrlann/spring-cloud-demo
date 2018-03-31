package wf.garnier.domainpicker

import wf.garnier.domain.Domain
import wf.garnier.domain.WhoIs

data class AugmentedDomain(
        val name: String,
        val extension: String,
        val available: Boolean,
        val whois: WhoIs? = null,
        val price: Int = 0
) {
    constructor(domain: Domain) : this(domain.name, domain.extension, domain.available)
    fun fullName() = "$name.$extension"
}