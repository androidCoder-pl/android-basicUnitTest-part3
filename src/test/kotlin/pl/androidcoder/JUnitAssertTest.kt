package pl.androidcoder

import org.junit.Assert
import org.junit.Test

class JUnitAssertTest{
    @Test
    fun testAssertTrue() {
        val value = true
        Assert.assertTrue(value)
    }

    @Test(expected = AssertionError::class)
    fun testFailingAssertTrue() {
        val value = false
        Assert.assertTrue(value)
    }

    @Test
    fun testAssertFalse() {
        val value = false
        Assert.assertFalse(value)
    }

    @Test(expected = AssertionError::class)
    fun testFailingAssertFalse() {
        val value = true
        Assert.assertFalse(value)
    }

    @Test(expected = AssertionError::class)
    fun testFail() {
        Assert.fail("This should throw AssertionError")
    }

    @Test()
    fun testFailWithMessage() {
        val expectedMessage = "This should throw AssertionError"
        try {
            Assert.fail(expectedMessage)
        } catch (e: AssertionError) {
            Assert.assertEquals(e.message, expectedMessage)
            return
        }
        throw AssertionError("Assertion error expected")
    }

    @Test
    fun testAssertEquals() {
        val any = Any()
        Assert.assertEquals(any, any)
        Assert.assertEquals("some", "some")
        Assert.assertEquals(false, false)
        Assert.assertEquals(true, true)
        Assert.assertEquals(1, 1)
        Assert.assertEquals(1L, 1L)
        Assert.assertEquals(TestData("some", 1), TestData("some", 1))
    }

    @Test(expected = AssertionError::class)
    fun testFailingAssertEquals() {
        val any1 = Any()
        val any2 = Any()
        Assert.assertEquals(any1, any2)
        Assert.assertEquals("some", "some2")
        Assert.assertEquals(false, true)
        Assert.assertEquals(true, false)
        Assert.assertEquals(1, 2)
        Assert.assertEquals(1L, 2L)
        Assert.assertEquals(TestData("some", 2), TestData("some", 1))
    }

    @Test
    fun testAssertNotEquals() {
        val any1 = Any()
        val any2 = Any()
        Assert.assertNotEquals(any1, any2)
        Assert.assertNotEquals("some", "some2")
        Assert.assertNotEquals(false, true)
        Assert.assertNotEquals(true, false)
        Assert.assertNotEquals(1, 2)
        Assert.assertNotEquals(1L, 2L)
        Assert.assertNotEquals(TestData("some", 2), TestData("some", 1))
    }

    @Test(expected = AssertionError::class)
    fun testFailingAssertNotEquals() {
        val any = Any()
        Assert.assertNotEquals(any, any)
        Assert.assertNotEquals("some", "some")
        Assert.assertNotEquals(false, false)
        Assert.assertNotEquals(true, true)
        Assert.assertNotEquals(1, 1)
        Assert.assertNotEquals(1L, 1L)
        Assert.assertNotEquals(TestData("some", 1), TestData("some", 1))
    }

    @Test
    fun testAssertEqualsFloat() {
        Assert.assertEquals(1.1f, 1.1f, 0.0f)
        Assert.assertEquals(1.1, 1.1, 0.0)
        Assert.assertEquals(1.1001f, 1.1f, 0.001f)
        Assert.assertEquals(1.1001, 1.1, 0.001)
    }

    @Test(expected = AssertionError::class)
    fun testFailAssertEqualsFloat() {
        Assert.assertEquals(1.1001f, 1.1f, 0.0f)
        Assert.assertEquals(1.1001, 1.1, 0.0)
    }

    @Test(expected = AssertionError::class)
    fun testFailAssertNotEqualsFloat() {
        Assert.assertNotEquals(1.1f, 1.1f, 0.0f)
        Assert.assertNotEquals(1.1, 1.1, 0.0)
        Assert.assertNotEquals(1.1001f, 1.1f, 0.001f)
        Assert.assertNotEquals(1.1001, 1.1, 0.001)
    }

    @Test
    fun testAssertNotEqualsFloat() {
        Assert.assertNotEquals(1.1001f, 1.1f, 0.0f)
        Assert.assertNotEquals(1.1001, 1.1, 0.0)
    }

    @Test
    fun testAssertArrayEquals() {
        val expectedArray = arrayOf(1, 2, 3, 4)
        val actualArray = arrayOf(1, 2, 3, 4)
        Assert.assertArrayEquals(expectedArray, actualArray)
    }

    @Test(expected = AssertionError::class)
    fun failingTestAssertArrayEquals() {
        val expectedArray = arrayOf(1, 2, 3, 4)
        val actualArray = arrayOf(1, 2, 4, 3)
        Assert.assertArrayEquals(expectedArray, actualArray)
    }

    @Test
    fun testAssertNotNull() {
        Assert.assertNotNull(Any())
    }


    @Test(expected = AssertionError::class)
    fun testFailAssertNotNull() {
        Assert.assertNotNull(null)
    }

    @Test
    fun testAssertNull() {
        Assert.assertNull(null)
    }

    @Test(expected = AssertionError::class)
    fun testFailAssertNull() {
        Assert.assertNull(Any())
    }

    @Test(expected = AssertionError::class)
    fun testFailingAssertSame() {
        Assert.assertSame(TestData("some", 1), TestData("some", 1))
    }

    @Test
    fun testAssertSame() {
        val testData = TestData("some", 1)
        Assert.assertSame(testData, testData)
    }

    @Test
    fun testFailingAssertNotSame() {
        Assert.assertNotSame(TestData("some", 1), TestData("some", 1))
    }

    @Test(expected = AssertionError::class)
    fun testAssertNotSame() {
        val testData = TestData("some", 1)
        Assert.assertNotSame(testData, testData)
    }
}