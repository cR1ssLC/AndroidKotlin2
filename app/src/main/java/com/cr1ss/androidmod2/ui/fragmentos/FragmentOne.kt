package com.cr1ss.androidmod2.ui.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cr1ss.androidmod2.databinding.FragmentOneBinding

class FragmentOne : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOneBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}