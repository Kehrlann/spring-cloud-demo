package wf.garnier.domain

import java.time.LocalDate

data class Domain(
    val name: String = "",
    val extension: String = "",
    val available: Boolean = false
)

data class WhoIs(val company: String, val contact: String, val validUntil: LocalDate)