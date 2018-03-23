package wf.garnier.whoisservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WhoisServiceApplication

fun main(args: Array<String>) {
    runApplication<WhoisServiceApplication>(*args)
}
