package com.vik.assignmentandroiduae.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vik.assignmentandroiduae.data.model.UniversityEntity

@Dao
interface UniversityDao {
    @Query("SELECT * FROM university")
    suspend fun getAllUniversities(): List<UniversityEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUniversities(universities: List<UniversityEntity>)
}
