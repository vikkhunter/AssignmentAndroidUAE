package com.vik.assignmentandroiduae.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "university")
data class UniversityEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @SerializedName("alpha_two_code")
    val alphaTwoCode: String?,
    val name: String?,
    val country: String?,
    val domains: List<String>?,
    @SerializedName("state-province")
    val state: String? = null,
    val web_pages: List<String>? = null
)
