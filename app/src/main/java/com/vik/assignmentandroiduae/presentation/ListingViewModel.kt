package com.vik.assignmentandroiduae.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vik.assignmentandroiduae.domain.model.University
import com.vik.assignmentandroiduae.domain.usecases.GetUniversitiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListingViewModel @Inject constructor(
    private val getUniversitiesUseCase: GetUniversitiesUseCase
) : ViewModel() {

    private val _universities = MutableStateFlow<List<University?>>(emptyList())
    val universities: StateFlow<List<University?>> = _universities

    init {
        fetchUniversities()
    }

    fun fetchUniversities() {
        viewModelScope.launch {
            _universities.value = getUniversitiesUseCase.execute()
        }
    }
}
