package com.lexical.newmovfix.data.api

import com.lexical.newmovfix.data.model.MovieResponse
import io.reactivex.Single

interface ApiHelper {
    fun getMovies(): Single<MovieResponse>
}