package problems

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class LongestCommonSubsequence : Spek({
    describe("provided two equal length strings") {
        describe("of length 0") {
            val string1 = ""
            val string2 = ""

            it("reports LCS as empty") {
                assertThat(lcs(string1, string2)).isEqualTo("")
            }
        }

        describe("of length 1") {
            describe("and has no letters in common") {
                val string1 = "A"
                val string2 = "B"

                it("reports LCS as empty") {
                    assertThat(lcs(string1, string2)).isEqualTo("")
                }
            }

            describe("and has letters in common") {
                val string1 = "A"
                val string2 = "A"

                it("reports LCS as 'A'") {
                    assertThat(lcs(string1, string2)).isEqualTo("A")
                }
            }
        }

        describe("of length more than 1") {
            describe("and has no letters in common") {
                val string1 = "AB"
                val string2 = "CD"

                it("reports LCS as empty") {
                    assertThat(lcs(string1, string2)).isEqualTo("")
                }
            }

            describe("and has letters in common") {
                val listOfPairs = listOf(
                        Pair("AB", "AB"),
                        Pair("ABC", "AB"))

                listOfPairs.forEach {
                    it("reports LCS as AB") {
                        assertThat(lcs(it.first, it.second)).isEqualTo("AB")
                    }
                }
            }
        }
    }
})