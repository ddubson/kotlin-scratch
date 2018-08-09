package problems

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

internal class PointReflectionTest : Spek({
    describe("p(0,0), q(0,0)") {
        it("should return point reflection of r(0,0)") {
            val r = arrayOf(0, 0)
            assertThat(findPoint(0, 0, 0, 0)).isEqualTo(r)
        }
    }

    describe("p(0,0), q(1,1)") {
        it("should return point of reflection of r(2,2)") {
            val r = arrayOf(2,2)
            assertThat(findPoint(0,0,1,1)).isEqualTo(r)
        }
    }

    describe("p(1,1), q(2,2)") {
        it("should return point of reflection of r(3,3)") {
            val r = arrayOf(3,3)
            assertThat(findPoint(1,1,2,2)).isEqualTo(r)
        }
    }
})