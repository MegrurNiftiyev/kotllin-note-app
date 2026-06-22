package com.example.note_app_kotllin.ui.screens.auth.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle

@Composable
fun RichText(
    clickableText: String,
    onLinkClicked: () -> Unit,
    modifier: Modifier = Modifier,
    startText: String = "",
    endText: String = ""
) {
    val annotatedText = buildAnnotatedString {
        if (startText.isNotEmpty()) {
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f))) {
                append(startText)
            }
        }

        withLink(
            link = LinkAnnotation.Clickable(
                tag = "RICH_TEXT_CLICK",
                styles = TextLinkStyles(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                ),
                linkInteractionListener = { _ ->
                    onLinkClicked()
                }
            )
        ) {
            append(clickableText)
        }
        if (endText.isNotEmpty()) {
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f))) {
                append(endText)
            }
        }
    }

    Text(
        text = annotatedText,
        modifier = modifier,
        style = MaterialTheme.typography.bodyLarge
    )
}