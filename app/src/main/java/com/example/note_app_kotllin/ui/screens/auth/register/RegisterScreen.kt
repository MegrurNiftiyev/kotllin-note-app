package com.example.note_app_kotllin.ui.screens.auth.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.note_app_kotllin.core.constants.Paddings
import com.example.note_app_kotllin.core.navigation.Login
import com.example.note_app_kotllin.core.navigation.Notes
import com.example.note_app_kotllin.data.models.Note
import com.example.note_app_kotllin.ui.screens.auth.components.CustomTextField
import com.example.note_app_kotllin.ui.screens.auth.components.RichText

@Preview
@Composable
fun RegisterScreen(
    navController: NavHostController = rememberNavController(),
            viewModel: RegisterViewModel = hiltViewModel()
) {
    var userNameTextInput by remember { mutableStateOf("") }
    var emailTextInput by remember { mutableStateOf("") }
    var passwordTextInput by remember { mutableStateOf("") }
    var confirmPasswordTextInput by remember { mutableStateOf("") }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
                .padding(innerPadding)
        ) {
            Spacer(modifier = Modifier.height(70.dp))

            Text(
                text = "Welcome to Note App",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(Paddings.Medium)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Paddings.Large)
            ) {
                CustomTextField(
                    value = userNameTextInput,
                    onValueChange = { userNameTextInput = it },
                    label = "User Name",
                    placeholder = "Enter your username"
                )
                CustomTextField(
                    value = emailTextInput,
                    onValueChange = { emailTextInput = it },
                    label = "Email",
                    placeholder = "Enter your email"
                )
                CustomTextField(
                    value = passwordTextInput,
                    onValueChange = { passwordTextInput = it },
                    label = "Password",
                    placeholder = "Enter your password"
                )
                CustomTextField(
                    value = confirmPasswordTextInput,
                    onValueChange = { confirmPasswordTextInput = it },
                    label = "Confirm Password",
                    placeholder = "Repeat your password"
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(), onClick = {   navController.navigate(Notes) }
                )
                {
                    Text(text = "Register", style = MaterialTheme.typography.bodyLarge)
                }
                RichText(
                    startText = "Already have an account? ",
                    clickableText = "log in",
                    onLinkClicked = { navController.navigate(Login) },
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(Paddings.Tiny)
                )
            }
        }
    }
}