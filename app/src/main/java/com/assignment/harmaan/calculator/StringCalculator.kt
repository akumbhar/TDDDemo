package com.assignment.harmaan.calculator

const val NEW_LINE_CHAR = "\n"
const val DELIMITER_PREFIX = "//"

class StringCalculator {

    private var delimiter = ","
    fun add(numberString: String?): Int {
        if (numberString.isNullOrEmpty()) return 0

        if (numberString.contains(DELIMITER_PREFIX)) {
            val startIndex = numberString.indexOf(DELIMITER_PREFIX) + DELIMITER_PREFIX.length
            val endIndex = numberString.indexOf(NEW_LINE_CHAR)
            delimiter = numberString.substring(startIndex, endIndex)
        } else {
            delimiter = ","

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
        return numberList.sum()
    }

}