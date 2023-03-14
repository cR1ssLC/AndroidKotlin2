package com.cr1ss.androidmod2.models

import android.content.ContentValues
import com.cr1ss.androidmod2.db.dbsqlite.DBHelper

data class TareaModel(
    val id: Long? = null,
    var name: String,
    var desc: String,
    var createdAt: String,
) {
    fun toContentValue(): ContentValues {
        return ContentValues().apply {
            put(DBHelper.columnName, name)
            put(DBHelper.columnDescription, desc)
            put(DBHelper.columnCreatedAt, createdAt)
        }
    }
}