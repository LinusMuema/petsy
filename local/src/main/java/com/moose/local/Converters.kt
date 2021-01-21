package com.moose.local

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Converters {

    @TypeConverter
    fun toJson(list: List<String>): String = Json.encodeToString(list)

    @TypeConverter
    fun fromJson(json: String): List<String> = Json.decodeFromString(json)
}