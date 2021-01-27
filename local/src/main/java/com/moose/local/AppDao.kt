package com.moose.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAnimal(animal: Animal)

    @Query("SELECT * FROM animal WHERE name=:name")
    fun getAnimal(name: String): Flow<Animal>
}