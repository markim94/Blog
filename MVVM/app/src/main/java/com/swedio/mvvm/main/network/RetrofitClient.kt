package com.swedio.mvvm.main.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    /* Open API End Point Url */
    private const val BASE_URL = "https://api.odcloud.kr/api/ApplyhomeInfoDetailSvc/v1/"
    private var instance: Retrofit? = null

    open fun getInstance() : Retrofit {
        if (instance == null) {
            instance = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        } // end if

        return instance!!
    }

    val api: CyApiService by lazy { getInstance().create(CyApiService::class.java) }

}