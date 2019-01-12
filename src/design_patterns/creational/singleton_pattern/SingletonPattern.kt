package design_patterns.creational.singleton_pattern

import kotlin.random.Random

class PermitRepository private constructor() {
    companion object {
        private var permitRepository: PermitRepository? = null

        fun getInstance(): PermitRepository? {
            if(permitRepository == null) {
                this.permitRepository = PermitRepository()
                return this.permitRepository
            }

            return permitRepository
        }
    }

    fun getAll(): List<Permit> {
        return listOf(Permit(), Permit())
    }
}

class Permit {
    override fun toString(): String = "Permit ${Random.nextInt()}"
}

class Contract(permitRepository: PermitRepository) {
    private var listOfPermits: List<Permit> = permitRepository.getAll()

    fun getAllPermits(): List<Permit> = listOfPermits
}

fun main(args: Array<String>) {
    val permitRepository = PermitRepository.getInstance()!!
    val contract = Contract(permitRepository)
    contract.getAllPermits().forEach {
        println(it.toString())
    }
}