package com.example.note_app_kotllin

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
class NoteApplication : Application() {
//    override fun onCreate() {
//        super.onCreate()
//
//        // 1. App başlayanda dil tənzimləməsi
//        // (AppCompatDelegate artıq özü saxlayır, amma başlanğıc dəyəri set etmək istəsən)
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
//
//        // 2. Logging (debug üçün)
//        if (BuildConfig.DEBUG) {
//            Timber.plant(Timber.DebugTree())
//        }
//
//        // 3. Digər SDK init-ləri (Firebase, analytics, və s.)
//    }
}
