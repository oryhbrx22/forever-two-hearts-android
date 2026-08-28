package com.foreverhearts.app.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "users")
@Serializable
data class UserEntity(
    @PrimaryKey
    val id: String,
    val email: String,
    val name: String,
    val avatar: String? = null,
    val createdAt: Long = System.currentTimeMillis()
)