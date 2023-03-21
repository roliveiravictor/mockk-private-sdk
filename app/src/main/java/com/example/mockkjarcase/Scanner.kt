package com.example.mockkjarcase

import com.symbol.emdk.barcode.ScanDataCollection
import com.symbol.emdk.barcode.Scanner
import com.symbol.emdk.barcode.ScannerResults

class Scanner(private val listener: ScannerListener) : Scanner.DataListener {

    override fun onData(data: ScanDataCollection?) {
        if (data?.result == ScannerResults.SUCCESS) {
            listener?.onScanSuccess("Success")
        } else {
            listener?.onScanFailed("Failed")
        }
    }
}
