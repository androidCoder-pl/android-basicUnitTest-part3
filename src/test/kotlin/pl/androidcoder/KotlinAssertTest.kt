package pl.androidcoder

import org.junit.Assert
import org.junit.Test

class KotlinAssertTest {

    @Test
    fun testAssertion() {
        assert(true)
    }

    @Test(expected = AssertionError::class)
    fun testFailAssertion() {
        assert(false)
    }

    @Test
    fun testFailAssertionWithMessage() {
        val expectedMessage = "This message show when test failed"
        try {
            assert(false) { expectedMessage }
        } catch (e: AssertionError) {
            Assert.assertEquals(expectedMessage, e.message)
            return
        }
        throw AssertionError("Assertion error expected")
    }
}