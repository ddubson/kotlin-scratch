fun main(args: Array<String>) {
    val message = "Message"

    val nullMessage: String? = null
    val inferredNull = null

    // Elvis operator -> if value is not null, invoke .length
    println(nullMessage?.length)
}