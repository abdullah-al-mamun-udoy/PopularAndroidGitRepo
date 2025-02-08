package com.example.util

import androidx.room.TypeConverter
import com.example.db.RepositoryEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    private val gson = Gson()

    // Convert List<ItemEntity> to JSON string
    @TypeConverter
    fun fromItemEntityList(value: List<RepositoryEntity>?): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toItemEntityList(value: String): List<RepositoryEntity>? {
        val listType = object : TypeToken<List<RepositoryEntity>>() {}.type
        return gson.fromJson(value, listType)
    }

    // Convert List<String> (topics) to a comma-separated string
    @TypeConverter
    fun fromStringList(value: List<String>?): String {
        return value?.joinToString(",") ?: ""
    }

    @TypeConverter
    fun toStringList(value: String): List<String>? {
        return if (value.isEmpty()) null else value.split(",")
    }

    // Convert OwnerEntity to JSON
    @TypeConverter
    fun fromOwnerEntity(value: RepositoryEntity.OwnerEntity?): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toOwnerEntity(value: String): RepositoryEntity.OwnerEntity? {
        return gson.fromJson(value, RepositoryEntity.OwnerEntity::class.java)
    }

    // Convert LicenseEntity to JSON
    @TypeConverter
    fun fromLicenseEntity(value: RepositoryEntity.LicenseEntity?): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toLicenseEntity(value: String): RepositoryEntity.LicenseEntity? {
        return gson.fromJson(value, RepositoryEntity.LicenseEntity::class.java)
    }
}
