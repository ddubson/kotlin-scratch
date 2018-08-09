class Customer() {
    var lastPurchasedAmount = 0.0
        set(value) {
            if (value > 100) {
                field = value
            }
        }
}

fun main(args: Array<String>) {
    val customer = Customer()

    println(customer.lastPurchasedAmount)
    customer.lastPurchasedAmount = 200.0
    println(customer.lastPurchasedAmount)
    customer.lastPurchasedAmount = 50.0
    println(customer.lastPurchasedAmount)
}