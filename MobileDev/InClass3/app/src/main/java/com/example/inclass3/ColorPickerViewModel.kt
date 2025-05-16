package com.example.inclass3

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ColorPickerViewModel: ViewModel() {
    private val DEFAULT_COLOR = Color.White

    private var _uiState = MutableStateFlow(ColorPickerUIState())

    val uiState = _uiState.asStateFlow()

    private val colorsMap = hashMapOf(
        "White" to Color.White,
        "Black" to Color.Black,
        "Red" to Color.Red,
        "Blue" to Color.Blue,
        "Green" to Color.Green,
        "Yellow" to Color.Yellow,
        "Magenta" to Color.Magenta)


    fun getColors(): MutableSet<String> {
        return colorsMap.keys
    }

    fun updateRed(newRed: Float) {
        _uiState.update { currentState ->
            val newColor = Color(
                red = newRed,
                green = currentState.currentColorValue.green,
                blue = currentState.currentColorValue.blue)
            currentState.copy(currentColorValue = newColor)
        }
    }

    fun updateExpanded(newValue: Boolean) {
        _uiState.update { currentState ->
            currentState.copy(expanded = newValue)
        }
    }

    fun toggleExpanded() {
        _uiState.update { currentState ->
            currentState.copy(expanded = !(currentState.expanded))
        }
    }

    fun updateColorString(newColor: String) {
        _uiState.update { currentState ->
            currentState.copy(currentColor = newColor, currentColorValue = colorsMap[newColor] ?: DEFAULT_COLOR)
        }
    }
}
