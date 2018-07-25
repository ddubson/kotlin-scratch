class Customer

class AnotherCustomer(val id: Int, var name: String) {
    init {
        name = name.toUpperCase()
    }
}

fun main(args: Array<String>) {
    val cust = AnotherCustomer(1, "Hello")

    println(cust.name)
}