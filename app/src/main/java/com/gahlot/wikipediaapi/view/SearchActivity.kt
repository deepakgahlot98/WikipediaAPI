package com.gahlot.wikipediaapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gahlot.wikipediaapi.R
import com.gahlot.wikipediaapi.adapter.SearchResultAdapter
import com.gahlot.wikipediaapi.viewmodel.SearchActivityViewModel
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    private lateinit var viewModel: SearchActivityViewModel
    private lateinit var adapter: SearchResultAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        viewModel = ViewModelProvider(this).get(SearchActivityViewModel::class.java)

        // added initially to test the api and adapter
        iv_search.setOnClickListener {
            if (et_search.text!!.isNotEmpty())
                viewModel.searchWikipedia(et_search.text.toString())
        }

        viewModel.showProgress.observe(this, Observer {
            if (it) {
                search_progress.visibility = View.VISIBLE
            } else {
                search_progress.visibility = View.GONE
            }
        })

        viewModel.searchResults.observe(this, Observer {
            adapter.setLocationList(it)
        })

        adapter = SearchResultAdapter(this)
        rv_search.adapter = adapter

        // using a text watcher to show the search result based on the user input
        et_search.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (s.length > 2) {
                    viewModel.searchWikipedia(s.toString())
                } else if (s.isEmpty()) {
                    adapter.resetList()
                }
            }
        })

    }
}