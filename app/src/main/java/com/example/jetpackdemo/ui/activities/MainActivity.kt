package com.example.jetpackdemo.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackdemo.ui.comonents.AppToolbar
import com.example.jetpackdemo.ui.composable.MainScreen
import com.example.jetpackdemo.ui.theme.JetPackDemoTheme
import com.example.jetpackdemo.ui.theme.Purple40
import com.example.jetpackdemo.ui.utils.showToast

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackDemoTheme {
               MainScreen()
            }
        }
    }
}

@Composable
fun Greeting(name: String, mobile: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Hello $name!",
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight(700),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = mobile,
            fontSize = 16.sp,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight(300),
            color = Purple40,

            modifier = Modifier
                .padding(16.dp)
                .drawBehind {
                    val strokeWidthPx = 1.dp.toPx()
                    val verticalOffset = size.height - 2.sp.toPx()
                    drawLine(
                        color = Purple40,
                        strokeWidth = strokeWidthPx,
                        start = Offset(0f, verticalOffset),
                        end = Offset(size.width, verticalOffset)
                    )
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackDemoTheme {
        Greeting("Sanket", "+91 9999900000")
    }
}