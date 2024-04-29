package com.example.pressbutton.ui.button

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel

public class TimedButtonVM: ViewModel() {
    var pressedStartTime: Long = 0
    var difference:Long = 0

    fun calcTime(pressed:Boolean) {
        if (pressed) {
            pressedStartTime = System.currentTimeMillis()
        } else {
            difference = System.currentTimeMillis() - pressedStartTime
            Log.d(TAG,"$difference")
        }
    }


}