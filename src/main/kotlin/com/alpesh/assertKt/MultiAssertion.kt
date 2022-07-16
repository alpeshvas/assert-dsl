package com.alpesh.assertKt
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
data class Check(val a: Any, val b: Any, val message: String? = null)
open class MultiCheckDSL {
    val checks = mutableListOf<Check>()
    fun check(expected: Any, actual: Any, message: String? = null) {
        checks.add(Check(expected, actual, message))
    }
}
open class MultiAssertionDSL {
    private val assertionsList = mutableListOf<() -> Unit>()
    fun <T> equals(expect: T, actual: T, message: String? = null) {
        assertionsList.add { assertEquals(expected = expect, actual = actual, message) }
    }
    fun <T> notEquals(expect: T, actual: T, message: String? = null) {
        assertionsList.add { assertNotEquals(illegal = expect, actual = actual, message) }
    }

    fun equals(builder: MultiCheckDSL.() -> Unit) {
        val allChecks = MultiCheckDSL().apply { builder() }.checks
        assertionsList.add {
            allChecks.forEach {
                assertEquals(expected = it.a, actual = it.b, message = it.message)
            }
        }
    }

    fun notEquals(builder: MultiCheckDSL.() -> Unit) {
        val allChecks = MultiCheckDSL().apply { builder() }.checks
        assertionsList.add {
            allChecks.forEach {
                assertNotEquals(illegal = it.a, actual = it.b, message = it.message)
            }
        }
    }
    fun runAssertions() {
        assertionsList.forEach { it() }
    }
}

fun assert(builder: MultiAssertionDSL.() -> Unit) {
    return MultiAssertionDSL().apply(builder).runAssertions()
}
