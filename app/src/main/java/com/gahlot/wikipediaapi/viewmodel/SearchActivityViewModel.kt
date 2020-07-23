package com.gahlot.wikipediaapi.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.gahlot.wikipediaapi.data.Page
import com.gahlot.wikipediaapi.repository.SearchActivityRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit


class SearchActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val TAG = "SearchActivityViewModel"

    private val repository = SearchActivityRepository(application)
    val showProgress : LiveData<Boolean>
    val searchResults : LiveData<List<Page>>
    private val compositeDisposable = CompositeDisposable()

    init {
        this.showProgress = repository.showProgress
        this.searchResults = repository.searchResults
    }

    fun chagestate() {
        repository.changeState()
    }

    fun searchWikipedia(searchString: String) {
        Log.i(TAG, "subscribeToSeach: this was called")
        repository.searchWikipedia(searchString)
    }
}