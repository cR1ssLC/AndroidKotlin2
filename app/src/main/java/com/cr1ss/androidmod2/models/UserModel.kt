package com.cr1ss.androidmod2.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserModel (
    var name: String,
    var age: Int,
    var gender: Boolean,

    @PrimaryKey(autoGenerate = true)
    val id: Long?= null,
)