package com.pro2on.demorust

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pro2on.demorust.ui.theme.DemoRustTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val input = remember { mutableStateOf("") }
            val reversed = remember { mutableStateOf("") }
            DemoRustTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(8.dp)
                            .fillMaxSize()
                    ) {
                        TextField(
                            modifier = Modifier.fillMaxWidth(),
                            label = { Text(text = "Enter a string") },
                            value = input.value,
                            onValueChange = {
                                input.value = it
                                reversed.value = RustBridge.reverseString(input.value)
                            },
                            placeholder = { Text(text = "Enter a string") },

                        )
                        Spacer(modifier = Modifier.padding(8.dp))
                        Text(text = "Reversed: \n${reversed.value}")
                    }
                }
            }
        }
    }
}
