package com.example.hiltandroidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.hiltandroidapp.core.ui.theme.HiltAndroidAppTheme

class SecondActivity:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HiltAndroidAppTheme{

            }
        }
    }
}