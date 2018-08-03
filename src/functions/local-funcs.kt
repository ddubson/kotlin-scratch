package functions

fun foo(fooParam: String) {
    val outerFunction = "value"

    fun bar(barParam: String) {
        println(barParam)
        println(fooParam)
        println(outerFunction)
    }

    bar("World!")
}

fun main(args: Array<String>) {
    foo("Hello!")
}