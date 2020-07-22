package com.gahlot.wikipediaapi.data


import com.google.gson.annotations.SerializedName

data class Terms(
    @SerializedName("alias")
    val alias: List<String>,
    @SerializedName("description")
    val description: List<String>,
    @SerializedName("label")
    val label: List<String>
)