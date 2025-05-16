package com.example.project2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
//import com.example.charactercreator.ui.theme.CharacterCreatorTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.project2.ui.theme.Project2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Project2Theme {
                CharacterCreationApp()
            }
        }
    }
}

@Composable
fun CharacterCreationApp(
    modifier: Modifier = Modifier,
    characterCreatorViewModel: CharacterCreatorViewModel = viewModel(),
) {
    val characterCreatorUiState by characterCreatorViewModel.uiState.collectAsState()

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "ClassSelection") {
        composable("ClassSelection") {
            ClassSelection(navController = navController)
        }
        composable("TalentPoint?class={class}") { backStackEntry ->
            val selectedClass = backStackEntry.arguments?.getString("class") ?: "Warrior"
            TalentPoint(navController = navController, selectedClass = selectedClass)
        }
        composable("Summary") {
            Summary(navController = navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterCreationPreview() {
    Project2Theme() {
        val PreviewNavController = rememberNavController()
        NavHost(navController = PreviewNavController, startDestination = "ClassSelection") {
            composable("ClassSelection") {
                ClassSelection(navController = PreviewNavController)
            }
            composable("TalentPoint?class={class}") {
                TalentPoint(navController = PreviewNavController, selectedClass = "Warrior")
            }
            composable("Summary") {
                Summary(navController = PreviewNavController)
            }
        }
    }
}