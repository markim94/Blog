package com.swedio.mvvm.main.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.swedio.mvvm.main.model.AptItem
import com.swedio.mvvm.main.repository.MainViewRepository

class MainViewModel(repository: MainViewRepository): ViewModel() {

    // 청약 리스트 데이터
    private val _cyList = MutableLiveData<MutableList<AptItem>>()
    val cyList: LiveData<MutableList<AptItem>>
        get() = _cyList


    init {
        // 초기 리스트 호출
        _cyList.value = repository.loadCyList()
    }

    class Factory(private val application : Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(MainViewRepository.getInstance(application)!!) as T
        }
    }


}