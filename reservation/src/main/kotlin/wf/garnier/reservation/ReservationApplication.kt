package wf.garnier.reservation

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class ReservationApplication

fun main(args: Array<String>) {
    SpringApplication.run(ReservationApplication::class.java, *args)
}
