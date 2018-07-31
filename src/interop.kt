fun main(args: Array<String>) {
    val customer = CustomerJava()
    // Types ending with '!' signify a potentially hazardous (nullable) platform type
    customer.firstName

    // Types appended with @NotNull annotation become safe, and hence have no ! suffix
    customer.lastName
}