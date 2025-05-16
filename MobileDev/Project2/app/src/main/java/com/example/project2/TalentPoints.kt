package com.example.project2

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.LaunchedEffect

@Composable
fun TalentPoint(navController: NavController, selectedClass: String,  viewModel: CharacterCreatorViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(selectedClass) {
        when (selectedClass) {
            "Warrior" -> viewModel.resetCharacter("Warrior")
            "Mage" -> viewModel.resetCharacter("Mage")
            "Rogue" -> viewModel.resetCharacter("Rogue")
            "Archer" -> viewModel.resetCharacter("Archer")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Choose the Stats for $selectedClass")

        Spacer(Modifier.height(16.dp))

        StatSelection(
            characterCreatorViewModel = viewModel,
            characterCreatorUiState = uiState,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))
        Row {
            Button(onClick = { navController.popBackStack() }) {
                Text("Back")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { navController.navigate("Summary") }) {
                Text("Next")
            }
        }
    }
}

@Composable
fun StatSelection(
    characterCreatorViewModel: CharacterCreatorViewModel,
    characterCreatorUiState: CharacterCreatorUiState,
    modifier: Modifier = Modifier
) {

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        StatTextBoxesRow(
            statLeft = R.string.stamina,
            statRight = R.string.strength,
            iconLeft = R.drawable.baseline_heart_broken_24,
            iconRight = R.drawable.baseline_shield_24,
            valLeft = characterCreatorUiState.stamina,
            valRight = characterCreatorUiState.strength,
            onLeftPlusClick = { characterCreatorViewModel.incStamina() },
            onLeftMinusClick = { characterCreatorViewModel.decStamina() },
            onRightPlusClick = { characterCreatorViewModel.incStrength() },
            onRightMinusClick = { characterCreatorViewModel.decStrength() }
        )

        StatTextBoxesRow(
            statLeft = R.string.agility,
            statRight = R.string.intellect,
            iconLeft = R.drawable.baseline_bolt_24,
            iconRight = R.drawable.baseline_self_improvement_24,
            valLeft = characterCreatorUiState.agility,
            valRight = characterCreatorUiState.intellect,
            onLeftPlusClick = { characterCreatorViewModel.incAgility() },
            onLeftMinusClick = { characterCreatorViewModel.decAgility() },
            onRightPlusClick = { characterCreatorViewModel.incIntellect() },
            onRightMinusClick = { characterCreatorViewModel.decIntellect() }
        )
        Spacer(Modifier.height(16.dp))

    }
}

@Composable
fun StatTextBoxesRow(
    @StringRes statLeft: Int,
    @StringRes statRight: Int,
    @DrawableRes iconLeft: Int,
    @DrawableRes iconRight: Int,
    valLeft: Int,
    valRight: Int,
    onLeftPlusClick: () -> Unit,
    onLeftMinusClick: () -> Unit,
    onRightPlusClick: () -> Unit,
    onRightMinusClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        EditNumberField(
            label = statLeft,
            leadingIcon = iconLeft,
            keyboardOptions = KeyboardOptions(),
            value = valLeft.toString(),
            onPlusClick = onLeftPlusClick,
            onMinusClick = onLeftMinusClick
        )
        EditNumberField(
            label = statRight,
            leadingIcon = iconRight,
            keyboardOptions = KeyboardOptions(),
            value = valRight.toString(),
            onPlusClick = onRightPlusClick,
            onMinusClick = onRightMinusClick
        )
    }
}

@Composable
fun EditNumberField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    keyboardOptions: KeyboardOptions,
    value: String,
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = onPlusClick) {
            Text("+")
        }
        Row {
            Icon(painterResource(leadingIcon), null)
            Text(text = stringResource(label))
        }
        Text(text = value)
        Button(onClick = onMinusClick) {
            Text("-")
        }
    }
}
