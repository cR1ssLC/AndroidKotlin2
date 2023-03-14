package com.cr1ss.androidmod2.db.dbsqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, "databasetareas.db", null, 2) {

    override fun onCreate(myDb: SQLiteDatabase?) {

        myDb?.execSQL(
            "CREATE TABLE $nameTable ($columnId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$columnName TEXT, $columnDescription TEXT, $columnCreatedAt TEXT);"
        )
    }

    override fun onUpgrade(myDb: SQLiteDatabase?, p1: Int, p2: Int) {
        myDb?.execSQL("DROP TABLE IF EXISTS $nameTable")
        onCreate(myDb)
    }

    companion object {
        val nameTable = "tareas"
        val columnId = "id"
        val columnName = "name"
        val columnDescription = "description"
        val columnCreatedAt = "created_at"
    }

}