package com.cr1ss.androidmod2.ui.corrutinas

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.cr1ss.androidmod2.databinding.ActivityDbrawBinding
import kotlinx.coroutines.*

class CoroutinesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDbrawBinding
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDbrawBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            counter++
            binding.tvCounter.text = "$counter"
        }

        binding.btnReduce.setOnClickListener {
            counter--
            binding.tvCounter.text = "$counter"
        }

        binding.btnInsert.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                saludar(3L)
                val ini = System.currentTimeMillis()
                Log.e("TAG", "onCreate: Inicio")
                // async devuelve Defered<Long>
                val l1d = async { tardar(1000L) }
                Log.e("TAG", "onCreate: Operacion medio")
                val l2d = async { tardar(1000L) }
                val l3d = async { tardar(4000L) }
                Log.e("TAG", "onCreate: Operacion terminada")
                val l1 = l1d.await()
                val l2 = l2d.await()
                val l3 = l3d.await()
                val fin = System.currentTimeMillis()
                Log.e("TAG", "onCreate: Operacion terminada ${(fin - ini) / 1000}")


            }
        }
    }

    suspend fun tardar(seg: Long) : Long{
        delay(seg)

        return seg
    }

    fun saludar(seg: Long) {
        Log.e("TAG", "Saludo")
    }
}