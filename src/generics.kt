interface Repo {
    fun <T> findAll(): List<T>
    fun <R> findById(id: Int): R?
}

class MyRepo : Repo {
    override fun <T> findAll(): List<T> {
       return emptyList()
    }

    override fun <R> findById(id: Int): R? {
        return null
    }

}

data class MyModel(val id: Int)

fun main(args: Array<String>) {
    val repo = MyRepo()
    repo.findAll<MyModel>()

    val num = repo.findById<Int>(1)
}