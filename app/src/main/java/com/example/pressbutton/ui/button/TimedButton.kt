package com.example.pressbutton.ui.button

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TimedButton(){
    // This code yoinks the state of the button
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()

    val timedButtonViewModel: TimedButtonVM = viewModel()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)
        , horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text = "You have pressed this button for ${timedButtonViewModel.diffRet} seconds",
            fontSize = 26.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top= 16.dp)
        )

        Button(
            onClick = { },
            interactionSource = interactionSource,
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 200.dp)
                .fillMaxWidth()
                .height(height=75.dp)
        ) {
            // Code here
            timedButtonViewModel.calcTime(pressed)

            Text(text = "Press here:")
        }
        
    }

}