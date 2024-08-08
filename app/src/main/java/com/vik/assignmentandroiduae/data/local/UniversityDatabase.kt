package com.vik.assignmentandroiduae.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.vik.assignmentandroiduae.data.model.Converters
import com.vik.assignmentandroiduae.data.model.UniversityEntity

@Database(entities = [UniversityEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class UniversityDatabase : RoomDatabase() {
    abstract fun universityDao(): UniversityDao
}
