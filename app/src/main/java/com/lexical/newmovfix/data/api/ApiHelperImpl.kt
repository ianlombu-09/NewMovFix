package com.lexical.newmovfix.data.api

import com.lexical.newmovfix.data.model.MovieResponse
import io.reactivex.Single
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override fun getMovies(): Single<MovieResponse> = apiService.getMovies()
}