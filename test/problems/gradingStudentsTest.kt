package problems

import gradingStudents
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

internal class GradingStudentsTest : Spek({
    given("an array of grades") {
        val inputArray = arrayOf(10, 41)

        on("grade failing") {
            it("should return the grade unrounded") {
                assertThat(gradingStudents(inputArray)).contains(10)
            }
        }

        on("non failing grade") {
        }
    }
})