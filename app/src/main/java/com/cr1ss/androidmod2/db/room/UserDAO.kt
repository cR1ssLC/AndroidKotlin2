package com.cr1ss.androidmod2.db.room

import androidx.room.*
import com.cr1ss.androidmod2.models.UserModel

@Dao
interface UserDAO {
    @Insert
    fun create(userModel: UserModel): Long

    @Query("SELECT * FROM usermodel")
    fun read(): List<UserModel>

    @Update
    fun update(userModel: UserModel): Long

    @Delete
    fun delete(userModel: UserModel): Long
}