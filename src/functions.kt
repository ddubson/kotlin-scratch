fun hello(): Unit {
    println("Hello!")
}

fun throwingExceptions(): Nothing {
    throw Exception("This is an exception")
}

fun add(x: Int = 2, y: Int = 6) = x + y

fun main(args: Array<String>) {
    hello()
    println(add(x = 1, y = 2))
    println(add())
}