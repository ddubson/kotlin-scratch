import java.util.*

class AnotherCustomer(val id: Int, var name: String, val yearOfBirth: Int) {
    init {
        name = name.toUpperCase()
    }

    constructor(email: String) : this(1, "Name", 1945) {

    }

    // getter
    val age: Int
        get() = Calendar.getInstance().get(Calendar.YEAR) - yearOfBirth

    // setter
    var ssn: String = "SN1"
        set(value) {
            if(!value.startsWith("SN")) {
                throw IllegalArgumentException("Should start with SN")
            }
            // kotlin concept of `field` that you are setting, in this case it is `ssn`
            field = value
        }

    fun customerAsString(): String   {
        return "Id: $id - Name: $name"
    }
}

fun main(args: Array<String>) {
    val cust = AnotherCustomer(1, "Hello", 1985)

    println(cust.customerAsString())
    println(cust.name)
    println(cust.age)
}