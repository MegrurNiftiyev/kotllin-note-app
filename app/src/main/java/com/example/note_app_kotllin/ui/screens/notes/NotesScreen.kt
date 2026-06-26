package com.example.note_app_kotllin.ui.screens.notes


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.note_app_kotllin.R
import com.example.note_app_kotllin.core.navigation.NoteDetail
import com.example.note_app_kotllin.core.navigation.Settings
import com.example.note_app_kotllin.ui.screens.notes.components.NoteCard


@OptIn(ExperimentalMaterial3Api::class)
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NotesScreen(
    navController: NavHostController,
    viewModel: NotesViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            Column {
                TopAppBar(
                    title = {
                        Text(stringResource(R.string.app_name))
                    },
                    actions = {
                        IconButton(
                            onClick = {
                                navController.navigate(Settings)
                            }
                        ) {
                            Icon(
                                Icons.Default.Settings,
                                contentDescription = stringResource(id = R.string.settings_title)
                            )
                        }

                    }
                )
                HorizontalDivider(
                    thickness = 1.dp, color = MaterialTheme.colorScheme.primary
                )

            }

        },


        modifier = Modifier.fillMaxSize(), floatingActionButton = {
            FloatingActionButton(

                modifier = Modifier.background(color = MaterialTheme.colorScheme.primary),
                onClick = {
                    viewModel.addNote( "test", "test")
                }

            ) {
                Icon(Icons.Default.Add, contentDescription = null)

            }
        }
    ) { innerPadding ->

        if (state.notes.isEmpty()) {
            EmptyState()
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(state.notes) { pair ->
                    NoteCard(
                        title = pair.title,
                        subtitle = pair.content,
                        onClick = {
                            navController.navigate(NoteDetail(pair.id, pair.title, pair.content))
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun EmptyState() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.notes_empty_state),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
