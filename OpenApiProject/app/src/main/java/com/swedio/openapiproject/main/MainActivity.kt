package com.swedio.openapiproject.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.swedio.openapiproject.R
import com.swedio.openapiproject.databinding.ActivityMainBinding
import com.swedio.openapiproject.main.adapter.CyListAdapter
import com.swedio.openapiproject.network.RetrofitClient
import com.swedio.openapiproject.network.responseDTO.AptLttotPblancDetailDTO
import com.swedio.openapiproject.network.CyApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var cyListAdapter: CyListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initView()

    }

    private fun initView() {

        cyListAdapter = CyListAdapter()
        binding.rvCyList.apply {
            adapter = cyListAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)

        }

        binding.tvBtnSearch.setOnClickListener {
            requestAptCyList()
        }

    }


    private fun requestAptCyList() {
        val cyListService = RetrofitClient.getInstance().create(CyApiService::class.java)
        val listCall = cyListService.getAPTLttotPblancDetail()

        listCall.enqueue(object : Callback<AptLttotPblancDetailDTO> {
            override fun onResponse(
                call: Call<AptLttotPblancDetailDTO>,
                response: Response<AptLttotPblancDetailDTO>
            ) {
                if (response.isSuccessful && response.code() == 200) {
                    cyListAdapter?.let {
                        it.setAptListItem(response.body()?.data ?: mutableListOf())
                    }

                } else {
                    Toast.makeText(this@MainActivity, "response Code : " + response.code() + "\n???????????? ????????? ?????? ????????? ???????????????.", Toast.LENGTH_SHORT).show()

                }
            }

            override fun onFailure(call: Call<AptLttotPblancDetailDTO>, t: Throwable) {
                // ??????
                Log.e("onFail", t.stackTrace.toString());

            }

        })
    }
}
