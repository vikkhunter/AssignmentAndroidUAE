package com.vik.assignmentandroiduae.domain.usecases

import com.vik.assignmentandroiduae.domain.model.University
import com.vik.assignmentandroiduae.domain.repository.UniversityRepository
import javax.inject.Inject

class GetUniversitiesUseCase @Inject constructor(private val repository: UniversityRepository) {

    suspend fun execute(): List<University?> {
        return repository.refreshAndFetchUniversities()
    }
}
