package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                // A surface container using the 'background' color from the theme
                DiceRoller()
            }
        }
    }
}
@Preview///(showBackground = true)
@Composable
fun DiceRoller(){
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentHeight(Alignment.Top)
    )
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var resultDiceRollerDos by remember {
        mutableStateOf(6)
    }
    var resultDiceRollerUno by remember {
        mutableStateOf(4)
    }


    Row(
        modifier = modifier.padding(horizontal = 0.dp, vertical = 0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = getValorRoller(resultDiceRollerDos)),
            contentDescription = resultDiceRollerDos.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = getValorRoller(resultDiceRollerUno)),
            contentDescription = resultDiceRollerUno.toString()
        )
    }
    Column(
        modifier = modifier.padding(horizontal = 170.dp, vertical = 300.dp)
    ) {
        Button(onClick = {
            resultDiceRollerUno = (1..6).random()
            resultDiceRollerDos = (1..6).random()
        }) {
            Text(stringResource(R.string.roll))
        }
    }



}

fun Column(modifier: Modifier, verticalArrangement: Alignment, content: ColumnScope.() -> Unit) {

}


private fun getValorRoller(valor : Int):Int{
    val imageResource=when(valor){
        1->R.drawable.dice_1
        2->R.drawable.dice_2
        3->R.drawable.dice_3
        4->R.drawable.dice_4
        5->R.drawable.dice_5
        else ->R.drawable.dice_6
    }

    return imageResource
}