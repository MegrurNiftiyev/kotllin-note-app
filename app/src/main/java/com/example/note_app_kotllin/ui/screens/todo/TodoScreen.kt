package com.example.note_app_kotllin.ui.screens.todo

import android.annotation.SuppressLint
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.note_app_kotllin.core.constants.Paddings
import com.example.note_app_kotllin.core.constants.Spaces
import com.example.note_app_kotllin.ui.screens.todo.components.TodoCard

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoScreen(
    navController: NavHostController,
    parentPadding: PaddingValues = PaddingValues(),
    viewModel: TodoViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val listState = rememberLazyListState()
    val focusManager = LocalFocusManager.current

    val displayedTodos = remember(state.todos, state.draftTodo) {
        val draft = state.draftTodo
        if (draft != null) listOf(draft) + state.todos else state.todos
    }

    LaunchedEffect(state.todos.size) {
        if (state.todos.isNotEmpty()) {
            listState.animateScrollToItem(0)
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            viewModel.handleScreenExit()
        }
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                containerColor = MaterialTheme.colorScheme.primary,
                onClick = { viewModel.createTodo() },
                modifier = Modifier.offset(y = -parentPadding.calculateBottomPadding())
            ) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures(onTap = { focusManager.clearFocus() })
                }
        ) {
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = parentPadding.calculateTopPadding()),
                contentPadding = PaddingValues(Paddings.Medium),
                verticalArrangement = Arrangement.spacedBy(Spaces.Medium)
            ) {
                itemsIndexed(displayedTodos, key = { _, item -> item.id.ifEmpty { "draft" } }) { _, item ->
                    TodoCard(
                        initialDescription = item.description,
                        isCompleted = item.isCompleted,
                        isFocused = state.focusedTodoId == item.id,
                        onFocusGained = { viewModel.onFocusGained(item.id, item.description) },
                        onTextChange = { viewModel.onTextChange(it) },
                        onFocusLost = { viewModel.handleFocusLost(item.id, it, item.isCompleted) },
                        onCheckedChange = { viewModel.updateTodoCompletion(item.id, item.description, it) },
                        onLongClick = { viewModel.deleteTodo(item.id) }
                    )
                }
            }
        }
    }
}