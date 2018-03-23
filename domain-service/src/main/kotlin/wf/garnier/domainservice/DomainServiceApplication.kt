package wf.garnier.domainservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DomainServiceApplication

fun main(args: Array<String>) {
    runApplication<DomainServiceApplication>(*args)
}
