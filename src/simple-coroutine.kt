import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

fun main(args: Array<String>) {
    GlobalScope.launch {
        delay(1000)
        println("Hello! in a coroutine")
    }

    Thread.sleep(2000)
}