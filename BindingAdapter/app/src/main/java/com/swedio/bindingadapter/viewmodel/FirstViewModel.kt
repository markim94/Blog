package com.swedio.bindingadapter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstViewModel : ViewModel() {

    private val _confirmText: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun updateConfirmText(text: String) {
        _confirmText.value = text
    }

    fun getConfirmText(): LiveData<String> {
        return _confirmText
    }

    val typingText: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun onClickConfirmButton() {
        val typingTxt = typingText.value ?: return
        if (typingTxt.length < 0) {
            return

        } // end if

        updateConfirmText(typingTxt)

    }

}