import java.lang.Math.floor

fun main(args: Array<String>) {
    val N = readLine().orEmpty().toDouble()
    val rangeOfNumbers: List<Int> = readLine().orEmpty().split(" ").map { it.toInt() }

    val mean: Double = mean(rangeOfNumbers, N)
    val median: Double = median(rangeOfNumbers, N)

    println(mean)
    println(median)
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