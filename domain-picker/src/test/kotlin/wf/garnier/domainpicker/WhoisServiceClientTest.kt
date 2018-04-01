package wf.garnier.domainpicker

import com.nhaarman.mockito_kotlin.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.springframework.web.client.RestTemplate
import wf.garnier.domain.WhoIs

class WhoisServiceClientTest {
    val expectedDomain = "example.com"
    val expectedWhois = WhoIs(company = "test")

    val httpClient: RestTemplate = mock {
        on { getForObject(any<String>(), any<Class<*>>()) } doReturn expectedWhois
    }

    val client = WhoisServiceClient(httpClient)

    @Test
    fun `it should call the whois service`() {
        client.whois(expectedDomain)

        verify(httpClient).getForObject(
                argThat<String> { endsWith("whois?domain=$expectedDomain") },
                eq(WhoIs::class.java)
        )
    }

    @Test
    fun `it should get relevant information`() {
        val whois = client.whois(expectedDomain)

        assertThat(whois).isEqualTo(expectedWhois)
    }
}