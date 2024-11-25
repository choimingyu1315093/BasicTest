package com.example.circlecalc

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class CalcViewModelTest {
    private lateinit var calcViewModel: CalcViewModel
    private lateinit var calculations: Calculations

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        //Mockito 사용
        calculations = Mockito.mock(Calculations::class.java)
        Mockito.`when`(calculations.calculateCircumference(1.0)).thenReturn(6.28)
        Mockito.`when`(calculations.calculateArea(2.1)).thenReturn(13.8474)

        calcViewModel = CalcViewModel(calculations)
    }

    @Test
    fun calculateCircumference_radiusSent_updateLiveData(){
        calcViewModel.calculateCircumference(1.0)
        val result: String? = calcViewModel.circumferenceValue.value
        assertEquals("6.28", result)
    }

    @Test
    fun calculateArea_radiusSent_updateLiveData(){
        calcViewModel.calculateArea(2.1)
        val result: String? = calcViewModel.areaValue.value
        assertEquals("13.8474", result)
    }
}