package com.lexical.newmovfix.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lexical.newmovfix.data.model.MovieModel
import com.lexical.newmovfix.data.repository.MainRepository
import com.lexical.newmovfix.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val movies = MutableLiveData<Resource<List<MovieModel>>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        fetchMovies()
    }

    private fun fetchMovies() {

        movies.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainRepository.getMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ movieList ->
                    movies.postValue(Resource.success(movieList))
                }, { throwable ->
                    movies.postValue(Resource.error("Something Went Wrong", null))
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getMovies(): LiveData<Resource<List<MovieModel>>> {
        return movies
    }
}