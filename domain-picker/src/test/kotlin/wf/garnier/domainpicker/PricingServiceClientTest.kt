package wf.garnier.domainpicker

import com.nhaarman.mockito_kotlin.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.springframework.web.client.RestTemplate

class PricingServiceClientTest {
    @Test
    fun `it should call the pricing-service and get the price`() {
        val expectedPrice = 13
        val expectedDomain = "example.com"

        val httpClient: RestTemplate = mock {
            on { getForObject(any<String>(), any<Class<*>>()) } doReturn expectedPrice
        }
        val client = PricingServiceClient(httpClient)

        val price = client.price(expectedDomain)

        verify(httpClient).getForObject(
                argThat<String> { endsWith("price?domain=$expectedDomain") },
                eq(Int::class.java)
        )
        assertThat(price).isEqualTo(expectedPrice)
    }
}