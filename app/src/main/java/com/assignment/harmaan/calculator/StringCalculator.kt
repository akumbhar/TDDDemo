package com.assignment.harmaan.calculator

class StringCalculator {

    fun add(numberString: String?): Int {
        if (numberString.isNullOrEmpty()) return 0
        val numberList = mutableListOf<Int>()

        val updatedString = numberString.replace("\n", ",")
        updatedString.split(",").forEach {
            numberList.add(
                try {
                    it.trim().toInt()
                } catch (e: NumberFormatException) {
                    0
                }
            )
        }
        return numberList.sum()
    }

}