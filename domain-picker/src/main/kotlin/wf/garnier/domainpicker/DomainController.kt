package wf.garnier.domainpicker

import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class DomainController(
        val domainClient: DomainServiceClient,
        val pricingClient: PricingServiceClient,
        val whoisClient: WhoisServiceClient,
        val repo: ReservationRepository
) {
    @GetMapping("/api/reservation")
    fun getReservations() = repo.findAll()

    @PostMapping("/api/reservation")
    fun addReservation(@RequestBody reservation: Reservation) = repo.save(reservation)

    @GetMapping("/api/domains")
    fun getAll(@RequestParam("search") search: String): Flux<AugmentedDomain> =
            domainClient.listDomains(search)
                    .map { AugmentedDomain(it) }
                    .map {
                        val price = if (!it.available) 0 else pricingClient.price(it.fullName())
                        it.copy(price = price)
                    }
                    .flatMap {
                        val augDom = it
                        when (it.available) {
                            true -> Mono.just(it)
                            false -> whoisClient.whois(it.fullName()).map { augDom.copy(whois = it) }
                        }
                    }
}