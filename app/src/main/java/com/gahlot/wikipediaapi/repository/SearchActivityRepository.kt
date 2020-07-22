package com.gahlot.wikipediaapi.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.gahlot.wikipediaapi.api.BASE_URL
import com.gahlot.wikipediaapi.api.WikipediaNetwork
import com.gahlot.wikipediaapi.data.Page
import com.gahlot.wikipediaapi.data.Wiki_DCO
import com.gahlot.wikipediaapi.db.AppDatabase
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class SearchActivityRepository(val application: Application) {

    private val TAG = "SearchActivityRepositor"
    val showProgress = MutableLiveData<Boolean>()
    val searchResults = MutableLiveData<List<Page>>()
    private lateinit var appDatabase: AppDatabase

    fun changeState() {
        showProgress.value = !(showProgress.value != null && showProgress.value!!)
    }

    fun searchWikipedia(searchString: String) {
        showProgress.value = true

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
        
        val service = retrofit.create(WikipediaNetwork::class.java)

        service.getSearchResult(searchString).enqueue(object : Callback<Wiki_DCO> {
            override fun onFailure(call: Call<Wiki_DCO>, t: Throwable) {
                showProgress.value = false
                Toast.makeText(application, "Error while accessing the API",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Wiki_DCO>, response: Response<Wiki_DCO>) {
                searchResults.value = response.body()?.query?.pages
                showProgress.value = false
                Log.d(TAG, "onResponse: ${Gson().toJson(response.body())}")
            }
        })
    }

}