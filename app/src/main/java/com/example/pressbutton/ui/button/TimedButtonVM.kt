package com.example.pressbutton.ui.button

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

public class TimedButtonVM: ViewModel() {
    private var pressedStartTime: Long = 0
    private var difference:Long = 0
    var diffRet by mutableStateOf("0")

    fun calcTime(pressed:Boolean) {
        if (pressed) {
            pressedStartTime = System.currentTimeMillis()
        } else {
            difference = System.currentTimeMillis() - pressedStartTime
            Log.d(TAG,"$difference")
            diffRet = (difference/1000).toString()
        }
    }


}