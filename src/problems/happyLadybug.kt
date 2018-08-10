package problems

object Answer {
    const val NO = "NO"
    const val YES = "YES"
}

fun happyLadybugs(input: String): String {
    if (input.isEmpty()) {
        return Answer.NO
    }

    var prev = '!'
    val mutableInput = input.asSequence().toMutableList()

    for ((index, c) in input.withIndex()) {
        if (c == '_') {
            continue
        }

        if (index + 1 == input.length) {
            break
        }

        if (mutableInput[index + 1] != c) {
            // seek forward to underscore
            val posOfNextUnderscore = findNextUnderscore(input, index + 1)
            if (posOfNextUnderscore == -1) {
                if (prev == c) {
                    continue
                } else {
                    return Answer.NO
                }
            } else {
                // swap underscore with next char
                val nextChar = mutableInput[index + 1]
                mutableInput[index + 1] = '_'
                mutableInput[posOfNextUnderscore] = nextChar
            }

            val posOfNextChar = findNextChar(input, index + 1, c)

            if (posOfNextChar == -1 && prev != c) {
                return Answer.NO
            } else {
                // swap underscore with next char
                mutableInput[index + 1] = mutableInput[posOfNextChar]
                mutableInput[posOfNextChar] = '_'
            }

            prev = c
        } else {
            prev = c
        }
    }

    return if (checkIfHappy(mutableInput)) "YES" else "NO"
}

fun findNextUnderscore(input: String, startIndex: Int): Int = input.indexOf('_', startIndex)

fun findNextChar(input: String, startIndex: Int, c: Char): Int = input.indexOf(c, startIndex)

fun checkIfHappy(input: MutableList<Char>): Boolean {
    var memoryChar = '!'
    input.forEachIndexed { index, c ->
        if (index + 1 == input.size) {
            return@forEachIndexed
        }

        if (c == input[index + 1] || memoryChar == c) {
            memoryChar = c
        } else {
            return false
        }
    }

    return true
}