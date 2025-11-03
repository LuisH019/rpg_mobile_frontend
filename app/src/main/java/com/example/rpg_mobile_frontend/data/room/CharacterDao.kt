package com.example.rpg_mobile_frontend.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CharacterDao {
    @Insert
    fun insert(character: CharacterEntity): Long

    @Query("SELECT * FROM characters")
    fun getAll(): List<CharacterEntity>
}