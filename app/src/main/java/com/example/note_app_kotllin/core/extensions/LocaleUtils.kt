package com.example.note_app_kotllin.core.extensions

import android.app.LocaleManager
import android.content.Context
import android.os.Build
import android.os.LocaleList
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat

fun Context.changeLanguage(languageCode: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        val localeManager = this.getSystemService(Context.LOCALE_SERVICE) as LocaleManager
        localeManager.applicationLocales = LocaleList.forLanguageTags(languageCode)
    } else {
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(languageCode))
    }
}

val Context.getCurrentLanguage: String
    get() {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val localeManager = this.getSystemService(Context.LOCALE_SERVICE) as LocaleManager
            val appLocales = localeManager.applicationLocales.toLanguageTags()
            appLocales.ifEmpty {
                LocaleList.getDefault()[0]?.language ?: "en"
            }
        } else {
            val appLocales = AppCompatDelegate.getApplicationLocales().toLanguageTags()
            appLocales.ifEmpty {
                LocaleListCompat.getDefault()[0]?.language ?: "en"
            }
        }
    }