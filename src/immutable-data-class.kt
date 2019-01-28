class TimeOfDay {
    val minutes: Int
    private val minutesInHour = 60
    private val hoursInDay = 24
    private val minutesInDay = hoursInDay * minutesInHour

    constructor(hour: Int, minute: Int) {
        this.minutes = hour * minutesInHour + minute
    }

    constructor(minute: Int) {
        this.minutes = minute % minutesInDay
    }

    fun hour() = minutes / minutesInHour

    fun minute() = minutes % minutesInHour

    fun withHour(newHour: Int) = TimeOfDay(newHour, this.minute())

    fun withMinute(newMinute: Int) = TimeOfDay(this.hour(), newMinute)

    fun nextHour() = TimeOfDay(minutes + minutesInHour)

    fun nextMinute() = TimeOfDay(minutes + 1)
}

fun main(args: Array<String>) {
    val timeOfDay = TimeOfDay(100)
    println(timeOfDay.minutes)

    val timeOfDay2 = TimeOfDay(2, 30)
    println(timeOfDay2.minutes)

    println(timeOfDay2.withHour(5).withMinute(45).minutes)
    println(timeOfDay2.nextHour().nextMinute().minutes)
}