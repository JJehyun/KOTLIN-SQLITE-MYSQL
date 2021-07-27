package com.example.study02

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.study02.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)





        binding.IntendG.setOnClickListener {
            val intentS = Intent(this, SubActivity::class.java)
            startActivity(intentS)
        }

        binding.button.setOnClickListener {
            val intentS = Intent(this, TwoActivity::class.java)
            startActivity(intentS)
        }







    }
    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}