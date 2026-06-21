package com.example.note_app_kotllin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.note_app_kotllin.core.navigation.NoteAppNavGraph
import com.example.note_app_kotllin.ui.theme.NoteappkotllinTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteappkotllinTheme() {
                NoteAppNavGraph()
            }
        }
    }
}


