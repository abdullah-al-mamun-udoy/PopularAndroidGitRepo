package com.example.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RepositoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRepositories(repositories: List<RepositoryEntity>)

    @Query("SELECT * FROM repository_item")
    suspend fun getAllRepositories(): List<RepositoryEntity>

//    @Query("SELECT * FROM repository_item ORDER BY watchersCount DESC")
//    suspend fun getAllRepositories(): List<RepositoryEntity>

}