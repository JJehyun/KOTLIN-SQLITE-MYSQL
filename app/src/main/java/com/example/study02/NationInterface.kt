package com.example.study02
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface  NationInterface {
    @Query("SELECT * FROM Nation ORDER BY code DESC")
    fun getAll(): List<Nation>

    @Insert
    fun insert(nation : Nation)

    @Query("DELETE FROM Nation")
    fun deleteAll()

    @Query("DELETE FROM Nation WHERE code = :code")
    fun deleteByDate(code : Int)

    @Query("SELECT count(*) From Nation")
    fun countNumber() : Int      //return type은 : Int로 수정한다.

    @Query("SELECT title From Nation WHERE code = :code")
    fun getTitle(code :String) : String      //String title 가져오기

    @Query("SELECT description From Nation WHERE code = :code")
    fun getdescription(code :String) : String      //String description 가져오기

    @Query("SELECT time From Nation WHERE code = :code")
    fun gettime(code :String) : String      //String time 가져오기

    @Query("SELECT x FROM Nation WHERE code = :code")
    fun getx(code :String) : Int      //조회수 증가 쿼리

    @Query("UPDATE Nation SET x = :a WHERE code = :code")
    fun getcounter(a : Int,code :String) : Int      //조회수 증가 쿼리

    @Query("UPDATE Nation SET y = :coment WHERE code = :code")
    fun ComentCounter(coment : String, code : String)

    @Query("DELETE FROM Nation where code =:code")
    fun deletecode(code : String)

    @Query("UPDATE Nation SET code = :recode WHERE code = :code")
    fun UpdateCode(recode: String,code : String)

    @Query("SELECT count(*) FROM Nation")
    fun countcount() : Int
}