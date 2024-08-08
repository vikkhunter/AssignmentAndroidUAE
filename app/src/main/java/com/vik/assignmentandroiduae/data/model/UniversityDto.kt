package com.vik.assignmentandroiduae.data.model



data class UniversityDto(
    val id: Int,  // Use correct field names based on API response
    val alpha_two_code: String? = null,
    val name: String? = null,
    val country: String? = null,
    val domains: List<String>? = null,
    val state: String? = null,
    val webPages: List<String>? = null
)
