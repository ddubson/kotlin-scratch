fun op(x: Int, op: (Int) -> Int): Int {
    return op(x)
}

fun main(args: Array<String>) {
    // Anonymous function
    // Return type can be expressed, but a lambda can't
    op(2, fun(x): Int { return x * x })
}