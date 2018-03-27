package wf.garnier.whoisservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import wf.garnier.domain.WhoIs
import java.time.Duration
import java.time.LocalDate
import java.util.*

@RestController
class WhoisController {

    @GetMapping("/api/whois")
    fun whois(@RequestParam("domain") domain: String): Flux<WhoIs> =
        Flux
            .just(WhoIs(company(domain), "admin@$domain", LocalDate.now()))
            .delayElements(Duration.ofMillis(1000 + Random().nextInt(1000).toLong()))

    fun company(domain: String) = domain.split(".").asReversed()[1] + ", corp."
}