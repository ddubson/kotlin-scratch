import algorithms.MemoizedRecursiveFibonacci
import algorithms.naiveRecursiveFibonacci
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FibonacciVariantsTest {
    @Test
    fun naiveRecursiveFibonacci() {
        assertEquals(1, naiveRecursiveFibonacci(1))
        assertEquals(1, naiveRecursiveFibonacci(2))
        assertEquals(2, naiveRecursiveFibonacci(3))
        assertEquals(3, naiveRecursiveFibonacci(4))
        assertEquals(5, naiveRecursiveFibonacci(5))
        assertEquals(8, naiveRecursiveFibonacci(6))
        assertEquals(13, naiveRecursiveFibonacci(7))
        assertEquals(21, naiveRecursiveFibonacci(8))
    }

    @Test
    fun memoizedDynamicProgrammingRecursiveFibonacci() {
        val memoizedRecursiveFibonacci = MemoizedRecursiveFibonacci.newInstance()

        assertEquals(1, memoizedRecursiveFibonacci.calculate(1))
        assertEquals(1, memoizedRecursiveFibonacci.calculate(2))
        assertEquals(2, memoizedRecursiveFibonacci.calculate(3))
        assertEquals(3, memoizedRecursiveFibonacci.calculate(4))
        assertEquals(5, memoizedRecursiveFibonacci.calculate(5))
        assertEquals(8, memoizedRecursiveFibonacci.calculate(6))
        assertEquals(13, memoizedRecursiveFibonacci.calculate(7))
        assertEquals(21, memoizedRecursiveFibonacci.calculate(8))
    }
}