package com.gahlot.wikipediaapi.data


import com.google.gson.annotations.SerializedName

data class Wiki_DCO(
    @SerializedName("batchcomplete")
    val batchcomplete: Boolean,
    @SerializedName("continue")
    val continueX: Continue,
    @SerializedName("query")
    val query: Query
)