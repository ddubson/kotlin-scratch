fun main(args: Array<String>) {
    var myString = "Not Empty"

    if(myString != "") {
        println("Not empty")
    } else {
        println("Is Empty")
    }

    // Conditionals as expressions
    val result: String = if(myString != "") {
        "Not empty"
    } else {
        "Is Empty"
    }

    println(result)

    when(result) {
        is String -> println("Excellent!")
        "Value" -> println("It's a value")
    }
}