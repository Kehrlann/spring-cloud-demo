package wf.garnier.whoisservice

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.time.LocalDate
import kotlin.system.measureTimeMillis

class WhoisControllerTest {

    @Test
    fun `it returns whois information`() {
        val controller = WhoisController(0.1F)

        val processingTime = measureTimeMillis {
            controller.whois("example.com").block()
        }

        // TODO: use virtual time ?
        assertThat(processingTime).isGreaterThan(100)
        assertThat(processingTime).isLessThan(200 + 250)  // max delay time + a safe margin for processing time
    }

    @Test
    fun `returns the admin for the domain, and an expiration date within 2 years`() {
        val controller = WhoisController(0.1F)

        val (company, contact, validUntil) = controller.whois("example.com").block()!!

        assertThat(company).isEqualToIgnoringCase("example, corp.")
        assertThat(contact).isEqualTo("admin@example.com")
        assertThat(validUntil).isBefore(LocalDate.now().plusYears(2))
    }
}