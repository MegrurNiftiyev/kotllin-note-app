package com.example.note_app_kotllin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.note_app_kotllin.core.navigation.NoteAppNavGraph
import com.example.note_app_kotllin.core.theme.NoteappkotllinTheme
import com.example.note_app_kotllin.ui.screens.settings.SettingsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val settingsViewModel: SettingsViewModel = hiltViewModel()
            val settingsState by settingsViewModel.state.collectAsStateWithLifecycle()

            NoteappkotllinTheme(darkTheme = settingsState.isDarkMode, dynamicColor = false) {
                NoteAppNavGraph( )
            }
        }
    }
}

