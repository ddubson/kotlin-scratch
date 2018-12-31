import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main(args: Array<String>) {
    GlobalScope.launch {
        delay(1000)
        println("Hello! in a coroutine")
    }

    Thread.sleep(2000)
}