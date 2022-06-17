package com.assignment.harmaan.calculator

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class StringCalculatorTest {

    lateinit var calculator: StringCalculator

    @Before
    fun setup() {
        calculator = StringCalculator()
    }

    @Test
    fun `return 0 when input is empty string`() {

        assertEquals(0, calculator.add(""))
    }

}