package com.gahlot.wikipediaapi.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.gahlot.wikipediaapi.data.Page
import com.gahlot.wikipediaapi.repository.SearchActivityRepository

class SearchActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = SearchActivityRepository(application)
    val showProgress : LiveData<Boolean>
    val searchResults : LiveData<List<Page>>

    init {
        this.showProgress = repository.showProgress
        this.searchResults = repository.searchResults
    }

    fun chagestate() {
        repository.changeState()
    }

    fun searchWikipedia(searchString: String) {
        repository.searchWikipedia(searchString)
    }

}