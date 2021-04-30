package com.scappworks.whereshouldieat.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddLocationViewModel : ViewModel(){
    private val locationToAdd = MutableLiveData<String>("test string")
    val location:LiveData<String> get() = locationToAdd

    fun setLocation(s: String) {
        locationToAdd.value = s
    }
}