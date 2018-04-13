package wf.garnier.whoisservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import wf.garnier.domain.WhoIs
import java.time.Duration
import java.time.LocalDate
import java.util.*

@RestController
class WhoisController {

    private val DELAY_FACTOR = 1

    @GetMapping("/api/whois")
    fun whois(@RequestParam("domain") domain: String): Mono<WhoIs> =
        Mono
            .just(WhoIs(company(domain), "admin@$domain", LocalDate.now()))
            .delayElement(Duration.ofMillis(randomDuration()))

    fun company(domain: String) = domain.split(".").asReversed()[1] + ", corp."

    private fun randomDuration(): Long = (DELAY_FACTOR * (1000 + Random().nextInt(1000))).toLong()
}
