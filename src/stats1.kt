import java.lang.Math.floor

fun main(args: Array<String>) {
    val N = readLine().orEmpty().toDouble()
    val rangeOfNumbers: List<Int> = readLine().orEmpty().split(" ").map { it.toInt() }

    val mean: Double = mean(rangeOfNumbers, N)
    val median: Double = median(rangeOfNumbers, N)
    val mode: Int = mode(rangeOfNumbers)

    println(mean)
    println(median)
    println(mode)
}

private fun mean(rangeOfNumbers: List<Int>, N: Double): Double {
    return rangeOfNumbers.reduceRight { it, acc ->
        acc + it
    } / N
}

private fun median(rangeOfNumbers: List<Int>, N: Double): Double {
    val sortedRange = rangeOfNumbers.sorted()
    val mid = floor((N - 1) / 2).toInt()

    return (sortedRange[mid] + sortedRange[mid + 1]) / 2.0
}

private fun mode(rangeOfNumbers: List<Int>): Int {
    val modeMap = mutableMapOf<Int, Int>()
    var max = 0
    var maxKey = 0
    rangeOfNumbers.sorted().forEach {
        if (modeMap.containsKey(it)) {
            modeMap[it] = (modeMap.getValue(it) + 1)
            if (max < modeMap.getValue(it)) {
                max = modeMap.getValue(it)
                maxKey = it
            }
        } else {
            modeMap[it] = 1
            if (max < modeMap.getValue(it)) {
                max = modeMap.getValue(it)
                maxKey = it
            }
        }
    }

    return maxKey
}