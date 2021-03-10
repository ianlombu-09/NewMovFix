package com.lexical.newmovfix.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.lexical.newmovfix.R
import com.lexical.newmovfix.data.api.ApiHelper
import com.lexical.newmovfix.ui.base.ViewModelFactory
import com.lexical.newmovfix.ui.main.viewmodel.HomeViewModel
import com.lexical.newmovfix.utils.Status

class HomeActivity : AppCompatActivity() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupViewModel()
        setupObserver()
    }

    private fun setupObserver() {
        homeViewModel.getMovies().observe(this, Observer {
            when(it.status) {
                Status.SUCCESS -> {
                    it.data
                }
            }
        })
    }

    private fun setupViewModel() {
        homeViewModel =ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(ApiServiceImpl()))
        ).get(HomeViewModel::class.java)
    }
}