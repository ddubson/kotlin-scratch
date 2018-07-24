fun main(args: Array<String>) {
    for(a: Int in 1..100) {
        println(a)
    }

    val numbers = 1..100

    for(a in 100 downTo 1) {
        println(a)
    }

    for(a in 100 downTo 1 step 5) {
        println(a)
    }
}