package hu.obuda.devops.fibonaccirestapi.service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FibonacciServiceTest {

    private val underTest = FibonacciService()

    @Test
    fun shouldReturn0WhenCall1() {
        // when
        val result: Int = underTest.fibonacci(1)

        // then
        Assertions.assertEquals(0, result)
    }

    @Test
    fun shouldReturn1WhenCall2() {
        val result = underTest.fibonacci(2)
        Assertions.assertEquals(1, result)
    }

    @Test
    fun shouldReturnCorrectValueForSmallNumbers() {
        Assertions.assertEquals(1, underTest.fibonacci(3))
        Assertions.assertEquals(2, underTest.fibonacci(4))
        Assertions.assertEquals(3, underTest.fibonacci(5))
        Assertions.assertEquals(5, underTest.fibonacci(6))
    }

    @Test
    fun shouldReturnCorrectValueForLargerNumber() {
        val result = underTest.fibonacci(10)
        Assertions.assertEquals(34, result)
    }

    @Test
    fun shouldThrowExceptionWhenInputIsLessThan1() {
        assertThrows<IllegalArgumentException> {
            underTest.fibonacci(0)
        }
    }
}