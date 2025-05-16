package com.example.inclass3.ui.theme

import android.graphics.Color

data class ColorPickerUiState(
    val expanded: Boolean = false,
    val currentColor: String = "",
    val currentColorValue: Color = Color.Unspecified
)
