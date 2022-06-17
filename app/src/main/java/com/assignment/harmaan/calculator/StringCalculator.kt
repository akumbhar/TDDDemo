package com.assignment.harmaan.calculator

class StringCalculator {

    fun add(numberString: String?): Int {
        if (numberString.isNullOrEmpty()) return 0
        return try {
            numberString.toInt()
        } catch (e: NumberFormatException) {
            e.printStackTrace()
            0
        }
    }

}