package com.vik.assignmentandroiduae.domain.repository

import com.vik.assignmentandroiduae.domain.model.University


interface UniversityRepository {
    suspend fun refreshAndFetchUniversities(): List<University?>
}
