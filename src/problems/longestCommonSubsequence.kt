package problems

fun lcs(string1: String, string2: String): String {
    val bothEmpty = string1.isEmpty() && string2.isEmpty()
    val stringsAreNotEqual = string1 != string2

    return if(bothEmpty || stringsAreNotEqual) {
        ""
    } else {
        string1
    }
}