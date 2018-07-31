fun sum(x: Int, y: Int): Int = x + y

fun operation(x: Int, y: Int, op: (Int, Int) -> Int): Int = op(x, y)

fun unaryOperation(x: Int, op: (Int) -> Int): Int = op(x)

fun main(args: Array<String>) {
    // ::sum is a function reference
    println(operation(1, 2, ::sum))

    // Lambda as variable
    val addOp: (x: Int, y: Int) -> Int = { x, y -> x + y }
    println(operation(1, 2, addOp))

    // Inline lambda expression as third parameter, moved out of param list because its last in list
    println(operation(1, 2) { x, y -> x + y })

    // Single param lambdas can use the word `it` to denote the param passed in
    println(unaryOperation(4) { it * 6 })

    // Implementing functional interfaces inline
    val runKotlinRun = Runnable { println("it runs!") }
    runKotlinRun.run()
}