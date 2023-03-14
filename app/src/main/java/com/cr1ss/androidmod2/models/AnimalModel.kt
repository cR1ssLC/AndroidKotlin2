package com.cr1ss.androidmod2.models

import android.util.Log

open class AnimalModel (
    private var age:Int,
    private val color:String,
    private val name:String,
        ){
    fun comer(){
        Log.e("TAG","Animal Comiendo")
    }
    fun caminar(){
        Log.e("TAG","Animal Caminando")
    }

}