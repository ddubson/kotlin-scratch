data class SomeClass(val someThing: Int)

var thisCanBeNull: String? = null

fun main(args: Array<String>) {
    val message = "Message"

    val nullMessage: String? = null
    val inferredNull = null

    // Elvis operator -> if value is not null, invoke .length
    println(nullMessage?.length)

    val someClass: SomeClass? = null
    val thisIsANonNullString = thisCanBeNull ?: "Empty"
    val nonNullSomeClass = someClass ?: SomeClass(123)

    println(thisIsANonNullString)
    println(nonNullSomeClass)
}