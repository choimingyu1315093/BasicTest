package com.example.circlecalc

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MyCalcTest {
    private lateinit var myCalc: MyCalc

    @Before
    fun setUp() {
        myCalc = MyCalc()
    }

    @Test
    fun calculateCircumference_radiusGiven_returnsCorrectResult(){
        val result = myCalc.calculateCircumference(2.1)
        assertEquals(13.188, result, 0.01)
    }

    @Test
    fun calculateArea_radiusGiven_returnsCorrectResult(){
        val result = myCalc.calculateArea(2.1)
        assertEquals(13.8474, result, 0.01)
    }
}