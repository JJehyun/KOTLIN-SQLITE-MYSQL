package com.example.study02

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface Comentinterface {

        @Query("SELECT * FROM Coment")
        fun getAll(): List<Coment>

        @Insert
        fun insert(coment: Coment)

        @Query("DELETE FROM Coment")
        fun deleteAll()

        @Query("SELECT username,one,two FROM Coment WHERE X = :code")
        fun coment(code: String):List<ComentTest>

        @Query("SELECT count(*) FROM Coment WHERE X = :comentid")
        fun counterComent(comentid: String): Int

        @Query("UPDATE Coment SET y = :a WHERE X = :code")
        fun setComent(a : Int,code :String)
}