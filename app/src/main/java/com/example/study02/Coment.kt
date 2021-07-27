package com.example.study02
import androidx.room.Entity
import androidx.room.*

@Entity
data class Coment (
    @PrimaryKey(autoGenerate = true) val comentid:Int,
    var username: String,
    var one: String,
    var two: String,
    var three: String,
    var x: String,
    var y: Int
        )


