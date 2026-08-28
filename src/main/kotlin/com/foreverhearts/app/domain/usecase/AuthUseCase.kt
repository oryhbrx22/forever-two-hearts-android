package com.foreverhearts.app.domain.usecase

import com.foreverhearts.app.data.remote.SupabaseClient
import kotlinx.coroutines.flow.flow

class AuthUseCase {

    fun login(email: String, password: String) = flow {
        try {
            val result = SupabaseClient.auth.signInWithPassword(
                email = email,
                password = password
            )
            emit(Result.success(result))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    fun signup(email: String, password: String) = flow {
        try {
            val result = SupabaseClient.auth.signUpWithPassword(
                email = email,
                password = password
            )
            emit(Result.success(result))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    fun logout() = flow {
        try {
            SupabaseClient.auth.signOut()
            emit(Result.success(Unit))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}