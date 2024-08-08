package com.vik.assignmentandroiduae.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class University(
    val alpha_two_code: String?,
    val name: String?,
    val country: String?,
    val domains: List<String>?,
    @SerializedName("state-province")
    val state: String?,
    val web_pages: List<String>?
): Parcelable
