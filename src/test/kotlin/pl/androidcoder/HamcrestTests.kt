package pl.androidcoder

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.hamcrest.Matchers.*
import org.junit.Test
import java.util.regex.Pattern

class HamcrestTests {
    @Test
    fun testEqualTo() {
        assertThat(1, equalTo(1))
        assertThat("abc", equalTo("abc"))
        assertThat("abc", equalTo("abc"))
        assertThat(true, equalTo(true))
        assertThat(false, equalTo(false))
        assertThat(TestData("some", 1), equalTo(TestData("some", 1)))
    }

    @Test(expected = AssertionError::class)
    fun testFailingEqualTo() {
        assertThat(1, equalTo(2))
    }

    //instanceOf

    @Test
    fun testInstanceOf() {
        val testData: Thing = SubtypeThingA()
        assertThat(testData, instanceOf(SubtypeThingA::class.java))
    }

    @Test(expected = AssertionError::class)
    fun testFailingInstanceOf() {
        val testData: Thing = SubtypeThingA()
        assertThat(testData, instanceOf(SubtypeThingB::class.java))
    }

    //not

    @Test
    fun testNot() {
        assertThat(1, not(2))
        assertThat(1, not(equalTo(2)))
        assertThat("abc", not("bca"))
        val testData: Thing = SubtypeThingA()
        assertThat(testData, not(instanceOf(SubtypeThingB::class.java)))
    }

    @Test(expected = AssertionError::class)
    fun testFailingNot() {
        assertThat(1, not(1))
    }

    //notNullValue

    @Test
    fun testNotNullValue() {
        assertThat(SubtypeThingA(), notNullValue())
    }

    @Test(expected = AssertionError::class)
    fun testFailingNotNullValue() {
        assertThat(null, notNullValue())
    }

    //notNull

    @Test
    fun testNullValue() {
        assertThat(null, nullValue())
    }

    @Test(expected = AssertionError::class)
    fun testFailingNullValue() {
        assertThat(SubtypeThingA(), nullValue())
    }

    //sameInstance

    @Test
    fun testSameInstance() {
        val testData = TestData("a", 1)
        val testData2 = testData
        assertThat(testData, sameInstance(testData2))
    }

    @Test(expected = AssertionError::class)
    fun testFailingSameInstance() {
        val testData = TestData("a", 1)
        val testData2 = TestData("a", 1)
        assertThat(testData, sameInstance(testData2))
    }

    //is

    @Test
    fun testIs() {
        assertThat(1, `is`(1))
    }

    @Test(expected = AssertionError::class)
    fun testFailingIs() {
        assertThat(1, `is`(2))
    }

    //in

    @Test
    fun testIn() {
        val list = listOf(1, 2, 3, 4)
        assertThat(1, `in`(list))
    }

    @Test(expected = AssertionError::class)
    fun testFailingIn() {
        val list = listOf(1, 2, 3, 4)
        assertThat(5, `in`(list))
    }

    //oneOf
    @Test
    fun testOneOf() {
        assertThat(1, oneOf(1, 2, 3, 4))
    }

    @Test(expected = AssertionError::class)
    fun testFailingOneOf() {
        assertThat(5, oneOf(1, 2, 3, 4))
    }

    //closeTo
    @Test
    fun testCloseTo() {
        assertThat(1.0001, closeTo(1.0, 0.01))
    }


    @Test(expected = AssertionError::class)
    fun testFailingCloseTo() {
        assertThat(1.101, closeTo(1.0, 0.01))
    }

    //notANumber

    @Test
    fun testNotANumber() {
        assertThat(Double.NaN, notANumber())
    }

    @Test(expected = AssertionError::class)
    fun testFailingNotANumber() {
        assertThat(1.0, notANumber())
    }

    //compareEqualTo

    class Tank(
            val name: String,
            val power: Int
    ) : Comparable<Tank> {
        override fun compareTo(other: Tank): Int {
            return when {
                other.power == power -> 0
                other.power > power -> -1
                else -> 1
            }
        }
    }

    @Test
    fun testComparesEqualTo() {
        val sherman1 = Tank("sherman1", 100)
        val sherman2 = Tank("sherman2", 100)
        assertThat(sherman1, comparesEqualTo(sherman2))
    }

    @Test(expected = AssertionError::class)
    fun testFailComparesEqualTo() {
        val panther = Tank("panther", 300)
        val sherman = Tank("sherman", 100)
        assertThat(sherman, comparesEqualTo(panther))
    }

    //greaterThan

    @Test
    fun testGreaterThan() {
        val panther = Tank("panther", 300)
        val sherman = Tank("sherman", 100)
        assertThat(panther, greaterThan(sherman))
    }

    @Test(expected = AssertionError::class)
    fun testFailingGreaterThan() {
        val sherman1 = Tank("sherman1", 100)
        val sherman2 = Tank("sherman2", 100)
        assertThat(sherman1, greaterThan(sherman2))
    }

    //greaterThanOrEqualTo

    @Test
    fun testGreaterThanOrEqualTo() {
        val panther = Tank("panther", 300)
        val panther2 = Tank("panther2", 300)
        val sherman = Tank("sherman1", 100)
        assertThat(panther, greaterThanOrEqualTo(sherman))
        assertThat(panther, greaterThanOrEqualTo(panther2))
    }

    @Test(expected = AssertionError::class)
    fun testFailingGreaterThanOrEqualTo() {
        val panther = Tank("panther", 300)
        val sherman = Tank("sherman1", 100)
        assertThat(sherman, greaterThanOrEqualTo(panther))
    }

    //lessThan

    @Test
    fun testLessThan() {
        val panther = Tank("panther", 300)
        val sherman = Tank("sherman", 100)
        assertThat(panther, greaterThan(sherman))
    }

    @Test(expected = AssertionError::class)
    fun testFailingLessThan() {
        val sherman1 = Tank("sherman1", 100)
        val sherman2 = Tank("sherman2", 100)
        assertThat(sherman1, greaterThan(sherman2))
    }

    //lessThanOrEqualTo

    @Test
    fun testLessThanOrEqualTo() {
        val panther = Tank("panther", 300)
        val panther2 = Tank("panther2", 300)
        val sherman = Tank("sherman1", 100)
        assertThat(sherman, lessThanOrEqualTo(panther))
        assertThat(panther, lessThanOrEqualTo(panther2))
    }

    @Test(expected = AssertionError::class)
    fun testFailingLessThanOrEqualTo() {
        val panther = Tank("panther", 300)
        val sherman = Tank("sherman1", 100)
        assertThat(panther, lessThanOrEqualTo(sherman))
    }

    //typeCompatibleWith

    @Test
    fun testTypeCompatibleWith() {
        val number = Integer(1)
        assertThat(number::class.java, typeCompatibleWith(Number::class.java))
        assertThat(Integer::class.java, typeCompatibleWith(Number::class.java))
    }

    @Test(expected = AssertionError::class)
    fun testFailTypeCompatibleWith() {
        assertThat(String::class.java, typeCompatibleWith(Number::class.java))
    }

    //containsString

    @Test
    fun testContainsString() {
        assertThat("Far Far away", containsString("away"))
    }

    @Test(expected = AssertionError::class)
    fun testFailingContainsString() {
        assertThat("Far Far away", containsString("Away"))
    }

    //containsStringIgnoringCase

    @Test
    fun testContainsStringIgnoringCase() {
        assertThat("Far Far away", containsStringIgnoringCase("Away"))
    }

    @Test(expected = AssertionError::class)
    fun testFailingContainsStringIgnoringCase() {
        assertThat("Far Far away", containsStringIgnoringCase("house"))
    }

    //startsWith

    @Test
    fun testStartsWith() {
        assertThat("Far Far away", startsWith("Far"))
    }

    @Test(expected = AssertionError::class)
    fun testFailingStartsWith() {
        assertThat("Far Far away", startsWith("fAr"))
    }

    //startsWithIgnoringCase

    @Test
    fun testStartsWithIgnoringCase() {
        assertThat("Far Far away", startsWithIgnoringCase("fAr"))
    }

    @Test(expected = AssertionError::class)
    fun testFailingStartsWithIgnoringCase() {
        assertThat("Far Far away", startsWithIgnoringCase("Away"))
    }

    //endsWith

    @Test
    fun testEndsWith() {
        assertThat("Far Far away", endsWith("away"))
    }

    @Test(expected = AssertionError::class)
    fun testFailingEndsWith() {
        assertThat("Far Far away", endsWith("Away"))
    }

    //endsWithIgnoringCase

    @Test
    fun testEndsWithIgnoringCase() {
        assertThat("Far Far away", endsWithIgnoringCase("AwAy"))
    }

    @Test(expected = AssertionError::class)
    fun testFailingEndsWithIgnoringCase() {
        assertThat("Far Far away", endsWithIgnoringCase("far"))
    }

    //matchRegex

    @Test
    fun testMatchRegex() {
        val lineWithNumberPattern = "\\d*[.]\\d*.*"
        val text = "1.2 some text with number"
        assertThat(text, matchesRegex(lineWithNumberPattern))
    }

    @Test(expected = AssertionError::class)
    fun testFailingMatchRegex() {
        val lineWithNumberPattern = "\\d*[.]\\d*.*"
        val text = "some text without number"
        assertThat(text, matchesRegex(lineWithNumberPattern))
    }

    //matchesPattern
    @Test
    fun testMatchesPattern() {
        val lineWithNumberPattern = "\\d*[.]\\d*.*"
        val text = "1.2 some text with number\n"
        assertThat(text, matchesPattern(Pattern.compile(lineWithNumberPattern, Pattern.DOTALL)))
    }

    @Test(expected = AssertionError::class)
    fun testFailingMatchesPattern() {
        val lineWithNumberPattern = "\\d*[.]\\d*.*"
        val text = "1.2 some text with number\n"
        assertThat(text, matchesPattern(Pattern.compile(lineWithNumberPattern)))
    }

    //equalTo
    @Test
    fun testEqualToString() {
        assertThat("abc", equalTo("abc"))
    }

    @Test(expected = AssertionError::class)
    fun testFailingEqualToString() {
        assertThat("abc", equalTo("ABC"))
    }

    //equalTo
    @Test
    fun testEqualToIgnoringCase() {
        assertThat("abc", equalToIgnoringCase("ABC"))
    }

    @Test(expected = AssertionError::class)
    fun testFailingEqualToIgnoringCase() {
        assertThat("abc", equalToIgnoringCase("DEF"))
    }

    //equalToCompressingWhiteSpace
    @Test
    fun testEqualToCompressingWhiteSpace() {
        assertThat("   abc ", equalToCompressingWhiteSpace("abc"))
    }

    @Test(expected = AssertionError::class)
    fun testFailingEqualToCompressingWhiteSpace() {
        assertThat(" a b c  ", equalToCompressingWhiteSpace("abc"))
    }

    //emptyOrNullString
    @Test
    fun testEmptyOrNullString() {
        assertThat("", emptyOrNullString())
        assertThat(null, emptyOrNullString())
    }

    @Test(expected = AssertionError::class)
    fun testFailingEmptyOrNullString() {
        assertThat("  ", emptyOrNullString())
    }

    //emptyString
    @Test
    fun testEmptyString() {
        assertThat("", emptyString())
    }

    @Test(expected = AssertionError::class)
    fun testFailingEmptyString() {
        assertThat(null, emptyString())
    }

    //blankOrNullString
    @Test
    fun testBlankOrNullString() {
        assertThat("", blankOrNullString())
        assertThat("    ", blankOrNullString())
        assertThat("\n", blankOrNullString())
        assertThat(null, blankOrNullString())
    }

    @Test(expected = AssertionError::class)
    fun testFailingBlankOrNullString() {
        assertThat("  .", blankOrNullString())
    }

    //blankString
    @Test
    fun testBlankString() {
        assertThat("", blankString())
        assertThat("    ", blankString())
        assertThat("\n", blankString())
    }

    @Test(expected = AssertionError::class)
    fun testFailingBlankString() {
        assertThat(null, blankString())
    }

    //stringContainsInOrder
    @Test
    fun testStringContainsInOrder() {
        assertThat("1.abc 2.def 3.ghi", stringContainsInOrder("1.", "2.", "3."))
    }

    @Test(expected = AssertionError::class)
    fun testFailingStringContainsInOrder() {
        assertThat("2.def 1.abc 3.ghi", stringContainsInOrder("1.", "2.", "3."))
    }


    //hasLength
    @Test
    fun testHasLength() {
        assertThat("abc", hasLength(3))
    }

    @Test(expected = AssertionError::class)
    fun testFailingHasLength() {
        assertThat("abc", hasLength(0))
    }
    //GROUPING

    @Test
    fun testAllOf() {
        assertThat("abcde", allOf(startsWith("a"), endsWith("e"), containsString("de")))
    }

    @Test(expected = AssertionError::class)
    fun testFailingAllOf() {
        assertThat("abcde", allOf(startsWith("b"), endsWith("e"), containsString("de")))
    }

    @Test
    fun testBoth() {
        assertThat(30, both(greaterThan(10)).and(lessThan(40)))
    }

    @Test
    fun testBothAndOr() {
        assertThat(65,
                both(lessThan(10))
                        .and(lessThan(40))
                        .or(lessThan(70))
                        .and(greaterThan(60)))
    }

    @Test(expected = AssertionError::class)
    fun testFailingBoth() {
        assertThat(30, both(greaterThan(10)).and(lessThan(20)))
    }

    @Test
    fun testEither() {
        assertThat(30, either(greaterThan(40)).or(lessThan(35)))
    }

    @Test(expected = AssertionError::class)
    fun testFailingEither() {
        assertThat(30, either(greaterThan(40)).or(lessThan(20)))
    }

    //COLLECTION

    //everyItem
    @Test
    fun testEveryItem() {
        val list = listOf(1, 2, 3, 4, 5, 6)
        assertThat(list, everyItem(lessThan(10)))
    }

    @Test(expected = AssertionError::class)
    fun testFailEveryItem() {
        val list = listOf(1, 2, 3, 4, 5, 6)
        assertThat(list, everyItem(lessThan(5)))
    }

    //hasItem

    @Test
    fun testHasItem() {
        val list = listOf(1, 2, 3, 4, 5, 6)
        assertThat(list, hasItem(2))
    }

    @Test(expected = AssertionError::class)
    fun testFailingHasItem() {
        val list = listOf(1, 2, 3, 4, 5, 6)
        assertThat(list, hasItem(10))
    }

    //hasItems

    @Test
    fun testHasItems() {
        val list = listOf(1, 2, 3, 4, 5, 6)
        assertThat(list, hasItems(2, 5, 6))
    }

    @Test(expected = AssertionError::class)
    fun testFailingHasItems() {
        val list = listOf(1, 2, 3, 4, 5, 6)
        assertThat(list, hasItems(2, 5, 10))
    }

    //emptyArray

    @Test
    fun testEmptyArray() {
        val array = arrayOf<Int>()
        assertThat(array, emptyArray())
    }

    @Test(expected = AssertionError::class)
    fun testFailingEmptyArray() {
        val array = arrayOf(1, 2, 3)
        assertThat(array, emptyArray())
    }

    //array

    @Test
    fun testArray() {
        val array = arrayOf(1, 10, 50)
        assertThat(array, Matchers.array(equalTo(1), lessThan(20), greaterThan(40)))
    }

    @Test(expected = AssertionError::class)
    fun testFailingArray() {
        val array = arrayOf(1, 25, 30)
        assertThat(array, Matchers.array(equalTo(1), lessThan(20), greaterThan(40)))
    }

    //hasItemInArray

    @Test
    fun testHasItemInArray() {
        val array = arrayOf("a", "b", "c", "d")
        assertThat(array, hasItemInArray("c"))
    }

    @Test(expected = AssertionError::class)
    fun testFailingHasItemInArray() {
        val array = arrayOf("a", "b", "c", "d")
        assertThat(array, hasItemInArray("f"))
    }

    @Test
    fun testHasItemInArrayNumbers() {
        val array = arrayOf(1, 2, 3, 4, 5)
        assertThat(array, hasItemInArray(greaterThan(4)))
    }

    @Test(expected = AssertionError::class)
    fun testFailingHasItemInArrayNumbers() {
        val array = arrayOf(1, 2, 3, 4, 5)
        assertThat(array, hasItemInArray(greaterThan(9)))
    }

    //arrayContaining

    @Test
    fun testArrayContaining() {
        val array = arrayOf("a", "b", "c", "d")
        assertThat(array, arrayContaining("a", "b", "c", "d"))
    }

    @Test(expected = AssertionError::class)
    fun testFailingArrayContaining() {
        val array = arrayOf("a", "b", "c", "d")
        assertThat(array, arrayContaining("a", "b"))
    }

    @Test
    fun testArrayContainingNumbers() {
        val array = arrayOf(1, 7, 30)
        assertThat(array, arrayContaining(
                greaterThan(0),
                greaterThan(5),
                greaterThan(10)
        ))
    }

    @Test(expected = AssertionError::class)
    fun testFailingArrayContainingNumbers() {
        val array = arrayOf(1, 2, 3)
        assertThat(array, arrayContaining(
                greaterThan(5),
                greaterThan(0),
                greaterThan(10)
        ))
    }

    //arrayContainingInAnyOrder


    @Test
    fun testArrayContainingInAnyOrder() {
        val array = arrayOf("a", "b", "c", "d")
        assertThat(array, arrayContainingInAnyOrder("b", "a", "c", "d"))
    }

    @Test(expected = AssertionError::class)
    fun testFailingArrayContainingInAnyOrder() {
        val array = arrayOf("a", "b", "c", "d")
        assertThat(array, arrayContainingInAnyOrder("a", "z", "c", "d"))
    }

    @Test
    fun testArrayContainingInAnyOrderNumbers() {
        val array = arrayOf(1, 7, 30)
        assertThat(array, arrayContainingInAnyOrder(
                greaterThan(5),
                greaterThan(0),
                greaterThan(10)
        ))
    }

    @Test(expected = AssertionError::class)
    fun testFailingArrayContainingInAnyOrderNumbers() {
        val array = arrayOf(1, 2, 3)
        assertThat(array, arrayContainingInAnyOrder(
                greaterThan(0),
                greaterThan(5),
                greaterThan(10)
        ))
    }


    //arrayWithSize

    @Test
    fun testArrayWithSize() {
        val array = arrayOf(1, 2, 3)
        assertThat(array, arrayWithSize(3))
        assertThat(array, arrayWithSize(lessThan(5)))
        assertThat(array, arrayWithSize(greaterThan(2)))
    }

    @Test(expected = AssertionError::class)
    fun testFailingArrayWithSize() {
        val array = arrayOf(1, 2, 3)
        assertThat(array, arrayWithSize(lessThan(3)))
    }

    //hasSize
    @Test
    fun testHasSize() {
        val collection = listOf(1, 2, 3)
        assertThat(collection, hasSize(3))
        assertThat(collection, hasSize(lessThan(5)))
        assertThat(collection, hasSize(greaterThan(2)))
    }

    @Test(expected = AssertionError::class)
    fun testFailingHasSize() {
        val collection = listOf(1, 2, 3)
        assertThat(collection, hasSize(lessThan(3)))
    }


    //empty
    @Test
    fun testEmpty() {
        val collection = listOf<Any>()
        assertThat(collection, empty())
    }

    @Test(expected = AssertionError::class)
    fun testFailingEmpty() {
        val collection = listOf(1, 2, 3)
        assertThat(collection, empty())
    }

    //contains

    @Test
    fun testContains() {
        val collection = listOf(1, 2, "a", "b")
        assertThat(collection, contains(1, 2, "a", "b"))
    }

    @Test(expected = AssertionError::class)
    fun testFailingContains() {
        val collection = listOf(1, 2, "a", "b")
        assertThat(collection, contains("a", "b", 1, 2))
    }

    //containsInAnyOrder
    @Test
    fun testContainsInAnyOrder() {
        val collection = listOf(1, 2, "a", "b")
        assertThat(collection, containsInAnyOrder("a", "b", 1, 2))
    }

    @Test(expected = AssertionError::class)
    fun testFailingContainsInAnyOrder() {
        val collection = listOf(1, 2, "a", "b")
        assertThat(collection, containsInAnyOrder("a", 1))
    }

    //containsInRelativeOrder

    @Test
    fun testContainsInRelativeOrder() {
        val collection = listOf(1, 2, "a", "b")
        assertThat(collection, containsInRelativeOrder(1, "b"))
    }

    @Test(expected = AssertionError::class)
    fun testFailingContainsInRelativeOrder() {
        val collection = listOf(1, 2, "a", "b")
        assertThat(collection, containsInRelativeOrder("a", 1))
    }

    //MAP
    //aMapWithSize
    @Test
    fun testAMapWithSize() {
        val map = mapOf(
                "a" to 1,
                "b" to 2,
                "c" to 3
        )
        assertThat(map, aMapWithSize(3))
    }

    @Test(expected = AssertionError::class)
    fun testFailingAMapWithSize() {
        val map = mapOf(
                "a" to 1,
                "b" to 2,
                "c" to 3
        )
        assertThat(map, aMapWithSize(1))
    }

    //anEmptyMap
    @Test
    fun testAnEmptyMap() {
        val map = mapOf<String, Int>()
        assertThat(map, anEmptyMap())
    }

    @Test(expected = AssertionError::class)
    fun testFailingAnEmptyMap() {
        val map = mapOf(
                "a" to 1,
                "b" to 2,
                "c" to 3
        )
        assertThat(map, anEmptyMap())
    }

    //hasEntry
    @Test
    fun testHasEntry() {
        val map = mapOf(
                "a" to 1,
                "b" to 2,
                "c" to 3
        )
        assertThat(map, hasEntry("a", 1))
    }

    @Test(expected = AssertionError::class)
    fun testFailingHasEntry() {
        val map = mapOf(
                "a" to 1,
                "b" to 2,
                "c" to 3
        )
        assertThat(map, hasEntry("d", 4))
    }

    //hasKey
    @Test
    fun testHasKey() {
        val map = mapOf(
                "a" to 1,
                "b" to 2,
                "c" to 3
        )
        assertThat(map, hasKey("a"))
    }

    @Test(expected = AssertionError::class)
    fun testFailingHasKey() {
        val map = mapOf(
                "a" to 1,
                "b" to 2,
                "c" to 3
        )
        assertThat(map, hasKey("d"))
    }

    //hasValue
    @Test
    fun testHasValue() {
        val map = mapOf(
                "a" to 1,
                "b" to 2,
                "c" to 3
        )
        assertThat(map, hasValue(1))
    }

    @Test(expected = AssertionError::class)
    fun testFailingHasValue() {
        val map = mapOf(
                "a" to 1,
                "b" to 2,
                "c" to 3
        )
        assertThat(map, hasValue(4))
    }

}

interface Thing
open class SubtypeThingA : Thing
open class SubtypeThingB : Thing