package wf.garnier.domainpicker

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import wf.garnier.domain.Domain

@RestController
class DomainController {
    @GetMapping("/api/domains")
    fun getAll(@RequestParam("search") search: String): Collection<Domain> = listOf()
}