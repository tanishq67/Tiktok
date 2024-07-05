package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import com.example.myapplication.ui.theme.MyApplicationTheme

class TestActivity : ComponentActivity() {
    private lateinit var mockTelephonyManager: MockTelephonyManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        // Get the mock TelephonyManager from the application context
        mockTelephonyManager = (application as MyApp).getMockTelephonyManager()

        // Use the mocked TelephonyManager
        val simCountryIso = mockTelephonyManager.getSimCountryIso()
        val networkOperator = mockTelephonyManager.getNetworkOperator()
        val networkOperatorName = mockTelephonyManager.getNetworkOperatorName()

        // Display the mocked values in a TextView
        findViewById<TextView>(R.id.sim_country_iso).text = "Sim Country ISO: $simCountryIso"
        findViewById<TextView>(R.id.network_operator).text = "Network Operator: $networkOperator"
        findViewById<TextView>(R.id.network_operator_name).text = "Network Operator Name: $networkOperatorName"
    }
}

@Composable
fun TestScreen() {
    Column {
        Text(text = "Sim Country ISO: jp")
        Text(text = "Network Operator: 44010")
        Text(text = "Network Operator Name: NTT DoCoMo")
    }
}

@Preview(showBackground = true)
@Composable
fun TestScreenPreview() {
    MyApplicationTheme {
        TestScreen()
    }
}
