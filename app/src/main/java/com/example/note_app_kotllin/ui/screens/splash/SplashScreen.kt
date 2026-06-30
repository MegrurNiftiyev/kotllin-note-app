package com.example.note_app_kotllin.ui.screens.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.note_app_kotllin.core.navigation.Home
import com.example.note_app_kotllin.core.navigation.Register
import com.example.note_app_kotllin.core.navigation.Splash

@Composable
fun SplashScreen(
    navController: NavHostController, viewModel: SplashViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    LaunchedEffect(state.isAuthenticated) {

        if (state.isAuthenticated) {
            navController.navigate(Home) {
                popUpTo(Splash) {
                    inclusive = true
                }
            }

        } else {
            navController.navigate(Register) {
                popUpTo(Splash) {
                    inclusive = true
                }
            }

        }

    }
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

        }

    }
}