package functions

infix fun String.shouldBeEqualTo(value: String) = this == value

fun main(args: Array<String>) {
    "Hello".shouldBeEqualTo("Hello")

    // With Infix Notation
    "Hello" shouldBeEqualTo "Hello"
}