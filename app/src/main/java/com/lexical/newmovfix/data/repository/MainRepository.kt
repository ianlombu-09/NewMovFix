package com.lexical.newmovfix.data.repository

import com.lexical.newmovfix.data.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getDetailMovie() = apiHelper.getDetailMovie()
    suspend fun getPopularMovies() = apiHelper.getPopularMovies()
}