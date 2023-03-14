package com.cr1ss.androidmod2.db.dbsqlite

import android.content.ContentValues
import android.util.Log
import com.cr1ss.androidmod2.models.TareaModel

class DBManager(private val dbHelper: DBHelper) {

    fun insert(tareaModel: TareaModel) {
//        INSERT INTO tareas (nombre, description, create_at)
        //        VALUES ("tarea1", "esto es una description", "18-12-2021");

        val db = dbHelper.writableDatabase

//        val values = ContentValues()
//        values.put(DBHelper.columnName, tareaModel.name)
//        values.put(DBHelper.columnDescription, tareaModel.desc)
//        values.put(DBHelper.columnCreatedAt, tareaModel.createdAt)

        val newId = db.insert(DBHelper.nameTable, null, tareaModel.toContentValue())
        Log.e("TAG", "insert: $newId")
    }

    fun read(idQuery: Long? = null): List<TareaModel> {
        val tmpList = mutableListOf<TareaModel>()
        val db = dbHelper.readableDatabase
        var where: String? = null
        var whereArgs: Array<String>? = null
        if (idQuery != null) {
            where = "${DBHelper.columnId} LIKE ?"
            whereArgs = arrayOf(idQuery.toString())
        }

        val cursor = db.query(
            DBHelper.nameTable, null, where, whereArgs, null, null, null
        )

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getLong(cursor.getColumnIndexOrThrow(DBHelper.columnId))
                val name = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.columnName))
                val description =
                    cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.columnDescription))
                val createdAt =
                    cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.columnCreatedAt))

                tmpList.add(TareaModel(id, name, description, createdAt))

                Log.e("TAG", "read: $id $name $description $createdAt")
            } while (cursor.moveToNext())
        }
        cursor.close()
        return tmpList
    }

    fun update(idQuery: String, tareaModel: TareaModel) {
        val db = dbHelper.writableDatabase

//        val values = ContentValues()
//        values.put(DBHelper.columnName, "Tarea 1")
//        values.put(DBHelper.columnDescription, "Esto es una descripcion de tareas")

        val where = "${DBHelper.columnId} = ?"
        val whereArgs = arrayOf(idQuery)

        val count = db.update(DBHelper.nameTable, tareaModel.toContentValue(), where, whereArgs)
        Log.e("TAG", "update: $count")
    }

    fun delete(idQuery: String) {
        val db = dbHelper.writableDatabase
        val where = "${DBHelper.columnId} = ?"
        val whereArgs = arrayOf(idQuery)

        val count = db.delete(DBHelper.nameTable, where, whereArgs)
        Log.e("TAG", "delete: $count")
    }
}