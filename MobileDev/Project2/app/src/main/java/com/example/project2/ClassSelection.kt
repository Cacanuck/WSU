package com.example.project2

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ClassSelection(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Select Your Class")
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("TalentPoint?class=Warrior") }) {
            Text("Warrior")
        }

        Button(onClick = { navController.navigate("TalentPoint?class=Mage") }) {
            Text("Mage")
        }

        Button(onClick = { navController.navigate("TalentPoint?class=Rogue") }) {
            Text("Rogue")
        }

        Button(onClick = { navController.navigate("TalentPoint?class=Archer") }) {
            Text("Archer")
        }
    }
}