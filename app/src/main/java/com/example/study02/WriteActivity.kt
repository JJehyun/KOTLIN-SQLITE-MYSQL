package com.example.study02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import androidx.room.Room
import com.example.study02.databinding.ActivityWriteBinding
import www.sanju.motiontoast.MotionToast
import java.text.SimpleDateFormat
import java.util.*

class WriteActivity : AppCompatActivity() {
    private var mBinding: ActivityWriteBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView5.setOnClickListener(){
            onBackPressed()     //클릭 시 전  Activity로 이동
        }


        binding.textView4.setOnClickListener {
            val sdf = SimpleDateFormat("M월dd일 hh시mm분")
            val currentDate = sdf.format(Date())                          //현재 시간 받아우기
            var title = binding.editTextTextPersonName.getText()          //타이틀 가져오기
            var description = binding.editTextTextMultiLine2.getText()    //본문 가져오기

            val NationDB = Room.databaseBuilder(this, AppDatabase::class.java,"db").allowMainThreadQueries().build()  //main thread에서 실행 허용 함
            var ss = NationDB.nationInterface().countcount()
            var sss = ss + 1
            var input = Nation(sss,"$title","$description","admin","$currentDate","je",1,0)
            NationDB.nationInterface().insert(input)   // 데이터 베이스에 글 추가

            MotionToast.createToast(this,
                "글 작성이 완료 되었습니다. 😍",
                "!게시판 내용이 수정 되었습니다!",
                MotionToast.TOAST_SUCCESS,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(this,R.font.helvetica_regular))
                val intentS = Intent(this,SubActivity::class.java)
                startActivity(intentS)
        }



    }




    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}