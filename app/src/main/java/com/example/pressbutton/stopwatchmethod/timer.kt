package com.example.pressbutton.stopwatchmethod

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TimerScreenContent(timerViewModel: TimerVM) {
    val timerValue by timerViewModel.timer.collectAsState()

    TimerButton(
        timerValue = timerValue,
        onStartClick = { timerViewModel.startTimer() },
        onPauseClick = { timerViewModel.pauseTimer() },
        onStopClick = { timerViewModel.stopTimer() }
    )
}


@Composable
fun TimerButton(
    timerValue:Long,
    onStartClick: () -> Unit,
    onPauseClick: () -> Unit,
    onStopClick:()->Unit

){
    // This code yoinks the state of the button
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        , horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text = timerValue.formatTime(), fontSize = 24.sp)

        Button(
            onClick = { },
            interactionSource = interactionSource,
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 200.dp)
                .fillMaxWidth()
                .height(height=75.dp)
        ) {
            // Code here
            if(pressed){
                onStopClick
                onStartClick
            } else {
                onPauseClick
            }
            Text(text = "Press here: ${pressed}")
        }

    }

}

