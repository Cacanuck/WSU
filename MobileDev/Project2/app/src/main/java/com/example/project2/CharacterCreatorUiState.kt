package com.example.project2

data class CharacterCreatorUiState(
    var stamina: Int = 0,
    var strength: Int = 0,
    var agility: Int = 0,
    var intellect: Int = 0,
    val selectedClass: String = "Warrior",
    val maxStats: Int = 30
)
