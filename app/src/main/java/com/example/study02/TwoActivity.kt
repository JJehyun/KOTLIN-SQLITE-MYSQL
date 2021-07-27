package com.example.study02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.study02.databinding.ActivityTwoBinding


class TwoActivity : AppCompatActivity() {
    private var mBinding: ActivityTwoBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lateinit var profileAdapter: PotoboardAdapter
        val datas = mutableListOf<PotoboardData>()

        fun initRecycler() {
            profileAdapter = PotoboardAdapter(this)
            binding.rvProfile.adapter = profileAdapter


            datas.apply {
                add(PotoboardData(img = R.drawable.heart1, name = "free board", age = "첫 게시글"))
                add(PotoboardData(img = R.drawable.heart1, name = "free board", age = "두번째 게시글"))
                add(PotoboardData(img = R.drawable.heart1, name = "free board", age = "세번째 게시글"))
                add(PotoboardData(img = R.drawable.heart1, name = "free board", age = "네번째 게시글"))
                add(PotoboardData(img = R.drawable.heart1, name = "free board", age = "다섯 게시글"))

                profileAdapter.datas = datas
                profileAdapter.notifyDataSetChanged()

            }
        }
        initRecycler()
    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}