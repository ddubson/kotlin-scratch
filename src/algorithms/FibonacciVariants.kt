package algorithms

fun naiveRecursiveFibonacci(n: Int): Int {
    return if (n <= 2) {
        1
    } else {
        naiveRecursiveFibonacci(n - 1) + naiveRecursiveFibonacci(n - 2)
    }
}

class MemoizedRecursiveFibonacci {
    private val memoryBank: MutableMap<Int, Int> = mutableMapOf()

    companion object {
        fun newInstance(): MemoizedRecursiveFibonacci {
            return MemoizedRecursiveFibonacci()
        }
    }

    fun calculate(n: Int): Int {
        memoryBank.clear()
        return fib(n)
    }

    private fun fib(n: Int): Int {
        if (memoryBank.containsKey(n)) {
            return memoryBank[n] ?: 1
        }

        return if (n <= 2) {
            1
        } else {
            val f = fib(n - 1) + fib(n - 2)
            memoryBank[n] = f
            return f
        }
    }
}