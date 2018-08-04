package problems

fun birthdayCakeCandles(ar: Array<Int>): Int {
    return if(ar.isEmpty()) {
        0
    } else {
        val tallestCandle = ar.max()
        ar.count { it == tallestCandle }
    }
}