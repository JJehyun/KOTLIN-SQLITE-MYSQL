package com.example.study02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.study02.databinding.ActivityMainBBinding

class MainActivityB : AppCompatActivity() {
    private var mBinding: ActivityMainBBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}