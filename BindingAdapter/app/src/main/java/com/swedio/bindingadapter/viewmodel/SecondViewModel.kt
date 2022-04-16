package com.swedio.bindingadapter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondViewModel : ViewModel() {

    val imageUrl: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun onClickImportImg() {
        imageUrl.value = "https://i.ibb.co/Ttbty0L/img-logo.jpg"

    }

}