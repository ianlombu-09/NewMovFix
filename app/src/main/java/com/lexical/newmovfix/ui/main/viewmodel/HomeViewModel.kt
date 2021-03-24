package com.lexical.newmovfix.ui.main.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lexical.newmovfix.data.model.MovieModel
import com.lexical.newmovfix.data.model.MoviePopularResponse
import com.lexical.newmovfix.data.repository.MainRepository
import com.lexical.newmovfix.utils.NetworkHelper
import com.lexical.newmovfix.utils.Resource
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _movies = MutableLiveData<Resource<MovieModel>>()
    private val _popularMovies = MutableLiveData<Resource<MoviePopularResponse>>()

    val movies: LiveData<Resource<MovieModel>>
        get() = _movies

    val popularMovies: LiveData<Resource<MoviePopularResponse>>
        get() = _popularMovies

    init {
        //fetchDetailMovie()
        fetchPopularMovies()
    }

    private fun fetchDetailMovie() {
        viewModelScope.launch {
            _movies.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getDetailMovie().let {
                    if (it.isSuccessful) {
                        _movies.postValue(Resource.success(it.body()))
                    } else _movies.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _movies.postValue(Resource.error("No Internet Connection", null))
        }
    }

    private fun fetchPopularMovies() {
        viewModelScope.launch {
            _popularMovies.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getPopularMovies().let {
                    if (it.isSuccessful) {
                        _popularMovies.postValue(Resource.success(it.body()))
                    } else _popularMovies.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _popularMovies.postValue(Resource.error("No Internet Connection", null))
        }
    }
}