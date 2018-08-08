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
    return Answer.NO
}

internal class HappyLadybugsTest: Spek({
    describe("when there are no empty spaces") {
        describe("and there are non-adjacent colors") {
            val inputString = "RBY"
            
            it("should return 'NO'") {
                assertThat(happyLadybugs(inputString)).isEqualTo(Answer.NO)
            }
        }
        
        describe("and there are colors that are alone") {
            val inputString = "YXX"

            it("should return 'NO'") {
                assertThat(happyLadybugs(inputString)).isEqualTo(Answer.NO)
            }
        }
    }
})