package wf.garnier.domainpicker

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import wf.garnier.domain.Domain

class DomainListerTest {
    val domainLister = DomainLister(listOf("com", "org", "io"))

    @Test
    fun `it lists domains`() {
        val expectedDomains = listOf(
            Domain("test", "com", true),
            Domain("test", "org", true),
            Domain("test", "io", true)
        )
        val domains = domainLister.getDomains("test").toIterable().toList()

        assertThat(domains).isEqualTo(expectedDomains)
    }
}