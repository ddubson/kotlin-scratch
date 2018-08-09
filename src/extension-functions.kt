fun String.hello() {
    println("It's me.")
}

fun String.toTitleCase(): String = this.split(" ").joinToString(" ") { it.capitalize() }

fun main(args: Array<String>) {
    "Hello".hello()
    println("this is a sample string to title case".toTitleCase())
}