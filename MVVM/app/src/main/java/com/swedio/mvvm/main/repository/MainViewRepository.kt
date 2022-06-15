package com.swedio.mvvm.main.repository

import android.app.Application
import android.util.Log
import com.swedio.mvvm.main.model.AptItem
import com.swedio.mvvm.main.model.CyListResponseDTO
import com.swedio.mvvm.main.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewRepository(application: Application) {

    fun loadCyList(): MutableList<AptItem> {

        val cyListCall = RetrofitClient.api.getAPTLttotPblancDetail()
        var returnValue: MutableList<AptItem> = mutableListOf()

        cyListCall.enqueue(object : Callback<CyListResponseDTO> {
            override fun onResponse(
                call: Call<CyListResponseDTO>,
                response: Response<CyListResponseDTO>
            ) {
                Log.d("onResponse","response Code: " + response.code());
                // 성공했을 때 리스트 데이터 수신
                if (response.isSuccessful && response.code() == 200) {
                    returnValue = response.body()?.data ?: mutableListOf()

                } // end if

            }

            override fun onFailure(call: Call<CyListResponseDTO>, t: Throwable) {
                // 실패
                Log.e("onFail", t.stackTrace.toString())

            }

        })

        return returnValue
    }

    companion object {
        private var instance: MainViewRepository? = null

        fun getInstance(application : Application): MainViewRepository? {
            if (instance == null) instance = MainViewRepository(application)
            return instance
        }
    }
}