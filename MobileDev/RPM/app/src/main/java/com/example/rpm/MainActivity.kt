package com.example.rpm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rpm.ui.theme.RPMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RPMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RPMSliderApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun RPMSliderApp(modifier: Modifier = Modifier) {
    var amountInput by remember { mutableStateOf(0.0f)}
    val amount = amountInput
    Column() {
        DialWithNeedle( 270 * amount.toFloat())
        RPMSlider(
            sliderValue = amountInput,
            onSliderMove = {amountInput = it},
            modifier = Modifier.padding(25.dp))
        Text(amountInput.toString())
    }
}

@Composable
fun RPMSlider(
    sliderValue: Float,
    onSliderMove: (Float) -> Unit,
    modifier: Modifier = Modifier
) {
    Column (){
        Slider(
            value = sliderValue,
            onValueChange = onSliderMove,
            modifier = modifier
        )
    }

}

@Composable
fun DialWithNeedle(
    needleAngle: Float,
    modifier: Modifier = Modifier) {
    Box() {
        Image(
            painter = painterResource(R.drawable.iu),
            contentDescription = "RPM Gauge Image"
        )
        Image(
            painter = painterResource(R.drawable.rpmneedle),
            contentDescription = "RPM Needle",
            modifier = Modifier.rotate(needleAngle)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RPMTheme {
        RPMSliderApp()
    }
}