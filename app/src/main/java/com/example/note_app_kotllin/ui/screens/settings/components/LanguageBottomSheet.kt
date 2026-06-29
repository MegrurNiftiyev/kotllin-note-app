package com.example.note_app_kotllin.ui.components

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.example.note_app_kotllin.R
import com.example.note_app_kotllin.core.constants.Paddings
import com.example.note_app_kotllin.core.enums.LanguageCodes
import com.example.note_app_kotllin.core.extensions.changeLanguage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageBottomSheet(
    onDismissRequest: () -> Unit
) {
    val context = LocalContext.current


    ModalBottomSheet(
        sheetState = rememberModalBottomSheetState(),
        onDismissRequest = onDismissRequest
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Paddings.MediumPlus)
        ) {
            Text(
                text = stringResource(R.string.language_sheet_title),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = Paddings.Medium)
            )

            LangItem(
                context = context,
                langCode = LanguageCodes.az,
                languageResId = R.string.lang_az,
                onDismissRequest = onDismissRequest
            )

            LangItem(
                context = context,
                langCode = LanguageCodes.en,
                languageResId = R.string.lang_en,
                onDismissRequest = onDismissRequest
            )
            LangItem(
                context = context,
                langCode = LanguageCodes.tr,
                languageResId = R.string.lang_tr,
                onDismissRequest = onDismissRequest
            )

        }

    }
}


@Composable
fun LangItem(
    context: Context,
    langCode: LanguageCodes,
    languageResId: Int,
    onDismissRequest: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                context.changeLanguage(langCode.toString())
                onDismissRequest()
            }
            .padding(vertical = Paddings.Medium)
    ) {
        Text(
            text = stringResource(languageResId),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}