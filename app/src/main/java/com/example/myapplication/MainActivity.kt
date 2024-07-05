package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    private lateinit var mockTelephonyManager: MockTelephonyManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }

        // Get the mock TelephonyManager from the application context
        mockTelephonyManager = (application as MyApp).getMockTelephonyManager()

        // Use the mocked TelephonyManager
        val simCountryIso = mockTelephonyManager.getSimCountryIso()
        val networkOperator = mockTelephonyManager.getNetworkOperator()
        val networkOperatorName = mockTelephonyManager.getNetworkOperatorName()

        // Log the mocked values or use them as needed
        println("Sim Country ISO: $simCountryIso")
        println("Network Operator: $networkOperator")
        println("Network Operator Name: $networkOperatorName")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}
