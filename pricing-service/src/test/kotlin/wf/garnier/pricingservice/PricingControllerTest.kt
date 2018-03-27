package wf.garnier.pricingservice

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PricingControllerTest {

    @Test
    fun `it returns the price`() {
        val controller = PricingController()

        val price = controller.getPrice("test.com")

        assertThat(price).isEqualTo(13)
    }
}