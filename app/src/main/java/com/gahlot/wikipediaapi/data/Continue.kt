package com.gahlot.wikipediaapi.data


import com.google.gson.annotations.SerializedName

data class Continue(
    @SerializedName("continue")
    val continueX: String,
    @SerializedName("gsroffset")
    val gsroffset: Int
)