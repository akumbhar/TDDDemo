package com.assignment.harmaan.calculator

const val NEW_LINE_DELIMETER = "\n"
const val COMMA = ","

class StringCalculator {

    fun add(numberString: String?): Int {
        if (numberString.isNullOrEmpty()) return 0
        val numberList = mutableListOf<Int>()
        with(numberString) {
            replace(NEW_LINE_DELIMETER, COMMA).run {
                split(COMMA).forEach {
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