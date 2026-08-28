package com.foreverhearts.app.data.remote

import io.github.supabase_community.auth.Auth
import io.github.supabase_community.postgrest.Postgrest
import io.github.supabase_community.realtime.Realtime
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object SupabaseClient {
    private const val SUPABASE_URL = "YOUR_SUPABASE_URL"
    private const val SUPABASE_KEY = "YOUR_SUPABASE_ANON_KEY"

    private val httpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(
                Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }
    }

    // Initialize Supabase Auth
    val auth: Auth = Auth(
        url = SUPABASE_URL,
        key = SUPABASE_KEY,
        client = httpClient
    )

    // Initialize Supabase Postgrest (for database queries)
    val postgrest: Postgrest = Postgrest(
        url = SUPABASE_URL,
        headers = mapOf("Authorization" to "Bearer $SUPABASE_KEY")
    )

    // Initialize Supabase Realtime (for real-time updates)
    val realtime: Realtime = Realtime(
        url = SUPABASE_URL.replace("https", "wss"),
        key = SUPABASE_KEY
    )
}