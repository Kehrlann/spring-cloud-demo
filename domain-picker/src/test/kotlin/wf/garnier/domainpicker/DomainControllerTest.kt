package wf.garnier.domainpicker

import com.nhaarman.mockito_kotlin.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import wf.garnier.domain.Domain
import wf.garnier.domain.DomainListResponse

class DomainControllerTest {
    private val expectedResponse = DomainListResponse(domains =  listOf(Domain("example", "com", true)))
    private val client:DomainServiceClient = mock {
        on { listDomains(any()) } doReturn expectedResponse
    }

    @Test
    fun `it calls the domain service client`() {
        val controller = DomainController(client)

        controller.getAll("example")
        verify(client, times(1)).listDomains("example")
    }

    @Test
    fun `it returns relevant data`() {
        val controller = DomainController(client)

        val domains = controller.getAll("example")

        assertThat(domains).isEqualTo(expectedResponse.domains.map { AugmentedDomain(it) })
    }
}