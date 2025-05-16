package com.example.project2

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CharacterCreatorViewModel : ViewModel() {
    private var _uiState = MutableStateFlow(CharacterCreatorUiState())

    val uiState: StateFlow<CharacterCreatorUiState> = _uiState.asStateFlow()

    private fun resetCharacter() {
        _uiState.value = CharacterCreatorUiState()
    }

    private val classDefaults = mapOf(
        "Warrior" to CharacterDefaults(10, 15, 5, 5),
        "Mage" to CharacterDefaults(5, 5, 10, 15),
        "Rogue" to CharacterDefaults(10, 5, 15, 5),
        "Archer" to CharacterDefaults(15, 5, 10, 5)
    )

    private val totalPoints = 50

    data class CharacterDefaults(val stamina: Int, val strength: Int, val agility: Int, val intellect: Int)

    private fun statSum(): Int {
        return _uiState.value.agility + _uiState.value.strength + _uiState.value.stamina + _uiState.value.intellect
    }

    fun incStamina() {
        val remainingPoints = pointsRemaining()
        if (remainingPoints > 0) {
            _uiState.update { currentState ->
                currentState.copy(stamina = currentState.stamina + 1)
            }
        }
    }

    fun decStamina() {
        if (_uiState.value.stamina > classDefaults[_uiState.value.selectedClass]?.stamina ?: 0) {
            _uiState.update { currentState ->
                currentState.copy(stamina = currentState.stamina - 1)
            }
        }
    }

    fun incStrength() {
        val remainingPoints = pointsRemaining()
        if (remainingPoints > 0) {
            _uiState.update { currentState ->
                currentState.copy(strength = currentState.strength + 1)
            }
        }
    }

    fun decStrength() {
        if (_uiState.value.strength > classDefaults[_uiState.value.selectedClass]?.strength ?: 0) {
            _uiState.update { currentState ->
                currentState.copy(strength = currentState.strength - 1)
            }
        }
    }

    fun incAgility() {
        val remainingPoints = pointsRemaining()
        if (remainingPoints > 0) {
            _uiState.update { currentState ->
                currentState.copy(agility = currentState.agility + 1)
            }
        }
    }

    fun decAgility() {
        if (_uiState.value.agility > classDefaults[_uiState.value.selectedClass]?.agility ?: 0) {
            _uiState.update { currentState ->
                currentState.copy(agility = currentState.agility - 1)
            }
        }
    }

    fun incIntellect() {
        val remainingPoints = pointsRemaining()
        if (remainingPoints > 0) {
            _uiState.update { currentState ->
                currentState.copy(intellect = currentState.intellect + 1)
            }
        }
    }

    fun decIntellect() {
        if (_uiState.value.intellect > classDefaults[_uiState.value.selectedClass]?.intellect ?: 0) {
            _uiState.update { currentState ->
                currentState.copy(intellect = currentState.intellect - 1)
            }
        }
    }

    fun pointsRemaining(): Int {
        return _uiState.value.maxStats - statSum()
    }

    fun getPointsRemaining(): String {
        return pointsRemaining().toString()
    }

    fun getHitPoints(): String {
        val value = 2 * (uiState.value.stamina + uiState.value.strength + uiState.value.agility)
        val valAsString = value.toString()
        return valAsString
    }

    fun getHealthRegen(): String {
        val value = 2 * (uiState.value.stamina + uiState.value.strength + uiState.value.agility)
        val valAsString = value.toString()
        return valAsString
    }

    fun getPhysicalDamage(): String {
        val value = 2 * (uiState.value.strength + uiState.value.agility)
        val valAsString = value.toString()
        return valAsString
    }

    fun getMagicDamage(): String {
        val value = 2 * (uiState.value.intellect + uiState.value.agility)
        val valAsString = value.toString()
        return valAsString
    }

    fun resetCharacter(selectedClass: String) {
        _uiState.value = CharacterCreatorUiState(
            stamina = classDefaults[selectedClass]?.stamina ?: 0,
            strength = classDefaults[selectedClass]?.strength ?: 0,
            agility = classDefaults[selectedClass]?.agility ?: 0,
            intellect = classDefaults[selectedClass]?.intellect ?: 0,
            selectedClass = selectedClass
        )
    }
}