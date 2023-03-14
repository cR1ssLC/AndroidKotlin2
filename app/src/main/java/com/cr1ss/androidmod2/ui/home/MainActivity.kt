package com.cr1ss.androidmod2.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.cr1ss.androidmod2.databinding.ActivityMainBinding
import com.cr1ss.androidmod2.models.DogModel

class MainActivity : AppCompatActivity() {
    lateinit var d1: DogModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vm:HomeViewModel by viewModels()

        vm.d1.observe(this){
            binding.tvDog.text=it.toString()
        }

        binding.bt1.setOnClickListener {
            vm.add()
        }

        binding.bt2.setOnClickListener {
            vm.minus()
        }
    }
}