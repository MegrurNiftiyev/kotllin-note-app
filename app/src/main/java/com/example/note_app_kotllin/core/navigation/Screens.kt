package com.example.note_app_kotllin.core.navigation


sealed class Screens(val route: String) {
    object Notes : Screens("notes")

    object NoteDetail : Screens("note_detail/{id}/{title}/{subtitle}") {
        fun createRoute(id: String, title: String, subtitle: String) =
            "note_detail/$id/$title/$subtitle"
    }

    object  Settings : Screens("settings")
}