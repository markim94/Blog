package com.swedio.bindingadapter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.swedio.bindingadapter.R
import com.swedio.bindingadapter.adapter.CyListAdapter
import com.swedio.bindingadapter.databinding.ActivityThirdBinding
import com.swedio.bindingadapter.viewmodel.ThirdViewModel

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    private val viewModel by lazy { ViewModelProvider(this).get(ThirdViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityThirdBinding?>(this, R.layout.activity_third).apply {
            model = viewModel
            lifecycleOwner = this@ThirdActivity
        }

        binding.rvCyList.apply {
            adapter = CyListAdapter()
            layoutManager = LinearLayoutManager(this@ThirdActivity)

        }

    }

}