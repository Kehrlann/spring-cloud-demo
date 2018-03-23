package wf.garnier.domainpicker

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import java.net.URI

@RestController
class DomainLister(@Value("\${domains.base_url:}") val baseUrl: String) {

    @GetMapping("/domains")
    fun getDomains(@RequestParam("search") searchTerm: String): Flux<String> {
        val url =
            "$baseUrl?currency=EUR&lang=en&page=1&per_page=30&search=$searchTerm"

        return WebClient.create()
            .get()
            .uri(URI(url))
            .accept(MediaType.TEXT_EVENT_STREAM)
            .header("Referer", "https://shop.gandi.net/en/domain/suggest")
            .exchange()
            .flatMapMany { r -> r.bodyToFlux(String::class.java) }
    }
}