package pl.androidcoder

import org.junit.Test

class AssertPalindromeTest {
    @Test(expected = AssertionError::class)
    fun emptyStringIsNotPalindrome() {
        assertPalindrome("")
    }

    @Test(expected = AssertionError::class)
    fun blankStringIsNotPalindrome() {
        assertPalindrome("      ")
    }

    @Test(expected = AssertionError::class)
    fun testNotPalindromeString() {
        assertPalindrome("not palindrome")
    }

    @Test
    fun testAssertPalindrome() {
        assertPalindrome("a")
        assertPalindrome("aa")
        assertPalindrome("aba")
        assertPalindrome("abcba")
        assertPalindrome("kajak")
    }
}