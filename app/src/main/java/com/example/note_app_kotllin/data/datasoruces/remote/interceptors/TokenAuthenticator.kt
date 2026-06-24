package com.example.note_app_kotllin.data.datasoruces.remote.interceptors

import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenAuthenticator @Inject constructor() : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {

        return null
    }
}