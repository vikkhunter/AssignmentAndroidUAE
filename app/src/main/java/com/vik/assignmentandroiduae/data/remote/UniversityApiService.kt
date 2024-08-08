package com.vik.assignmentandroiduae.data.remote

import com.vik.assignmentandroiduae.data.model.UniversityDto
import retrofit2.http.GET
import retrofit2.http.Query

interface UniversityApiService {
    @GET("search")
    suspend fun getUniversities(@Query("country") country: String = "United Arab Emirates"): List<UniversityDto>
}
