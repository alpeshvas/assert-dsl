package com.alpesh.assertKt
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

open class MultiAssertionDSL {
    private val assertionsList = mutableListOf<() -> Unit>()
    fun <T> equals(expect: T, actual: T, message: String? = null) {
        assertionsList.add { assertEquals(expected = expect, actual = actual, message) }
    }
    fun <T> notEquals(expect: T, actual: T, message: String? = null) {
        assertionsList.add { assertNotEquals(illegal = expect, actual = actual, message) }
    }

    fun runAssertions() {
        assertionsList.forEach { it() }
    }
}

fun assert(builder: MultiAssertionDSL.() -> Unit) {
    return MultiAssertionDSL().apply(builder).runAssertions()
}
