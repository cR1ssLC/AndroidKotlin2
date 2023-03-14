package com.cr1ss.androidmod2.ui.fragmentos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentosViewModel : ViewModel() {

    private val _goToNextActivity = MutableLiveData(false)
    val goToNextActivity: LiveData<Boolean> = _goToNextActivity

    fun nextPage() {
        _goToNextActivity.value = true
    }
}