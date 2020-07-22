package com.gahlot.wikipediaapi.api

import com.gahlot.wikipediaapi.data.Wiki_DCO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


const val BASE_URL = "https://en.wikipedia.org/w/"

interface WikipediaNetwork {

    @GET("api.php?action=query&format=json&prop=pageimages|pageterms|info&generator=search&formatversion=2&inprop=url&")
    fun getSearchResult(@Query("gsrsearch")searchString : String) : Call<Wiki_DCO>
}