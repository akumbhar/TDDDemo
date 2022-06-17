package com.assignment.harmaan.calculator

import org.junit.Assert.assertEquals
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
        assertEquals(30, calculator.add("10,20"))
    }

    @Test
    fun `return single digit sum when either invalid number string entered`() {
        assertEquals(10, calculator.add("10,**"))
        assertEquals(20, calculator.add("**,20"))
        assertEquals(0, calculator.add("**,**"))
    }

    @Test
    fun `return sum when multiple comma separated number string entered`() {
        assertEquals(50, calculator.add("10,5,35"))
        assertEquals(60, calculator.add("10,20,30"))
    }

    @Test
    fun `return sum when multiple comma separated number string entered with space`() {
        assertEquals(100, calculator.add("20, 40, 40"))
    }

   @Test
   fun `return sum when multiple comma separated number string with new line`() {
        assertEquals(100, calculator.add("20\n40,40"))
   }

   @Test
   fun `return sum when dynamically update delimiter`() {
        assertEquals(3, calculator.add("//;\n1;2"))
   }

    @Test
   fun `return sum when dynamically update semicolon delimiter`() {
        assertEquals(90, calculator.add("//:\n60:30"))
   }

}