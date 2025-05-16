package com.example.inclass3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.inclass3.ui.theme.InClass3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InClass3Theme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ColorPickerApp(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColorPickerApp(
    name: String,
    modifier: Modifier = Modifier,
    colorPickerViewModel: ColorPickerViewModel = viewModel()
) {
    val colorPickerUiState = colorPickerViewModel.uiState.collectAsState()

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .background(colorPickerUiState.value.currentColorValue)
            .fillMaxHeight()
    ) {
        ExposedDropdownMenuBox(
            expanded = colorPickerUiState.value.expanded,
            onExpandedChange = {colorPickerViewModel.toggleExpanded()},
            modifier = Modifier.background(Color.LightGray)
        ) {
            OutlinedTextField(
                readOnly = true,
                value = colorPickerUiState.value.currentColor,
                label = {Text("Colors")},
                onValueChange = {},
                trailingIcon = {ExposedDropdownMenuDefaults.TrailingIcon(false)},
                colors = OutlinedTextFieldDefaults.colors(),
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = colorPickerUiState.value.expanded,
                onDismissRequest = { colorPickerViewModel.updateExpanded(false)}
            ) {
                colorPickerViewModel.getColors().forEach { colorString ->
                    DropdownMenuItem(
                        text = {Text(text=colorString)},
                        onClick = {
                            colorPickerViewModel.updateExpanded(false)
                            colorPickerViewModel.updateColorString(colorString)
                        }
                    )
                }
            }

        }
        Slider(value = colorPickerUiState.value.currentColorValue.red, onValueChange = {colorPickerViewModel.updateRed(it)})
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InClass3Theme() {
        ColorPickerApp("Android",
            Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center))
    }
}
