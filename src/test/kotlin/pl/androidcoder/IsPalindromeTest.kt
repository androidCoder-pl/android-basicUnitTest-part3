package pl.androidcoder

import org.hamcrest.MatcherAssert
import org.junit.Test

class IsPalindromeTest {

    @Test(expected = AssertionError::class)
    fun nullIsNotPalindrome() {
        MatcherAssert.assertThat(null, isPalindrome())
    }

    @Test(expected = AssertionError::class)
    fun emptyStringIsNotPalindrome() {
        MatcherAssert.assertThat("", isPalindrome())
    }

    @Test(expected = AssertionError::class)
    fun blankStringIsNotPalindrome() {
        MatcherAssert.assertThat("      ", isPalindrome())
    }

    @Test(expected = AssertionError::class)
    fun testNotPalindromeString() {
        MatcherAssert.assertThat("not palindrome", isPalindrome())
    }

    @Test
    fun testPalindrome() {
        MatcherAssert.assertThat("a", isPalindrome())
        MatcherAssert.assertThat("aa", isPalindrome())
        MatcherAssert.assertThat("aba", isPalindrome())
        MatcherAssert.assertThat("abcba", isPalindrome())
        MatcherAssert.assertThat("kajak", isPalindrome())
    }

    @Test(expected = AssertionError::class)
    fun nullIsNotPalindromeIgnoreCase() {
        MatcherAssert.assertThat(null, isPalindromeIgnoreCase())
    }

    @Test(expected = AssertionError::class)
    fun emptyStringIsNotPalindromeIgnoreCase() {
        MatcherAssert.assertThat("", isPalindromeIgnoreCase())
    }

    @Test(expected = AssertionError::class)
    fun blankStringIsNotPalindromeIgnoreCase() {
        MatcherAssert.assertThat("      ", isPalindromeIgnoreCase())
    }

    @Test(expected = AssertionError::class)
    fun testNotPalindromeStringIgnoreCase() {
        MatcherAssert.assertThat("not palindrome", isPalindromeIgnoreCase())
    }

    @Test
    fun testPalindromeIgnoreCase() {
        MatcherAssert.assertThat("A", isPalindromeIgnoreCase())
        MatcherAssert.assertThat("aA", isPalindromeIgnoreCase())
        MatcherAssert.assertThat("aba", isPalindromeIgnoreCase())
        MatcherAssert.assertThat("AbCba", isPalindromeIgnoreCase())
        MatcherAssert.assertThat("kAjaK", isPalindromeIgnoreCase())
    }
}