package wf.garnier.domainpicker

import com.nhaarman.mockito_kotlin.*
import org.junit.Test
import org.springframework.web.client.RestTemplate
import wf.garnier.domain.DomainListResponse

class DomainServiceClientTest {
    @Test
    fun `it should call the domain service over http`() {
        val httpClient: RestTemplate = mock {
            on { getForObject(any<String>(), eq(DomainListResponse::class.java)) } doReturn DomainListResponse()
        }
        val serviceCLient = DomainServiceClient(httpClient)

        serviceCLient.listDomains("anything")

        verify(httpClient, times(1)).getForObject(
                        eq("http://domain-service/api/domains?search=anything"),
                        eq(DomainListResponse::class.java)
                )
    }
}