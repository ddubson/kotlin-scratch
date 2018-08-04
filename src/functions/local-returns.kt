package functions

fun someFun() {
    val numbers = 1..100

    numbers.forEach {
        if(it % 5 == 0) {

            // Local return -> jumps out of for each, not the whole function
            return@forEach
        }
    }

    println("Hello!")
}

fun main(args: Array<String>) {
    someFun()
}