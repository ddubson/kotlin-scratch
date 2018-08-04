package problems

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

internal class BirthdayCakeTest: Spek({
    describe("when there are no candles") {
        it("should return 0") {
            assertThat(birthdayCakeCandles(emptyArray())).isEqualTo(0)
        }
    }

    describe("when there is only one candle") {
        val candles = arrayOf(1)

        it("should return 1") {
               assertThat(birthdayCakeCandles(candles)).isEqualTo(1)
        }
    }

    describe("when there multiple unique candles") {
        val candles = arrayOf(1,2,3)

        it("should return 1") {
            assertThat(birthdayCakeCandles(candles)).isEqualTo(1)
        }
    }

    describe("when there are multiple non-unique candles but only one that's tallest") {
        val candles = arrayOf(1,2,2,3)

        it("should return 1") {
            assertThat(birthdayCakeCandles(candles)).isEqualTo(1)
        }
    }

    describe("when there are multiple non-unique candles with multiple tallest ones") {
        val candles = arrayOf(1,2,2,3,3,3)

        it("should return 3 as there are 3 tallest candles") {
            assertThat(birthdayCakeCandles(candles)).isEqualTo(3)
        }
    }
})