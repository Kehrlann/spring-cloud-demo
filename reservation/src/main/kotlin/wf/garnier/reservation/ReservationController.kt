package wf.garnier.reservation

import org.springframework.web.bind.annotation.*

@RestController
class ReservationController(val repo: ReservationRepository) {

    @GetMapping("/hi")
    fun sayHi(@RequestParam("name", defaultValue = "World") name: String?) = "Hello, $name !\n"

    @GetMapping("/api/reservation")
    fun listReservations() = repo.findAll()

    @PostMapping("/api/reservation")
    fun addReservation(@RequestBody reservation: Reservation) = repo.save(reservation)
}