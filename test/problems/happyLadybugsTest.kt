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
                "RBXYXB" to Answer.NO,
                "RRGGBBXY" to Answer.NO,
                "RRGGBBXX" to Answer.YES,
                "GR" to Answer.NO,
                "G" to Answer.NO
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
                "X_X" to Answer.YES,
                "X_" to Answer.NO,
                "XYYX_Y" to Answer.YES,
                "XY_X_Y" to Answer.YES,
                "RBY_YBR" to Answer.YES,
                "X_Y__X" to Answer.NO,
                "B_RRBR" to Answer.YES,
                "__" to Answer.YES,
                "R_R_R" to Answer.YES,
                "_R_G_" to Answer.NO,
                "_GR_" to Answer.NO,
                "_FWYSSENEDBO_KSEVUAB_WZ_GASASVEVS_O_NSVBYFNADE_WWVSBKAE_F_VAS_F_AAAEWBE_WEAEOAYV" to Answer.NO,
                "ZBF_MIFUXJNQGQRFZVRQUFFFFNGFIBJ_XZVIRFGMJRJFVMNJMF" to Answer.YES,
                "YFCA_NXMGJYYGCMMGGGXYNAMFNJJX_" to Answer.YES
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