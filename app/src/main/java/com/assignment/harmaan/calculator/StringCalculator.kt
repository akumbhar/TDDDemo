package com.assignment.harmaan.calculator

class StringCalculator {

    fun add(numberString: String?): Int {
        if (numberString.isNullOrEmpty()) return 0
        return try {
            val tokens =  numberString.split(",")
            tokens[0].toInt() + tokens[1].toInt()
        } catch (e: NumberFormatException) {
            e.printStackTrace()
            0
        }
    }

}