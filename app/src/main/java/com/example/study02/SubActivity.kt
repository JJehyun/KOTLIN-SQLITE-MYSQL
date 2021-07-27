package com.example.study02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.study02.databinding.ActivitySubBinding



class SubActivity : AppCompatActivity() {
    private var mBinding: ActivitySubBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val NationDB = Room.databaseBuilder(this, AppDatabase::class.java,"db").allowMainThreadQueries().build()  //main thread에서 실행 허용 함
        val ComentDB = Room.databaseBuilder(this, ComentDatabase::class.java,"Cdb").allowMainThreadQueries().build()
        lateinit var BoardAdapter: BoardAdapter
        val datas = mutableListOf<BoardData>()

        BoardAdapter = BoardAdapter(this)
        binding.rvProfile.adapter = BoardAdapter
        for(i in NationDB.nationInterface().getAll()) {
            datas.apply {
                add(
                    BoardData(
                        img = R.drawable.boardmessenger,
                        name = "${i.title}",
                        age = "${i.description}",
                        nameone = "${i.time}",
                        nametwo = "${i.userID}",
                        counter = "${i.x}",
                        counterComent = "${i.y}"
                    )
                )
            }
        }
        BoardAdapter.datas = datas
        BoardAdapter.notifyDataSetChanged()

        binding.textView.setOnClickListener {
            val intentS = Intent(this,MainActivity::class.java)
            startActivity(intentS)
        }








        
        
        
        binding.imageView5.setOnClickListener {                                //글쓰기 intent
            val intentS = Intent(this,WriteActivity::class.java)
            startActivity(intentS)
        }
    }
    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}