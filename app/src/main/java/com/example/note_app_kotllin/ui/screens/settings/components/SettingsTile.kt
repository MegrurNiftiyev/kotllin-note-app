package com.example.note_app_kotllin.ui.screens.settings.components

import android.text.Layout
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.note_app_kotllin.core.constants.BorderRadiuses
import com.example.note_app_kotllin.core.constants.Paddings
@Composable
fun SettingTile(
    title: String? = null,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.SpaceBetween,
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    trailingContent: @Composable (() -> Unit)? = null
) {
    val shape = RoundedCornerShape(BorderRadiuses.Medium)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Paddings.MediumPlus, vertical = Paddings.Small)
            .border(width = 1.dp, color = MaterialTheme.colorScheme.outline, shape = shape)
            .clip(shape)
            .clickable { onClick() }
            .padding(horizontal = Paddings.ExtraLarge, vertical = Paddings.MediumPlus)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = horizontalArrangement,
            verticalAlignment = verticalAlignment
        ) {
            if (!title.isNullOrBlank()) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            trailingContent?.invoke()
        }
    }
}