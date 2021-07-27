package com.example.study02

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.room.Room
import com.example.study02.databinding.ActivityDatailBinding
import www.sanju.motiontoast.MotionToast
import java.text.SimpleDateFormat
import java.util.*


class DatailActivity : AppCompatActivity() {

    private var mBinding: ActivityDatailBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDatailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView7.setOnClickListener(){
            onBackPressed()     //클릭 시 전  Activity로 이동
        }

        val NationDB = Room.databaseBuilder(this, AppDatabase::class.java,"db").allowMainThreadQueries().build()  //main thread에서 실행 허용 함
        var code= NationDB.nationInterface().countNumber()     //title 가져오기
        var poso = intent.getStringExtra("number")!!.toInt()
        var l = code-poso    //데이터 베이스 id값 가져오기 l




        var title = NationDB.nationInterface().getTitle("$l")     //title 가져오기
        var description =NationDB.nationInterface().getdescription("$l")
        var time =NationDB.nationInterface().gettime("$l")
        var x =NationDB.nationInterface().getx("$l")
        var counter = x + 1
        NationDB.nationInterface().getcounter(counter,"$l")
        var xt = NationDB.nationInterface().getx("$l")
        binding.textView12.setText("$title")
        binding.textView13.setText("$description")
        binding.textView9.setText("$time")
        binding.textView11.setText("$xt")
        //coment 세팅 위에 BOX
        println(NationDB.nationInterface().getAll())

        val ComentDB = Room.databaseBuilder(this, ComentDatabase::class.java,"Cdb").allowMainThreadQueries().build()
       binding.imageView11.setOnClickListener {
           val commentText = binding.editTextTextPersonName2.getText()
           val sdf = SimpleDateFormat("M/dd hh시mm분")
           val currentDate = sdf.format(Date())
           var input = Coment(0,"admin","$currentDate","$commentText","three","$l",1)
           ComentDB.comentinterface().insert(input)
           finish()
           startActivity(getIntent())
       }
        //댓글 창 insert문

        var comentTitle= ComentDB.comentinterface().coment("$l")
        var comentTitlerever = comentTitle.reversed()
       binding.imageView6.setOnClickListener { finish()
            startActivity(getIntent()) }
        //새로고침 버튼



        val container = findViewById<LinearLayout>(R.id.addView_container)
        val inflater = LayoutInflater.from(this)
        for(i in 0 until comentTitlerever.size){

            // inflater로 item_view.xml 객체화
            val itemView = inflater.inflate(R.layout.coment_add, null)

            // item view에 내용 추가
            val carNameView = itemView.findViewById<TextView>(R.id.car_name)
            val carEngineView = itemView.findViewById<TextView>(R.id.car_engine)
            val textView22 =itemView.findViewById<TextView>(R.id.textView22)



            carNameView.text = comentTitlerever[i].username
            carEngineView.text = comentTitlerever[i].one
            textView22.text = comentTitlerever[i].two
            // 컨테이너에 아이템뷰 추가하기
            container.addView(itemView)
        }

       var countercoment = ComentDB.comentinterface().counterComent("$l")

        NationDB.nationInterface().ComentCounter("${countercoment}","$l")


        binding.imageView12.setOnClickListener {
        NationDB.nationInterface().deletecode("$l")
            MotionToast.createToast(this,
                "선택된 게시글이 삭제 되었습니다. 😍",
                "!게시판 내용이 수정 되었습니다!",
                MotionToast.TOAST_SUCCESS,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(this,R.font.helvetica_regular))
            val intentS = Intent(this,SubActivity::class.java)
            startActivity(intentS)
        } //delete query

    }



    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}