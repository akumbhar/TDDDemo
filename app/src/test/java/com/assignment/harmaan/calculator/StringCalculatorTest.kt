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

    @Test
    fun `return 0 when input is null`() {
        assertEquals(0, calculator.add(null))
    }

    @Test
    fun `return number when input is single number string`() {
        assertEquals(8, calculator.add("8"))
    }

    @Test
    fun `return 0 when input is not a number string`() {
        assertEquals(0, calculator.add("ABC"))
    }

    @Test
    fun `return sum when input is 2 comma separated number string`() {
        assertEquals(10, calculator.add("10,20"))
    }

}