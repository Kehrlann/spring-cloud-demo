package wf.garnier.domainpicker

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.springframework.web.reactive.function.client.WebClient
import wf.garnier.domain.Domain
import wf.garnier.domainpicker.mockserver.MockServer


class DomainServiceClientTest {
    private val server = MockServer()
    private val underTest = DomainServiceClient(WebClient.builder(), server.url())

    @Test
    fun `it should call the domain service over http`() {
        server.addJsonResponse("""{"domains": [{ "name": "example", "extension" : "com", "available": true }]}""")

        val domains = underTest.listDomains("anything").toIterable()

        assertThat(domains).containsExactlyInAnyOrder(Domain("example", "com", true))
    }

    @Test
    fun `it should extract domains from the response`() {
        server.addJsonResponse("")
        underTest.listDomains("anything").blockLast()
        assertThat(server.requestUrl()).matches(".*domains\\?search=anything\$")
    }
}