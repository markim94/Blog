package com.swedio.bindingadapter.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.swedio.openapiproject.network.CyApiService
import com.swedio.openapiproject.network.RetrofitClient
import com.swedio.bindingadapter.network.responseDTO.AptItem
import com.swedio.bindingadapter.network.responseDTO.AptLttotPblancDetailDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ThirdViewModel : ViewModel() {

    private val _cyListItems: MutableLiveData<MutableList<AptItem>> by lazy {
        MutableLiveData<MutableList<AptItem>>()

    }

    fun getCyListItems(): LiveData<MutableList<AptItem>> {
        return _cyListItems
    }

    private fun updateCyListItems(aptItems: MutableList<AptItem>) {
        _cyListItems.value = aptItems
    }


    fun onClickSearchListButton() {
        val cyListService = RetrofitClient.getInstance().create(CyApiService::class.java)
        val listCall = cyListService.getAPTLttotPblancDetail()

        listCall.enqueue(object : Callback<AptLttotPblancDetailDTO> {
            override fun onResponse(
                call: Call<AptLttotPblancDetailDTO>,
                response: Response<AptLttotPblancDetailDTO>
            ) {
                Log.d("onResponse","response Code: " + response.code());
                if (response.isSuccessful && response.code() == 200) {
                    updateCyListItems(response.body()?.data ?: mutableListOf())

                } // end if

            }

            override fun onFailure(call: Call<AptLttotPblancDetailDTO>, t: Throwable) {
                // 실패
                Log.e("onFail", t.stackTrace.toString());

            }

        })

    }


}