package com.swedio.bindingadapter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.swedio.bindingadapter.R
import com.swedio.bindingadapter.databinding.ActivityFirstBinding
import com.swedio.bindingadapter.databinding.ActivitySecondBinding
import com.swedio.bindingadapter.viewmodel.FirstViewModel
import com.swedio.bindingadapter.viewmodel.SecondViewModel

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private val viewModel: SecondViewModel by lazy { ViewModelProvider(this).get(SecondViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)

        binding.apply {
            model = viewModel
            lifecycleOwner = this@SecondActivity

        }


    }
}