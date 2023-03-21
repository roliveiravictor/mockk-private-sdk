package com.example.mockkjarcase

import com.symbol.emdk.barcode.ScanDataCollection
import com.symbol.emdk.barcode.ScannerResults.SUCCESS
import com.symbol.emdk.barcode.ScannerResults.FAILURE
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class ScannerTest {

    @MockK
    lateinit var listener: ScannerListener

    private lateinit var scanner: Scanner

    @Before
    fun init(){
        MockKAnnotations.init(this, relaxUnitFun = true)
        scanner = Scanner(listener)
    }

    @Test
    fun testOnDataShouldCallListenerSuccess() {
        val data = mockk<ScanDataCollection>()
        every { data.result } returns SUCCESS
        scanner.onData(data)
        verify { listener.onScanSuccess(any()) }
    }

    @Test
    fun testOnDataShouldCallListenerFailure() {
        val data = mockk<ScanDataCollection>()
        every { data.result } returns FAILURE
        scanner.onData(data)
        verify { listener.onScanFailed(any()) }
    }
}