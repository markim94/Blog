package com.swedio.bindingadapter.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.swedio.bindingadapter.R
import com.swedio.bindingadapter.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.btn1.setOnClickListener {
            startActivity(Intent(this@HomeActivity, FirstActivity::class.java))

        }

        binding.btn2.setOnClickListener {
            startActivity(Intent(this@HomeActivity, SecondActivity::class.java))

        }

        binding.btn3.setOnClickListener {
            startActivity(Intent(this@HomeActivity, ThirdActivity::class.java))

        }

    }
}