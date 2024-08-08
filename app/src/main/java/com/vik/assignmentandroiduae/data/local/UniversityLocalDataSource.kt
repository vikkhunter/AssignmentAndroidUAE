package com.vik.assignmentandroiduae.data.local

import com.vik.assignmentandroiduae.data.model.UniversityEntity
import javax.inject.Inject

class UniversityLocalDataSource @Inject constructor(
    private val universityDao: UniversityDao
) {
    suspend fun getUniversities(): List<UniversityEntity> {
        return universityDao.getAllUniversities()
    }

    suspend fun saveUniversities(universities: List<UniversityEntity>) {
        universityDao.insertUniversities(universities)
    }
}
