package problems

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

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