package com.assignment.harmaan.calculator

const val NEW_LINE_CHAR = "\n"
const val DELIMITER_PREFIX = "//["
const val DELIMITER_SUFFIX = "]\n"
const val DEFAULT_DELIMITER = ","
const val MULTI_DELIMITER = "]["

class StringCalculator {

    fun add(numberString: String?): Int {
        count++
        if (numberString.isNullOrEmpty()) return 0

        val numberList = mutableListOf<Int>()

        if (!numberString.contains(MULTI_DELIMITER)) {

            val delimiter = if (numberString.contains(DELIMITER_PREFIX)) {
                val startIndex = numberString.indexOf(DELIMITER_PREFIX) + DELIMITER_PREFIX.length
                val endIndex = numberString.indexOf(DELIMITER_SUFFIX)
                numberString.substring(startIndex, endIndex)
            } else {
                DEFAULT_DELIMITER
            }

            with(numberString) {
                replace(NEW_LINE_CHAR, delimiter).run {
                    split(delimiter).forEach {
                        numberList.add(
                            try {
                                val eachNumber = it.trim().toInt()
                                if (eachNumber < 1000) eachNumber else 0
                            } catch (e: NumberFormatException) {
                                0
                            }
                        )
                    }
                }
            }
        }else{
            val delimiter = getMultipleDelimiters(numberString)
            with(numberString){
                substringAfter(NEW_LINE_CHAR).run {
                    split(delimiter[0],delimiter[1]).forEach {
                        numberList.add(
                            try {
                                val eachNumber = it.trim().toInt()
                                if (eachNumber < 1000) eachNumber else 0
                            } catch (e: NumberFormatException) {
                                0
                            }
                        )
                    }
                }
            }
        }
        val negativeNumberList = numberList.filter { it.isNegativeNumber() }
        if (negativeNumberList.isNotEmpty()) {
            throw Exception("negatives are not allowed $negativeNumberList")
        }
        return numberList.sum()
    }

    private fun getMultipleDelimiters(numberString: String): MutableList<String> {
        var delimiterList = mutableListOf<String>()
        val delimiter1 = numberString.substring(
            numberString.indexOf(DELIMITER_PREFIX) + DELIMITER_PREFIX.length,
            numberString.indexOf(
                MULTI_DELIMITER
            )
        )
        val delimiter2 = numberString.substring(
            numberString.indexOf(MULTI_DELIMITER) + MULTI_DELIMITER.length,
            numberString.indexOf(
                DELIMITER_SUFFIX
            )
        )
        delimiterList.add(delimiter1)
        delimiterList.add(delimiter2)
        return delimiterList
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