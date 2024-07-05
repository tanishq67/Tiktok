package com.example.myapplication

import android.content.Context

class MockTelephonyManager(private val context: Context) {

    fun getSimCountryIso(): String {
        return "jp" // Mocked country ISO
    }

    fun getNetworkOperator(): String {
        return "44010" // Mocked network operator numeric for NTT DoCoMo
    }

    fun getNetworkOperatorName(): String {
        return "NTT DoCoMo" // Mocked network operator name
    }
}
