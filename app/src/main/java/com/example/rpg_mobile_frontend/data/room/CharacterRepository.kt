package com.example.rpg_mobile_frontend.data

import android.content.Context
import com.example.rpg_mobile_frontend.data.room.AppDatabase
import com.example.rpg_mobile_frontend.data.room.CharacterEntity

class CharacterRepository(context: Context) {
    private val db = AppDatabase.build(context)
    private val dao = db.characterDao()

    fun insertEntity(entity: CharacterEntity): Long {
        return dao.insert(entity)
    }

    fun getAllEntities(): List<CharacterEntity> {
        return dao.getAll()
    }
}