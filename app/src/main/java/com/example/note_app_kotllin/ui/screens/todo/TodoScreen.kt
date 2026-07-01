package com.example.note_app_kotllin.ui.screens.todo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.note_app_kotllin.core.constants.Paddings
import com.example.note_app_kotllin.core.constants.Spaces
import com.example.note_app_kotllin.ui.screens.todo.components.TodoCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoScreen(
    navController: NavHostController,
    parentPadding: PaddingValues = PaddingValues(),
    viewModel: TodoViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    Scaffold(
        floatingActionButton = {
        FloatingActionButton(
            containerColor = MaterialTheme.colorScheme.primary,
            onClick = {},
            modifier = Modifier.offset(y = parentPadding.calculateBottomPadding())

        ) {
            Icon(Icons.Default.Edit, contentDescription = null)
        }
    }) {

        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(top = parentPadding.calculateTopPadding()),
            contentPadding = PaddingValues(Paddings.Medium),
            verticalArrangement = Arrangement.spacedBy(Spaces.Medium)
            ) {
            items(state.todos) { item ->
                TodoCard(
                    description = item.description,
                    isCompleted = item.isCompleted,
                    isFocused = true,
                    onTextChange = {},
                    onFocusChange = {},
                    onCheckedChange = {}
                )
            }
        }
    }
}