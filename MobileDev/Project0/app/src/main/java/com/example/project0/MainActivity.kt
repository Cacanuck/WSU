package com.example.project0

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demo1.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.example.project0.ui.theme.Project0Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Project0Theme{
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CardImage(
                        name = stringResource(R.string.name),
                        cost = stringResource(R.string.cost),
                        cardType = stringResource(R.string.cardType),
                        cardText = stringResource(R.string.cardText),
                        power = stringResource(R.string.cardPower),
                        toughness = stringResource(R.string.cardToughness),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CardImage(name: String,
              cost: String,
              cardType: String,
              cardText: String,
              power: String,
              toughness: String,
              modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(colorResource(id = R.color.backgroundColor))
            .padding(16.dp)
            .border(BorderStroke(2.dp, Color.Black)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleCost(
            name = name,
            cost = cost,
            modifier = Modifier
                .padding(10.dp)
                .background(Color.LightGray)
        )
        Image(
            painter = painterResource(R.drawable.character),
            contentDescription = "Character Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .border(BorderStroke(1.dp, Color.Black))
        )
        CardType(
            cardType = cardType,
            modifier = Modifier
                .padding(10.dp)
                .background(Color.LightGray)
        )
        CardTextStats(
            cardText = cardText,
            power = power,
            toughness = toughness,
            modifier = Modifier
                .padding(10.dp)
                .border(BorderStroke(1.dp, Color.Black))
                .fillMaxWidth()
        )
    }
}

@Composable
fun TitleCost(name: String, cost: String, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .border(BorderStroke(1.dp, Color.Black))
    ) {
        Text(
            text = name,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 10.dp)
        )
        Text(
            text = cost,
            fontSize = 20.sp,
            modifier = Modifier.padding(end = 10.dp)
        )
    }
}

@Composable
fun CardType(modifier: Modifier = Modifier, cardType: String){
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .border(BorderStroke(1.dp, Color.Black))
    ) {
        Text (
            text = stringResource(R.string.cardType),
            modifier = Modifier
                .padding(start = 10.dp)
        )
    }
}

@Composable
fun CardTextStats(cardText: String, power: String, toughness: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = cardText,
            fontSize = 14.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(2.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "$power/$toughness",
                fontSize = 12.sp,
                modifier = Modifier
                    .align(Alignment.Bottom)
                    .padding(2.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview(){
    Project0Theme {
        CardImage(
            name = stringResource(R.string.name),
            cost = stringResource(R.string.cost),
            cardType = stringResource(R.string.cardType),
            cardText = stringResource(R.string.cardText),
            power = stringResource(R.string.cardPower),
            toughness = stringResource(R.string.cardToughness)
        )
    }
}