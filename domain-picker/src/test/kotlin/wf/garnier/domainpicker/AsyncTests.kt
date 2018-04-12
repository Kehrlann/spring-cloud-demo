package wf.garnier.domainpicker

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.util.concurrent.CompletableFuture
import kotlin.system.measureTimeMillis

class AsyncTests {

    @Test
    fun `simple future`() {
        val future = CompletableFuture.supplyAsync {
            Thread.sleep(100L)
            "true"
        }

        val time = measureTimeMillis {
            future.get()
        }

        assertThat(time).isGreaterThan(99L)
        assertThat(time).isLessThan(150L)
        println("One future takes ${time}ms")
    }

    @Test
    fun `sleeping futures are slow`() {
        val numberOfFutures = 100
        val time = measureTimeMillis {
            (1..numberOfFutures)
                    .map {
                        CompletableFuture.supplyAsync {
                            Thread.sleep(100L)
                            it
                        }
                    }
                    .map {
                        it.join()
                    }
        }
        assertThat(time).isGreaterThan(1000L)
        println("$numberOfFutures futures take ${time}ms")
    }

    @Test
    fun `reactor is fun`() {
        val mono = Mono.just(1).delayElement(Duration.ofMillis(100))

        val time = measureTimeMillis {
            mono.block()
        }

        assertThat(time).isGreaterThan(99L)
        assertThat(time).isLessThan(150L)
        println("One mono takes ${time}ms")
    }

    @Test
    fun `reactor is highly concurrent, but not magic`() {
        val numberOfMonos = 1000
        val flux = Flux.fromIterable((1..numberOfMonos))
                .flatMap {
                    Mono.just(it).delayElement(Duration.ofMillis(100))
                }


        val time = measureTimeMillis {
            flux.blockLast()
        }

        assertThat(time).isLessThan(1000L)
        println("$numberOfMonos monos take ${time}ms")
    }
}