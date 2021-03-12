package com.lexical.newmovfix.data.api

import com.lexical.newmovfix.data.model.MovieModel
import com.lexical.newmovfix.data.model.MoviePopularResponse
import io.reactivex.Single
import retrofit2.Response

interface ApiHelper {

    fun getPopularMovies(): Single<MoviePopularResponse>

    suspend fun getDetailMovie(): Response<MovieModel>
}