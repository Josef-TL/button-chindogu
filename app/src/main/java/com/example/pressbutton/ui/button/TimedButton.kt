package com.example.pressbutton.ui.button

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlin.math.log

@Composable
fun TimedButton(){
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()

    val timedButtonViewModel: TimedButtonVM = viewModel()

    Box(modifier = Modifier
        .fillMaxSize()
        , contentAlignment = Alignment.Center)
    {

        Button(
            onClick = { },
            interactionSource = interactionSource,
        ) {
            // Code here
            timedButtonViewModel.calcTime(pressed)

            Text(text = "Press here")
        }
        
    }

}