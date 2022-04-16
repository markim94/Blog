package com.swedio.bindingadapter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.swedio.bindingadapter.R
import com.swedio.bindingadapter.databinding.ActivityFirstBinding
import com.swedio.bindingadapter.viewmodel.FirstViewModel

class FirstActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding
    private val viewModel: FirstViewModel by lazy { ViewModelProvider(this).get(FirstViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_first)

        binding.apply {
            model = viewModel
            lifecycleOwner = this@FirstActivity

        }

    }
}