package com.vik.assignmentandroiduae.data.remote

import com.vik.assignmentandroiduae.data.model.UniversityDto
import javax.inject.Inject

class UniversityRemoteDataSource @Inject constructor(
    private val apiService: UniversityApiService
) {
    suspend fun fetchUniversities(country: String): List<UniversityDto> {
        return apiService.getUniversities(country)
    }
}
