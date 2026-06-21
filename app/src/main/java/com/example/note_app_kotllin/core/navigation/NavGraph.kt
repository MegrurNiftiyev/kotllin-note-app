package com.example.note_app_kotllin.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.note_app_kotllin.ui.screens.notedetail.NoteDetailScreen
import com.example.note_app_kotllin.ui.screens.notes.NotesScreen
import com.example.note_app_kotllin.ui.screens.settings.SettingsScreen

@Composable
fun NoteAppNavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Notes.route
    ) {
        composable(Screens.Notes.route) {
            NotesScreen(navController = navController)
        }

        composable(Screens.NoteDetail.route) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id") ?: ""
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val subtitle = backStackEntry.arguments?.getString("subtitle") ?: ""
            NoteDetailScreen(id, title, subtitle, navController)
        }
        composable(Screens.Settings.route) {
            SettingsScreen(navController = navController)
        }
    }
}