package com.example.study02

import androidx.room.Entity

import androidx.room.*

@Entity
data class Nation(             //클래스 이름이 테이블 name임
    @PrimaryKey(autoGenerate = true) val code:Int,   // autoGenerate = true 0값으로 넣었을 때 자동증가함 ID
    var title: String,
    var description: String,
    var userID: String,
    var time: String,
    var je:String,
    var x: Int,
    var y: Int
)