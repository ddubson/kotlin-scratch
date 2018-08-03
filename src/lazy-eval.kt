fun main(args: Array<String>) {
    val numbers = 1..1000000000000000

    // Takes a long time due to the size of the original range
    /*
    val lessThanThirty = numbers.filter { it < 30 }.map { Pair("Yes", it) }
    lessThanThirty.forEach {
        println(lessThanThirty)
    }
    */

    // Takes a long time due to the size of the original range
    val lessThanThirtyLazy = numbers.asSequence().filter { it < 30 }.map { Pair("Yes", it) }
    lessThanThirtyLazy.forEach {
        println(it)
    }

    // Only initialized to 10 when called, not declared
    val lazy: Int by lazy { 10 }
}