package com.example.study02
import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Nation::class],version = 1,exportSchema =false)
abstract class AppDatabase:RoomDatabase() {
    abstract fun nationInterface() : NationInterface


}