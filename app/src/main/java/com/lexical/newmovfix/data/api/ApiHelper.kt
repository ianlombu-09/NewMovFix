package com.lexical.newmovfix.data.api

import com.lexical.newmovfix.data.model.MovieModel
import com.lexical.newmovfix.data.model.MoviePopularResponse
import retrofit2.Response

interface ApiHelper {

    suspend fun getPopularMovies(): Response<MoviePopularResponse>

    suspend fun getDetailMovie(): Response<MovieModel>
}