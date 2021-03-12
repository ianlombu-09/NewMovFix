package com.lexical.newmovfix.ui.main.viewmodel

import android.util.Log
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
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _movies = MutableLiveData<Resource<MovieModel>>()
    private val _popularMovies = MutableLiveData<Resource<MoviePopularResponse>>()
    private val compositeDisposable = CompositeDisposable()

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
            compositeDisposable.add(
                mainRepository.getPopularMovies()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        listMovies -> _popularMovies.postValue(Resource.success(listMovies))
                    }, { throwable ->
                        _popularMovies.postValue(Resource.error("Sorry, Try Again", null))
                    })
            )
            } else _movies.postValue(Resource.error("No Internet Connection", null))
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getPopularMovie(): LiveData<Resource<MoviePopularResponse>> {
        return _popularMovies
    }
}