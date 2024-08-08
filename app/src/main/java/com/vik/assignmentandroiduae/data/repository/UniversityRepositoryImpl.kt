package com.vik.assignmentandroiduae.data.repository

import android.content.Context
import android.util.Log
import com.vik.assignmentandroiduae.data.local.UniversityDatabase
import com.vik.assignmentandroiduae.data.model.mapFromDto
import com.vik.assignmentandroiduae.data.model.toEntity
import com.vik.assignmentandroiduae.data.model.toUniversityModel
import com.vik.assignmentandroiduae.data.remote.UniversityApiService
import com.vik.assignmentandroiduae.domain.model.University
import com.vik.assignmentandroiduae.domain.repository.UniversityRepository
import com.vik.assignmentandroiduae.utils.isNetworkAvailable
import java.io.IOException
import javax.inject.Inject

class UniversityRepositoryImpl @Inject constructor(
    private val apiService: UniversityApiService,
    private val database: UniversityDatabase, // or other data sources
) : UniversityRepository {

    override suspend fun refreshAndFetchUniversities(): List<University?> {
        return try {
            // Fetching data from the API
            val response = apiService.getUniversities()

            Log.d("TAG", "refreshAndFetchUniversities: ${response.size}")

            // Convert DTOs to Entities for caching
            val universities = response.map { dto ->
                dto.toEntity()
            }

            // Cache data in the database
            database.universityDao().insertUniversities(universities)

            // Return the data mapped to domain models
            response.map { mapFromDto(it) }
        } catch (e: IOException) {
            // Handle exceptions related to network issues
            // Log the error if needed

            Log.d("TAG", "refreshAndFetchUniversities: ${e.message}")

            database.universityDao().getAllUniversities().map { entity ->
                entity.toUniversityModel()
            }
        }
    }

}
