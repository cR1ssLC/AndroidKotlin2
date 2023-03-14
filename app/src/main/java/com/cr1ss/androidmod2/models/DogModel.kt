package com.cr1ss.androidmod2.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DogModel(
    val race:String,
    var ageDog:Int,
    val colorDog:String,
    val nameDog:String,
) :AnimalModel(ageDog,colorDog,nameDog), Parcelable

//class DogModel(
//    val race:String,
//    age,
//   color,
//    name
//):AnimalModel(age,color,name)