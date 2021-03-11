package com.lexical.newmovfix.data.api

import com.lexical.newmovfix.data.model.MovieModel
import com.lexical.newmovfix.data.model.MoviePopularResponse
import com.lexical.newmovfix.data.model.User
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getDetailMovie(): Response<MovieModel> = apiService.getDetailMovie()

    override suspend fun getPopularMovies(): Response<MoviePopularResponse> = apiService.getPopularMovies()
}