package com.assignment.harmaan.calculator

const val NEW_LINE_CHAR = "\n"
const val DELIMITER_PREFIX = "//"
const val DEFAULT_DELIMITER = ","

class StringCalculator {

    fun add(numberString: String?): Int {
        count++
        if (numberString.isNullOrEmpty()) return 0

        val delimiter = if (numberString.contains(DELIMITER_PREFIX)) {
            val startIndex = numberString.indexOf(DELIMITER_PREFIX) + DELIMITER_PREFIX.length
            val endIndex = numberString.indexOf(NEW_LINE_CHAR)
            numberString.substring(startIndex, endIndex)
        } else {
            DEFAULT_DELIMITER
        }
        val numberList = mutableListOf<Int>()
        with(numberString) {
            replace(NEW_LINE_CHAR, delimiter).run {
                split(delimiter).forEach {
                    numberList.add(
                        try {
                            it.trim().toInt()
                        } catch (e: NumberFormatException) {
                            0
                        }
                    )
                }
            }
        }
        val negativeNumberList = numberList.filter { it.isNegativeNumber() }
        if (negativeNumberList.isNotEmpty()) {
            throw Exception("negatives are not allowed $negativeNumberList")
        }
        return numberList.filter { it < 1000 }.sum()
    }

    fun getCalledCount() = count
    fun resetCount() {
        count = 0
    }

    companion object {
        private var count = 0
    }

}


fun Int.isNegativeNumber() = this < 0