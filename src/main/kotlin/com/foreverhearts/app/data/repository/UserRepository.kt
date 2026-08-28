package com.foreverhearts.app.data.repository

import com.foreverhearts.app.data.database.dao.UserDao
import com.foreverhearts.app.data.database.entities.UserEntity
import com.foreverhearts.app.data.remote.SupabaseClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepository(private val userDao: UserDao) {

    fun getAllUsers(): Flow<List<UserEntity>> = userDao.getAllUsers()

    suspend fun getUserById(userId: String): UserEntity? {
        return userDao.getUserById(userId)
    }

    suspend fun syncUsersFromRemote(): Flow<List<UserEntity>> = flow {
        try {
            // Fetch from Supabase
            val remoteUsers = SupabaseClient.postgrest
                .from("users")
                .select()
                .decodeList<UserEntity>()

            // Save to local database
            remoteUsers.forEach { userDao.insertUser(it) }
            
            emit(remoteUsers)
        } catch (e: Exception) {
            emit(userDao.getAllUsers().value ?: emptyList())
        }
    }

    suspend fun createUser(user: UserEntity) {
        userDao.insertUser(user)
        // Also sync to remote if needed
    }

    suspend fun updateUser(user: UserEntity) {
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: UserEntity) {
        userDao.deleteUser(user)
    }
}