package pl.androidcoder

fun assertPalindrome(text: String) {
    assert(text.isNotBlank() && text.reversed() == text) {
        "\"$text\" is not palindrome.\"$text\" is not equal" +
                " to being reversed : \"${text.reversed()}\""
    }
}