package com.example.project1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.project1.ui.theme.Project1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Project1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StatApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }

            }
        }
    }

    @Composable
    fun StatApp(
        modifier: Modifier
    ) {
        var strength by remember { mutableStateOf(0) }
        var stamina by remember { mutableStateOf(0) }
        var agility by remember { mutableStateOf(0) }
        var intellect by remember { mutableStateOf(0) }
        val hit_points = 2 * stamina + strength
        val health_regen = 2 * stamina + (agility + intellect)
        val phys_damage = 2 * strength + agility
        val magic_damage = 2 * intellect + agility
        val maxPoints = 25
        val allocated = strength + stamina + agility + intellect
        val remaining = maxPoints - allocated

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Character Creator")

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    StatColumn(name = "Strength",
                        value = strength,
                        onIncrement = { if (strength < 25) strength++ },
                        onDecrement = { if (strength > 0) strength-- })
                    StatColumn(name = "Stamina",
                        value = stamina,
                        onIncrement = { if (stamina < 25) stamina++ },
                        onDecrement = { if (stamina > 0) stamina-- })
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    StatColumn(name = "Agility",
                        value = agility,
                        onIncrement = { if (agility < 25) agility++ },
                        onDecrement = { if (agility > 0) agility-- })
                    StatColumn(name = "Intellect",
                        value = intellect,
                        onIncrement = { if (intellect < 25) intellect++ },
                        onDecrement = { if (intellect > 0) intellect-- })
                }
            }
                Text(
                    text = "Points Remaining: $remaining",
                    modifier = Modifier.padding(vertical = 40.dp))
                Text(text = "Hit Points: $hit_points")
                Text(text = "Health Regen: $health_regen")
                Text(text = "Physical Damage: $phys_damage")
                Text(text = "Magical Damage: $magic_damage")
        }

    }

    @Composable
    fun StatColumn(
        name: String,
        value: Int,
        onIncrement: () -> Unit,
        onDecrement: () -> Unit
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(onClick = onIncrement) {
                Text(text = "+")
            }
            Text(text = "$name: $value")

            Button(onClick = onDecrement, modifier = Modifier.padding(horizontal = 8.dp)) {
                Text(text = "-")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        Project1Theme {
            StatApp(modifier = Modifier)
        }
    }
}