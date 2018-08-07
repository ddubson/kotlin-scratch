package functions

data class Time(val hour: Int, val min: Int) {
    operator fun plus(time: Time): Time {
         val minutes = this.min + time.min
        val hoursInMinutes = minutes / 60
        val remainingMinutes = minutes % 60
        val hours = this.hour + time.hour + hoursInMinutes
        return Time(hours, hoursInMinutes)
    }
}

fun main(args: Array<String>) {
    val time = Time(1,0) + Time(2, 0)
    println(time)
}