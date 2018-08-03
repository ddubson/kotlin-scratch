package functions

fun hello(): Unit {
    println("Hello!")
}

fun throwingExceptions(): Nothing {
    throw Exception("This is an exception")
}

fun add(x: Int = 2, y: Int = 6) = x + y

// vararg -> variable number of strings passed in
fun printSomeStrings(vararg someStrings: String) {
    // Using the spread operator (*)
    reallyPrint(*someStrings)
}

fun reallyPrint(vararg strings: String) {
    strings.forEach { println(it) }
}

fun main(args: Array<String>) {
    hello()
    println(add(x = 1, y = 2))
    println(add())
    printSomeStrings("1", "2", "3")
}