package wf.garnier.domainpicker

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.springframework.web.reactive.function.client.WebClient
import wf.garnier.domain.WhoIs
import wf.garnier.domainpicker.mockserver.MockServer

class WhoisServiceClientTest {
    private val expectedDomain = "example.com"
    private val mockServer = MockServer()

    private val underTest = WhoisServiceClient(WebClient.builder(), mockServer.url())

    @Test
    fun `it should call the whois service`() {
        mockServer.addJsonResponse("{}")
        underTest.whois(expectedDomain).block()

        assertThat(mockServer.requestUrl()).matches(".*whois\\?domain=$expectedDomain\$")
    }

    @Test
    fun `it should get relevant information`() {
        mockServer.addJsonResponse("""{ "company" : "example", "contact": "admin@example.com" }""")
        val whois = underTest.whois(expectedDomain).block()

        assertThat(whois).isEqualTo(WhoIs("example", "admin@example.com"))
    }
}