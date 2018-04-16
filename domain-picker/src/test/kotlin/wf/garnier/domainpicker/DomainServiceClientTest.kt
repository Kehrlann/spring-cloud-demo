package wf.garnier.domainpicker

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.springframework.web.client.RestTemplate
import wf.garnier.domain.Domain
import wf.garnier.domainpicker.mockserver.MockServer


class DomainServiceClientTest {
    private val server = MockServer()
    private val underTest = DomainServiceClient(RestTemplate(), server.url())

    @Test
    fun `it should call the domain service over http`() {
        server.addJsonResponse("")
        underTest.listDomains("anything")
        assertThat(server.requestUrl()).matches(".*domains\\?search=anything\$")
    }

    @Test
    fun `it should extract domains from the response`() {
        server.addJsonResponse("""{"domains": [{ "name": "example", "extension" : "com", "available": true }]}""")

        val domains = underTest.listDomains("anything")

        assertThat(domains).containsExactlyInAnyOrder(Domain("example", "com", true))
    }
}
