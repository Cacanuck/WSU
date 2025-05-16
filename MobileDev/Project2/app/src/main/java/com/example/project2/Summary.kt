package com.example.project2

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun Summary(navController: NavController, viewModel: CharacterCreatorViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Character Summary")
        Spacer(Modifier.height(16.dp))
        Text("Stamina: ${uiState.stamina}")
        Text("Strength: ${uiState.strength}")
        Text("Agility: ${uiState.agility}")
        Text("Intellect: ${uiState.intellect}")
        Text("Hit Points: ${viewModel.getHitPoints()}")
        Text("Health Regen: ${viewModel.getHealthRegen()}")
        Text("Physical Damage: ${viewModel.getPhysicalDamage()}")
        Text("Magic Damage: ${viewModel.getMagicDamage()}")

        Spacer(Modifier.height(16.dp))
        Button(onClick = { navController.popBackStack("ClassSelection", inclusive = false) }) {
            Text("Start Over")
        }
    }
}