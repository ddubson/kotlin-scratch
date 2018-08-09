package problems

fun findPoint(px: Int, py: Int, qx: Int, qy: Int): Array<Int> {
    val r = Pair(qx + (qx-px), qy + (qy-py))

    val (rx, ry) = r
    return arrayOf(rx, ry)
}