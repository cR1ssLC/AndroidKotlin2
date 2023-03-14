package com.cr1ss.androidmod2.ui.home
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cr1ss.androidmod2.models.DogModel

class HomeViewModel:ViewModel() {
    val counter= MutableLiveData<Int>(0)

    private val _d1= MutableLiveData<DogModel>()
    val d1:LiveData<DogModel> = _d1

    fun add(){
        val oldD1 = _d1.value?:
        DogModel("Pitbull",2,"Negro", "Box")
        oldD1.ageDog++
        _d1.value=oldD1
    }
    fun minus(){
        val oldD1 = _d1.value?:
        DogModel("Pitbull",2,"Negro", "Box")
        oldD1.ageDog--
        _d1.value=oldD1
    }
}