package com.example.note_app_kotllin.ui.screens.todo.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.note_app_kotllin.core.constants.AppDurations
import com.example.note_app_kotllin.core.constants.BorderRadiuses
import com.example.note_app_kotllin.core.constants.Paddings

@Composable
fun TodoCard(
    description: String,
    isCompleted: Boolean,
    isFocused: Boolean,
    onTextChange: (String) -> Unit,
    onFocusChange: (Boolean) -> Unit,
    onCheckedChange: (Boolean) -> Unit
) {
    val focusRequester = remember { FocusRequester() }


    val textColor by animateColorAsState(
        targetValue = if (isCompleted) MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
        else MaterialTheme.colorScheme.onSurface,
        animationSpec = tween(durationMillis = AppDurations.ExtraShort.toInt()),
        label = "ColorAnimation"
    )

    LaunchedEffect(isFocused) {
        if (isFocused) {
            focusRequester.requestFocus()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 120.dp)
            .shadow(
                elevation = 3.dp, shape = RoundedCornerShape(BorderRadiuses.Medium), clip = false
            )
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(BorderRadiuses.Medium)
            )
            .clickable { focusRequester.requestFocus() }
            .padding(Paddings.Small)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Checkbox(checked = isCompleted, onCheckedChange = onCheckedChange)

            BasicTextField(
                value = description,
                onValueChange = onTextChange,
                modifier = Modifier
                    .weight(1f)
                    .focusRequester(focusRequester)
                    .onFocusChanged { onFocusChange(it.isFocused) },
                textStyle = MaterialTheme.typography.bodyLarge.copy(
                    color = textColor,
                    textDecoration = if (isCompleted) TextDecoration.LineThrough else TextDecoration.None
                )
            )
        }
    }
}

