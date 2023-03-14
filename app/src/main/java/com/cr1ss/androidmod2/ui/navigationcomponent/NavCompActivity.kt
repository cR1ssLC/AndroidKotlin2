package com.cr1ss.androidmod2.ui.navigationcomponent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cr1ss.androidmod2.databinding.ActivityNavCompBinding

class NavCompActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNavCompBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}