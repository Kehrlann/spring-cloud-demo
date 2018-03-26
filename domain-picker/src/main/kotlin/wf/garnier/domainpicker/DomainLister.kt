package wf.garnier.domainpicker

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import wf.garnier.domain.Domain

@RestController
class DomainLister(@Value("\${extensions:}") val extensions: Collection<String>) {

    // TODO: Make some unavaialble ?
    @GetMapping("/domains")
    fun getDomains(@RequestParam("search") searchTerm: String) =
        Flux.fromIterable(extensions)
            .map { Domain(searchTerm, it, true) }
}