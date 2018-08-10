package problems

import com.sun.org.apache.xpath.internal.operations.Bool
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Answer {
    val NO = "NO"
    val YES = "YES"
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

        if (mutableInput[index + 1] != c) {
            // seek forward to underscore
            val posOfNextUnderscore = findNextUnderscore()
            if (posOfNextUnderscore == -1 && prev != c) {
                return Answer.NO
            } else {
                // swap underscore with next char
                val nextChar = mutableInput[index + 1]
                mutableInput[index + 1] = '_'
                mutableInput[posOfNextUnderscore] = nextChar
            }

            val posOfNextChar = findNextChar(c)

            if (posOfNextChar == -1 && prev != c) {
                return Answer.NO
            } else {
                // swap underscore with next char
                mutableInput[index + 1] = mutableInput[posOfNextChar]
                mutableInput[posOfNextChar] = '_'
            }
        } else {
            prev = c
        }
    }

    return if (checkIfHappy(mutableInput)) "YES" else "NO"
}

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

internal class HappyLadybugsTest : Spek({
    describe("when there are no empty spaces") {
        val testCases = mapOf(
                "RBY" to Answer.NO,
                "YXX" to Answer.NO,
                "YYXX" to Answer.YES,
                "YYYXX" to Answer.YES,
                "YYXYXX" to Answer.NO,
                "XYXYXYX" to Answer.NO,
                "RBXYXB" to Answer.NO
        )

        testCases.forEach { input, expectedAnswer ->
            on("input of $input") {
                it("should answer $expectedAnswer") {
                    assertThat(happyLadybugs(input)).isEqualTo(expectedAnswer)
                }
            }
        }
    }

    describe("when there are empty spaces") {
        val testCases = mapOf(
                "RXY_" to Answer.NO,
                "X_X" to Answer.YES
        )

        testCases.forEach { input, expectedAnswer ->
            on("input of $input") {
                it("should answer $expectedAnswer") {
                    assertThat(happyLadybugs(input)).isEqualTo(expectedAnswer)
                }
            }
        }

    }

})