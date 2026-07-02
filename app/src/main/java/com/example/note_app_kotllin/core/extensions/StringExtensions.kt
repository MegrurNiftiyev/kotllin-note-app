package com.example.note_app_kotllin.core.extensions

fun String.isValidEmail(): Boolean {
    val emailRegex = """[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}""".toRegex()
    return emailRegex.matches(this)
}

fun String.isValidPassword(): Boolean {
    val passwordRegex = """^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\S+$).{8,}$""".toRegex()
    return passwordRegex.matches(this)
}

fun String.isValidUserName(): Boolean {
    val userNameRegex = """^[a-zA-Z0-9._-]{3,}$""".toRegex()
    return userNameRegex.matches(this)
}

fun String.addLocalBanner(): String = "LOCAL_$this"

fun String.isLocal(): Boolean = this.startsWith("LOCAL_")