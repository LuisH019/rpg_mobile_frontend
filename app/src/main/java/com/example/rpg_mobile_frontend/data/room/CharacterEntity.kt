package com.example.rpg_mobile_frontend.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "characters")
@TypeConverters(Converters::class)
data class CharacterEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val raceName: String,
    val className: String,
    val attributes: Map<String, Int>
)