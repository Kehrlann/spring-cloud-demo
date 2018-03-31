package wf.garnier.domainservice

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import wf.garnier.domain.Domain

class DomainControllerTest {
    val domainLister = DomainController(DomainServiceConfiguration(mutableListOf("com", "org", "io")))

    @Test
    fun `it lists domains`() {
        val expectedDomains = listOf(
            Domain("test", "com", true),
            Domain("test", "org", true),
            Domain("test", "io", true)
        )
        val domainListResponse = domainLister.getDomains("test")

        assertThat(domainListResponse.domains).isEqualTo(expectedDomains)
    }
}

@RunWith(SpringRunner::class)
@WebMvcTest(DomainServiceConfiguration::class, DomainController::class)
class DomainControllerControllerTest {

    private val expectedDomains = listOf(
        Domain("test", "com", true),
        Domain("test", "org", true),
        Domain("test", "io", true)
    )

    @Autowired
    lateinit var mvc: MockMvc

    @Test
    fun `has correct domains`() {
        mvc.perform(get("/api/domains?search=test"))
            .andExpect(jsonPath(".domains.[*].name").value(expectedDomains.map { it.name }))
            .andExpect(jsonPath(".domains.[*].extension").value(expectedDomains.map { it.extension }))
            .andExpect(jsonPath(".domains.[*].available").value(expectedDomains.map { it.available }))
    }
}