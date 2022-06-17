package com.assignment.harmaan.calculator

class StringCalculator {

    fun add(numberString: String?): Int {
        if (numberString.isNullOrEmpty()) return 0
        return numberString.toInt()
        return -1
    }

}