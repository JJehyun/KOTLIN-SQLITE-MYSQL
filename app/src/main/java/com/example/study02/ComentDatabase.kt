package com.example.study02

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Coment::class],version = 1,exportSchema =false)
abstract class ComentDatabase: RoomDatabase() {
    abstract fun comentinterface() : Comentinterface
}