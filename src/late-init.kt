interface Repository {
    fun getAll(): List<Customer>
}

class CustomerController {
    lateinit var repo: Repository

    fun index(): String {
        return repo.getAll().toString()
    }
}

fun main(args: Array<String>) {
    val customerController = CustomerController()
    customerController.index()
}