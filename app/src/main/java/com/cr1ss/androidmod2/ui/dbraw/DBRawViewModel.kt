package com.cr1ss.androidmod2.ui.dbraw

import android.app.Application
import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cr1ss.androidmod2.db.dbsqlite.DBHelper
import com.cr1ss.androidmod2.db.dbsqlite.DBManager
import com.cr1ss.androidmod2.models.TareaModel

class DBRawViewModel(application: Application) : AndroidViewModel(application) {


    private var db: DBManager = DBManager(DBHelper(application.baseContext))

    init {
        getAllData()
    }


    private val _progress = MutableLiveData(0)
    val progress: LiveData<Int> = _progress



    fun cargaMasiva() {
        val task = MyTask()
        task.execute(500)
    }

    fun insert(tareaModel: TareaModel) {
        db.insert(tareaModel)
    }

    private fun getAllData(): List<TareaModel> = db.read()


    private fun createFakeTarea(): TareaModel =
        TareaModel(name = "Tarea fake", desc = "Desc", createdAt = "18-12-2021")


    inner class MyTask : AsyncTask<Long, Int, String>() {

        override fun onPreExecute() {
            super.onPreExecute()
            _progress.postValue(0)

        }

        override fun doInBackground(vararg p0: Long?): String {
            for (i in 0..10) {
                Thread.sleep(p0.first()!!)
                publishProgress(i * 10)
                db.insert(createFakeTarea())
            }
            return "Operacion terminada"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            Log.e("TAG", "onPostExecute: $result")
            _progress.postValue(0)
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            _progress.postValue(values.first())
        }

    }
}