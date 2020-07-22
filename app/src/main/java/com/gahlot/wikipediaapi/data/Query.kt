package com.gahlot.wikipediaapi.data


import com.gahlot.wikipediaapi.data.Page
import com.google.gson.annotations.SerializedName

data class Query(
    @SerializedName("pages")
    val pages: List<Page>
)