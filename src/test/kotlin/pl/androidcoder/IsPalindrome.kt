package pl.androidcoder

import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

fun isPalindrome() = IsPalindrome(false)
fun isPalindromeIgnoreCase() = IsPalindrome(true)


class IsPalindrome(
        private val ignoreCase: Boolean
) : TypeSafeMatcher<String>() {

    override fun describeTo(description: Description) {
        description.appendText("a palindrome string")
    }

    override fun describeMismatchSafely(item: String, mismatchDescription: Description) {
        mismatchDescription.appendText("\"$item\" is not equal" +
                " to being reversed : \"${item.reversed()}\"")
    }

    override fun matchesSafely(item: String?): Boolean {
        return !item.isNullOrBlank() && checkPalindrome(item!!)
    }

    private fun checkPalindrome(item: String): Boolean {
        return item.reversed().equals(item, ignoreCase)
    }
}