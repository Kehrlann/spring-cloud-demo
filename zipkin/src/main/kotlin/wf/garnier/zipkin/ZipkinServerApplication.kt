package wf.garnier.zipkin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import zipkin.server.internal.EnableZipkinServer

@SpringBootApplication
@EnableZipkinServer
class ZipkinServerApplication

fun main(args: Array<String>) {
    SpringApplication.run(ZipkinServerApplication::class.java, *args)
}
