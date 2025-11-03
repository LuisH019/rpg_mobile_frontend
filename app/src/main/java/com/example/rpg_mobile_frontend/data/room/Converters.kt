package com.example.rpg_mobile_frontend.data.room

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromMap(map: Map<String, Int>?): String {
        if (map == null || map.isEmpty()) return ""
        return map.entries.joinToString(",") { "${it.key}:${it.value}" }
    }

    @TypeConverter
    fun toMap(value: String?): Map<String, Int> {
        if (value.isNullOrBlank()) return emptyMap()
        return value.split(",").associate {
            val parts = it.split(":")
            parts[0] to parts[1].toInt()
        }
    }
}