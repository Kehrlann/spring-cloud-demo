package wf.garnier.domain

import java.time.LocalDate
import java.time.LocalDateTime

data class Domain(
    val name: String = "",
    val extension: String = "",
    val available: Boolean = false
)

data class WhoIs(val company: String, val contact: String, val validUntil: LocalDate)

data class DomainListResponse(
        val date: LocalDateTime = LocalDateTime.now(),
        val domains: Collection<Domain> = listOf()
)