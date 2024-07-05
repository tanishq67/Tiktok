package com.example.myapplication

import android.app.Application

class MyApp : Application() {
    lateinit var mockTelephonyManager: MockTelephonyManager

    override fun onCreate() {
        super.onCreate()
        // Initialize the mock TelephonyManager for testing
        mockTelephonyManager = MockTelephonyManager(this)
    }

    fun getMockTelephonyManager(): MockTelephonyManager {
        return mockTelephonyManager
    }
}
