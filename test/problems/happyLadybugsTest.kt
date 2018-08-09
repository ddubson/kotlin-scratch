package problems

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object Answer {
    val NO = "NO"
    val YES = "YES"
}

fun happyLadybugs(input: String): String {
    if(input.isEmpty()) {
        return Answer.NO
    }

    var memoryChar = '!'
    input.forEachIndexed { index, c ->
        if(index + 1 == input.length) {
            return@forEachIndexed
        }

        if(c == input[index + 1] || memoryChar == c) {
            memoryChar = c
        } else {
            return Answer.NO
        }
    }

    return Answer.YES
}

internal class HappyLadybugsTest : Spek({
    describe("when there are no empty spaces") {
        describe("and there are non-adjacent colors") {
            val inputString = "RBY"

            it("should return 'NO'") {
                assertThat(happyLadybugs(inputString)).isEqualTo(Answer.NO)
            }
        }

        describe("and consists of all single unique colors") {
            val inputString = "YXX"

            it("should return 'NO'") {
                assertThat(happyLadybugs(inputString)).isEqualTo(Answer.NO)
            }
        }

        describe("and consists of even number of clustered colors") {
            val inputString = "YYXX"

            it("should return 'YES'") {
                assertThat(happyLadybugs(inputString)).isEqualTo(Answer.YES)
            }
        }

        describe("and consists of odd number of clustered colors") {
            val inputString = "YYYXX"

            it("should return 'YES'") {
                assertThat(happyLadybugs(inputString)).isEqualTo(Answer.YES)
            }
        }

        describe("and consists of odd number of non-clustered colors") {
            val inputString = "YYXYXX"

            it("should return 'NO'") {
                assertThat(happyLadybugs(inputString)).isEqualTo(Answer.NO)
            }
        }
    }
})