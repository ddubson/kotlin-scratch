val listOfColors = listOf("red", "green", "blue", "orange", "black")

// Take the first elements
val subsetList = listOfColors.take(3)

// Take the last elements of a list
val subsetListTail = listOfColors.takeLast(3)

fun main(args: Array<String>) {
    println("First 3 values of list: $subsetList")
    println("Last 3 values of list: $subsetListTail")
}