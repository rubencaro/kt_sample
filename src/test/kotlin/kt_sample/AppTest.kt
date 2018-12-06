package kt_sample

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertEquals

class AppTests {
    @Test fun testAppHasAGreeting() {
        val app = App()
        assertNotNull(app.greeting, "app should have a greeting")
        assertEquals(app.greeting, "Hello world.")
    }
}
