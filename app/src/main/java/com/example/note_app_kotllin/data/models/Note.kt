package com.example.note_app_kotllin.data.models

import android.icu.text.CaseMap

data class Note(
    val id: String=java.util.UUID.randomUUID().toString() ,
    val title: String,
    val subtitle : String
)