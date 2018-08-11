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

    for ((index, c) in mutableInput.withIndex()) {
        if (c == '_') {
            // put at end of input
            val lastCharIndex = lastCharThatIsntUnderscorIndex(mutableInput)

            if(lastCharIndex == -1 || lastCharIndex <= index) {
                continue
            } else {
                val lastChar = mutableInput[lastCharIndex]
                mutableInput[lastCharIndex] = mutableInput[index]
                mutableInput[index] = lastChar
                prev = lastChar
                continue
            }
        }

        if (index + 1 == input.length) {
            break
        }

        if (mutableInput[index + 1] != c) {
            // seek forward to underscore
            val posOfNextChar = findNextChar(mutableInput, index + 1, c)
            if (posOfNextChar == -1) {
                if (prev == c) {
                    continue
                } else {
                    return Answer.NO
                }
            }

            val posOfNextUnderscore = findNextUnderscore(mutableInput, index + 1)
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

fun lastCharThatIsntUnderscorIndex(mutableInput: MutableList<Char>): Int {
    for (i in mutableInput.size -1 downTo 0) {
        if (mutableInput[i] != '_') {
            return i
        }
    }

    return -1
}

fun findNextUnderscore(input: MutableList<Char>, startIndex: Int): Int {
    input.forEachIndexed { index, c ->
        if (c == '_' && index >= startIndex) {
            return index
        }
    }

    return -1
}

fun findNextChar(input: MutableList<Char>, startIndex: Int, toFind: Char): Int {
    input.forEachIndexed { index, c ->
        if (c == toFind && index >= startIndex) {
            return index
        }
    }

    return -1
}

fun checkIfHappy(input: MutableList<Char>): Boolean {
    if (input.size == 1 && input[0] != '_') {
        return false
    }

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