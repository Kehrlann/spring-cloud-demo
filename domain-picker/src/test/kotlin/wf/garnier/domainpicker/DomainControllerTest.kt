package wf.garnier.domainpicker

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.*
import wf.garnier.domain.Domain

class DomainControllerTest {

    @Test
    fun `it calls the domain service client`() {
        val client = mock(DomainServiceClient::class.java)
        val controller = DomainController(client)

        controller.getAll()
        verify(client, times(1)).listDomains()
    }

    @Test
    fun `it returns relevant data`() {
        val expectedDomains = listOf(AugmentedDomain("example", "com", true))

        val client = mock(DomainServiceClient::class.java)
        whenever(client.listDomains()).thenReturn(listOf(Domain("example", "com", true)))
        val controller = DomainController(client)

        val domains = controller.getAll()

        assertThat(domains).isEqualTo(expectedDomains)
    }
}

fun <T> whenever(call: T) = Mockito.`when`(call)!!